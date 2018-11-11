package nyc.aisleone.paginationexample.utils;

import java.io.IOException;

import nyc.aisleone.paginationexample.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class Retrofit2Client {
    private static Retrofit2Client instance = null;
    private Retrofit retrofit;
    private OkHttpClient client;

    private NewsService newsService;

    public Retrofit2Client() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder();
        okhttpBuilder.addInterceptor(loggingInterceptor);

        okhttpBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original
                        .newBuilder()
                        .header("Authorization", BuildConfig.NewsApiKey);
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        client = okhttpBuilder.build();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(client)
                .build();

        newsService = retrofit.create(NewsService.class);
    }

    public static Retrofit2Client getInstance() {
        if (instance == null) {
            instance = new Retrofit2Client();
        }
        return instance;
    }

    public NewsService getNewsService() {
        return newsService;
    }

}
