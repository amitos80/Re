
package com.re.app;

import uk.co.senab.actionbarpulltorefresh.extras.actionbarcompat.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.Options;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.view.MenuItemCompat;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.App;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.OptionsItem;
import com.googlecode.androidannotations.annotations.OptionsMenu;
import com.googlecode.androidannotations.annotations.ViewById;



//https://github.com/excilys/androidannotations/wiki/Handling-options-menu
@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {
	
	/* IconocDroid example:
	 * 
	    IconicFontDrawable iconicFontDrawable = new IconicFontDrawable(getContext());
		iconicFontDrawable.setIcon(EntypoSocialIcon.GITHUB); //FontAwesomeIcon.SEARCH,  IconicIcon.SEARCH
		iconicFontDrawable.setIconColor(Color.GREEN);

		findViewById(R.id.some_view).setBackground(iconicFontDrawable);
	 *  
	 */
	
	
	@App
	MyApplication application;
	
	private ActionBar actionBar;
    public MenuItem menuSearch;
    
    @ViewById
    public PullToRefreshLayout pullToRefreshLayout;
	
	
    @AfterViews
    void afterViews() {
    	actionBar = getSupportActionBar();
    	
    	ActionBarPullToRefresh.from(this)
        .options(Options.create()
                // Here we make the refresh scroll distance to 75% of the refreshable view's height
                .scrollDistance(.75f)
                // Here we define a custom header layout which will be inflated and used
//                .headerLayout(R.layout.customised_header)
                // Here we define a custom header transformer which will alter the header
                // based on the current pull-to-refresh state
//                .headerTransformer(new CustomisedHeaderTransformer())
                .build())

                // Now carry on with the rest of the setup
                .allChildrenArePullable()
                .listener(new OnRefreshListener() {
					
					@Override
					public void onRefreshStarted(View view) {
						Toast.makeText(MainActivity.this, "on pull to refresh", Toast.LENGTH_SHORT).show();
					}
				})
                .setup(pullToRefreshLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){    	
    	getMenuInflater().inflate(R.menu.activity_main, menu); 
    	
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
  	public boolean onOptionsItemSelected(MenuItem item){
    	
    	switch(item.getItemId()) {
    	case R.id.action_search:    		
    		Intent intentSearchItem = new Intent(MainActivity.this, SearchItemActivity_.class);
            startActivity(intentSearchItem);
    		return true;
    	case R.id.action_add:
    		Intent intentAddItem = new Intent(MainActivity.this, AddItemActivity_.class);
            startActivity(intentAddItem);
    		return true;
    	}
    	
  		return true;
  	}
 

}
