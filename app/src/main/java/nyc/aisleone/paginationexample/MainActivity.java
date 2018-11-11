package nyc.aisleone.paginationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import nyc.aisleone.paginationexample.adapters.TopHeadlinesAdapter;
import nyc.aisleone.paginationexample.models.TopHeadlines;
import nyc.aisleone.paginationexample.utils.NewsService;
import nyc.aisleone.paginationexample.utils.Retrofit2Client;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView topHeadlinesRecyclerView;
    private TopHeadlinesAdapter topHeadlinesAdapter;
    static NewsService newsService = Retrofit2Client.getInstance().getNewsService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topHeadlinesRecyclerView = findViewById(R.id.rv_top_headlines);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        topHeadlinesRecyclerView.setLayoutManager(layoutManager);

        topHeadlinesAdapter = new TopHeadlinesAdapter();


        Call<TopHeadlines> topHeadlinesCall = newsService.loadTopHeadlines();

        topHeadlinesCall.enqueue(new Callback<TopHeadlines>() {
            @Override
            public void onResponse(Call<TopHeadlines> call, Response<TopHeadlines> response) {

            }

            @Override
            public void onFailure(Call<TopHeadlines> call, Throwable t) {
                Log.d("RETRO", "onFailure: " + t.getMessage());
                t.printStackTrace();
            }
        });


    }
}
