package com.re.views;


import com.googlecode.androidannotations.annotations.App;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.ViewById;
import com.re.app.MyApplication;
import com.re.app.R;
import com.re.beans.Item;
import com.webimageloader.ext.ImageHelper;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

@EViewGroup(R.layout.view_item_row)
public class ItemRowRelativeLayout extends RelativeLayout{
	
	@ViewById
	public ImageView image;
	
	@ViewById
	public TextView title;
	
	
	@ViewById
	public TextView looks;
	
	@ViewById
	public TextView usability;
	
	
	@ViewById
	public TextView date_created;
	
	@ViewById
	public TextView distance;
	
	@App
	MyApplication application;
	
	
	public ItemRowRelativeLayout(Context context) {
		super(context);
	}
	
	public ItemRowRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public ItemRowRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	
	public void bind(Item data){
		
		new ImageHelper(getContext(),  application.getLoader()).load(image, data.imageUrl);
		
		title.setText(data.title);
		looks.setText("Looks: " + data.looks + "/5");
		usability.setText("Usability: " + data.usability + "/5");
		date_created.setText("uploaded on: " + data.dateCreated);
		distance.setText(data.distance + " meters from you");
	}
	
	

}
