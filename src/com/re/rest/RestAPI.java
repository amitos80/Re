package com.re.rest;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.rest.RestService;
import com.googlecode.androidannotations.api.Scope;

@EBean(scope = Scope.Singleton)
public class RestAPI {
	
	@RestService
	public static RestClient restClient;
	
	public static RestClient getRestClient(){
		if (restClient == null){
			restClient = new RestClient_();
		}

		return restClient;
	}

//	public static String getAuthToken() {
//		return EQualaAuthInterceptor.getInstance().getAuthToken();
//	}
//	
//	public static void configureRestClient(String authToken){
//		RestTemplate restTemplate = getRestClient().getRestTemplate();
//		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
//		EQualaAuthInterceptor.getInstance().setAuthToken(authToken);
//		interceptors.add(EQualaAuthInterceptor.getInstance());
//		restTemplate.setInterceptors(interceptors);
//
//		int timout = 30000;
//		if(EqualaApplication.getInstance().getSettingsBean() != null){
//			timout = (int)EqualaApplication.getInstance().getSettingsBean().getClient_timeout_ms(); 
//		}
//		ClientHttpRequestFactory requestFactory = restTemplate.getRequestFactory();
//		if (requestFactory instanceof SimpleClientHttpRequestFactory) {
//			((SimpleClientHttpRequestFactory) requestFactory).setConnectTimeout(timout);
//			((SimpleClientHttpRequestFactory) requestFactory).setReadTimeout(timout);
//		} else if (requestFactory instanceof HttpComponentsClientHttpRequestFactory) {
//			((HttpComponentsClientHttpRequestFactory) requestFactory).setReadTimeout(timout);
//			((HttpComponentsClientHttpRequestFactory) requestFactory).setConnectTimeout(timout);
//		}
//	}

}
