package com.re.rest;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.googlecode.androidannotations.api.rest.MediaType;
import com.googlecode.androidannotations.annotations.rest.Accept;
import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;
import com.re.protocol.responses.GetItemsByLocationResponse;

@Rest(converters = MappingJackson2HttpMessageConverter.class)
public interface RestClient {

	RestTemplate getRestTemplate();
	
	void setRootUrl(String rootUrl);
	
    @Get("/items/list?lat={lat}&lon={lon}")
    @Accept(MediaType.APPLICATION_JSON)
    GetItemsByLocationResponse getItemsByLocation(long lat, long lon);
	
//	public void setHttpBasicAuth(String username, String password);
	

	//	@Get("/")
	//    public abstract void main();

	//	void setRootUrl(String rootUrl);


	//	@Post("/user/settings")
	//    @Accept(MediaType.APPLICATION_JSON)
	//    BasicResponse updateSettings(UserSettings settings);
	//


	//	@Delete("/user/following/{userId}")
	//    void unfollowUser(long userId);

	//	@Put("/user/equalizer/tags")
	//    void updateGenreState(GenreItemBean genre);


}
