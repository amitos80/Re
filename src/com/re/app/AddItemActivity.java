package com.re.app;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.App;
import com.googlecode.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_add_item)
public class AddItemActivity extends ActionBarActivity {
	
	@App
	MyApplication application;
	
	private ActionBar actionBar;
	
	@AfterViews
    void afterViews() {
    	actionBar = getSupportActionBar();
    	actionBar.setDisplayHomeAsUpEnabled(true);
    }
	
	@Override
  	public boolean onOptionsItemSelected(MenuItem item){
    	
    	
    	
  		return true;
  	}   

}
