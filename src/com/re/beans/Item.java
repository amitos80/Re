package com.re.beans;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -97862764751777307L;

	public Item(){}
	
	public String id;
	
	public long lat;
	public long lon;
	
	public long looks;
	
	public long usability;
	
	public String dateCreated;
	public String distance;
	public String type;
	public String title;
	public String imageUrl;
	public String description;
	public ArrayList<String> tags;
	
	
}
