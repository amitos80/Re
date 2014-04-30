package com.re.app;

import java.io.File;

import com.googlecode.androidannotations.annotations.EApplication;
import com.webimageloader.ImageLoader;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

@EApplication
public class MyApplication extends Application{


	//examples
	//	@SystemService
	//	NotificationManager notificationManager;

	//	@Bean
	//	MyEnhancedDatastore datastore;

	//	@RestService
	//	MyService myService;
	
	/* *
	 * to inject MyApplication instance use:
	  	@App
  		MyApplication application; 
	 */
	 

	private ImageLoader imageLoader;

	@Override
	public void onCreate() {
		super.onCreate();	

		initImageLoader();
	}
	
	private void initImageLoader() {
		ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		int memClass = am.getMemoryClass();

		// Use part of the available memory for memory cache.
		final int memoryCacheSize = 1024 * 1024 * memClass / 8;

		File cacheDir = new File(getExternalCacheDir(), getResources().getString(R.string.IMAGES_CACHE_DIR_NAME));
		imageLoader = new ImageLoader.Builder(getApplicationContext())
			.enableDiskCache(cacheDir, 10 * 1024 * 1024)
			.enableMemoryCache(memoryCacheSize).build();
	}
	
	public ImageLoader getLoader(){
		return imageLoader;
	}

	public int getScreenWidth(){
		return getResources().getDisplayMetrics().widthPixels;
	}

	public int getScreenHeight(){
		return getResources().getDisplayMetrics().heightPixels;
	}
}
