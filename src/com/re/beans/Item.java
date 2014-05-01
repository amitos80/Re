package com.re.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -97862764751777307L;

	public long lat;
	public long lon;
	
	public String imageUrl;
	public String description;
	public ArrayList<String> hashTags;
	
	
	
}
