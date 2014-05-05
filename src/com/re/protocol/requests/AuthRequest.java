package com.re.protocol.requests;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2220200805915139652L;

	public AuthRequest() {}
	
	@JsonProperty("access_token")
	private String access_token;

}
