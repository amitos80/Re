package com.re.protocol.requests;

import java.io.Serializable;

public class GetItemsByLocationRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1717335030631022525L;
	
	public long lat;
	public long lon;
}
