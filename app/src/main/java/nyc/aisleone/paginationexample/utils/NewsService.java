package nyc.aisleone.paginationexample.utils;

import nyc.aisleone.paginationexample.models.TopHeadlines;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {


    @GET("top-headlines?country=us")
    Call<TopHeadlines> loadTopHeadlines();
}
