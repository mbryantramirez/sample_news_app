package nyc.aisleone.paginationexample.models;

import com.squareup.moshi.Json;

public class ArticlesItem{

	@Json(name = "publishedAt")
	private String publishedAt;

	@Json(name = "author")
	private String author;

	@Json(name = "urlToImage")
	private String urlToImage;

	@Json(name = "description")
	private String description;

	@Json(name = "source")
	private Source source;

	@Json(name = "title")
	private String title;

	@Json(name = "url")
	private String url;

	@Json(name = "content")
	private String content;

	public String getPublishedAt(){
		return publishedAt;
	}

	public String getAuthor(){
		return author;
	}

	public String getUrlToImage(){
		return urlToImage;
	}

	public String getDescription(){
		return description;
	}

	public Source getSource(){
		return source;
	}

	public String getTitle(){
		return title;
	}

	public String getUrl(){
		return url;
	}

	public String getContent(){
		return content;
	}
}