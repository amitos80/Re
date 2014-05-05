package com.re.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.re.beans.Item;
import com.re.views.ItemRowRelativeLayout;
import com.re.views.ItemRowRelativeLayout_;

@EBean
public class ItemListAdapter extends com.nhaarman.listviewanimations.ArrayAdapter<Item>{
	
	@RootContext
	Context context;
	
	private ArrayList<Item> items;
	
	public void setAdapterData(ArrayList<Item> i){
		items = i;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ItemRowRelativeLayout view = (ItemRowRelativeLayout)convertView;
		if(view == null){
			view = ItemRowRelativeLayout_.build(context);
		}
		
		view.bind(getItem(position));
		
		return view;
	}
	
	
	@Override
	public int getCount() {
		return (items != null ? items.size() : 0);
	}

	@Override
	public Item getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}	
	

}
