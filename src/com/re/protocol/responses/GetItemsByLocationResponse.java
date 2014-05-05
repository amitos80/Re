package com.re.protocol.responses;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.re.beans.Item;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetItemsByLocationResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4525021079622730015L;
	
	
	public ArrayList<Item> items;
}
