package nyc.aisleone.paginationexample.models;

import java.util.List;
import com.squareup.moshi.Json;

public class TopHeadlines{

	@Json(name = "totalResults")
	private int totalResults;

	@Json(name = "articles")
	private List<ArticlesItem> articles;

	@Json(name = "status")
	private String status;

	public int getTotalResults(){
		return totalResults;
	}

	public List<ArticlesItem> getArticles(){
		return articles;
	}

	public String getStatus(){
		return status;
	}
}