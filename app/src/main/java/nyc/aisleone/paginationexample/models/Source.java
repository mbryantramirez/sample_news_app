package nyc.aisleone.paginationexample.models;

import com.squareup.moshi.Json;

public class Source{

	@Json(name = "name")
	private String name;

	@Json(name = "id")
	private String id;

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}
}