package com.re.app;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.App;
import com.googlecode.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_search_item)
public class SearchItemActivity extends ActionBarActivity implements SearchView.OnQueryTextListener{
	
	@App
	MyApplication application;
	
	private ActionBar actionBar;
    public MenuItem menuSearch;
    private SearchView searchView;
	
	
	@AfterViews
    void afterViews() {
    	actionBar = getSupportActionBar();
    	actionBar.setDisplayHomeAsUpEnabled(true);
    }
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu){    	
    	getMenuInflater().inflate(R.menu.activity_search_item, menu); 
    	
    	// Associate searchable configuration with the SearchView
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        
        // opens search view by default
        searchView.setIconified(false);
        searchView.setQueryHint(application.getString(R.string.search_item_hint));
        
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
    	
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
  	public boolean onOptionsItemSelected(MenuItem item){
    	
    	switch(item.getItemId()) {
    	case R.id.action_search:
    		searchView.setIconified(false);
    		Toast.makeText(SearchItemActivity.this, "action_search", Toast.LENGTH_SHORT).show();
    		return true;
    	}
    	
  		return true;
  	}

	@Override
	public boolean onQueryTextChange(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String s) {
		// TODO Auto-generated method stub
		return false;
	}   

}
