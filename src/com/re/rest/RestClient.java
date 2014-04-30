package com.re.rest;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.googlecode.androidannotations.annotations.rest.Rest;

@Rest(converters = MappingJackson2HttpMessageConverter.class)
public interface RestClient {

	RestTemplate getRestTemplate();
	
//	public void setHttpBasicAuth(String username, String password);
	

	//	@Get("/")
	//    public abstract void main();

	//	void setRootUrl(String rootUrl);


	//	@Post("/user/settings")
	//    @Accept(MediaType.APPLICATION_JSON)
	//    BasicResponse updateSettings(UserSettings settings);
	//
	//    @Get("/user/feed/{userId}?start_index={startIndex}&max_results={maxResults}&start_date={startDate}")
	//    @Accept(MediaType.APPLICATION_JSON)
	//    FeedResponse getUserFeed(long userId, long startIndex, int maxResults, long startDate);

	//	@Delete("/user/following/{userId}")
	//    void unfollowUser(long userId);

	//	@Put("/user/equalizer/tags")
	//    void updateGenreState(GenreItemBean genre);


}
