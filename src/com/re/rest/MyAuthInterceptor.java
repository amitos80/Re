package com.re.rest;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

public class MyAuthInterceptor {

	private static MyAuthInterceptor reMyAuthInterceptor;
	private static String authToken;
	
	public static MyAuthInterceptor getInstance(){
		if(reMyAuthInterceptor == null){
			reMyAuthInterceptor = new MyAuthInterceptor();
		}
		return reMyAuthInterceptor;
	}
	
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.add("Cookie", "connect.sid=" + authToken);        
        return execution.execute(request, body);
    }
    
    public void setAuthToken(String authToken1){
    	authToken = authToken1;
    }

    public String getAuthToken(){
    	return authToken;
    }

}
