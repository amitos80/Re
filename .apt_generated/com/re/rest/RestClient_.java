//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package com.re.rest;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestClient_
    implements RestClient
{

    private RestTemplate restTemplate;
    private String rootUrl;

    public RestClient_() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rootUrl = "";
    }

    @Override
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

}