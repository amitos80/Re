package com.re.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.webimageloader.transformation.SimpleTransformation;
import com.webimageloader.transformation.Transformation;

public class ImageUtils {
	

	public static Transformation circleImage = new SimpleTransformation() {
		@Override
		public String getIdentifier() {
			// Pass a unique identifier for caching
			return "re-circle-image";
		}

		@Override
		public Bitmap transform(Bitmap b) {
			return ImageUtils.getRoundedCornerBitmap(b);		        
		}

		@Override 
		public Bitmap.CompressFormat getCompressFormat()
		{
			return CompressFormat.PNG;
		}
	};

	public static Transformation squareRoundedImage = new SimpleTransformation() {
		@Override
		public String getIdentifier() {
			// Pass a unique identifier for caching
			return "re-square-rounded-image";
		}

		@Override
		public Bitmap transform(Bitmap b) {
			return ImageUtils.getRoundedCornerBitmap(b, 10);		        
		}

		@Override 
		public Bitmap.CompressFormat getCompressFormat()
		{
			return CompressFormat.PNG;
		}
	};
	
	public static class RoundedWithStrokeTranformation extends SimpleTransformation{
		
		int color;
		int cornerDips;
		int borderDips;
		DisplayMetrics matrix;
		
		public RoundedWithStrokeTranformation(int color1, int cornerDips1, int borderDips1, DisplayMetrics matrix1){
			color = color1;
			cornerDips = cornerDips1;
			borderDips = borderDips1;
			matrix = matrix1;
		}
		
		@Override
		public String getIdentifier() {
			// Pass a unique identifier for caching
			return "square-rounded-stroke-image-color" + color + "cornerDips" + cornerDips + "borderDips" + borderDips;
		}

		@Override
		public Bitmap transform(Bitmap b) {
			//int color, int cornerDips, int borderDips
			return ImageUtils.getRoundedCornerWithBorderBitmap(b, color, cornerDips, borderDips, matrix);		        
		}

		@Override 
		public Bitmap.CompressFormat getCompressFormat(){
			return CompressFormat.PNG;
		}	
	}

	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {		
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);

		return output;
	}
	
	public static Bitmap getRoundedCornerBitmap(Bitmap bmp) {
		int radius = bmp.getWidth();
		Bitmap sbmp;
		if(bmp.getWidth() != radius || bmp.getHeight() != radius)
			sbmp = Bitmap.createScaledBitmap(bmp, radius, radius, false);
		else
			sbmp = bmp;
		Bitmap output = Bitmap.createBitmap(sbmp.getWidth(),
				sbmp.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, sbmp.getWidth(), sbmp.getHeight());

		paint.setAntiAlias(true);
		paint.setFilterBitmap(true);
		paint.setDither(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(Color.parseColor("#BAB399"));
		canvas.drawCircle(sbmp.getWidth() / 2+0.7f, sbmp.getHeight() / 2+0.7f,
				sbmp.getWidth() / 2+0.1f, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(sbmp, rect, rect, paint);

		return output;
	}
	
	public static Bitmap getRoundedCornerWithBorderBitmap(Bitmap bitmap, int color, int cornerDips, int borderDips, DisplayMetrics matrix) {
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int borderSizePx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) borderDips, matrix);
		final int cornerSizePx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) cornerDips, matrix);

		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);

		// prepare canvas for transfer
		paint.setAntiAlias(true);
		paint.setColor(0xFFFFFFFF);
		paint.setStyle(Paint.Style.FILL);
		canvas.drawARGB(0, 0, 0, 0);
		canvas.drawRoundRect(rectF, cornerSizePx, cornerSizePx, paint);


		// draw bitmap
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);

		// draw border
		paint.setColor(color);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth((float) borderSizePx);
		canvas.drawRoundRect(rectF, cornerSizePx, cornerSizePx, paint);

		return output;
	}

	public static Drawable ImageOperations(Context ctx, String url, String saveFilename) {
		try {
			InputStream is = (InputStream) fetch(url);
			Drawable d = Drawable.createFromStream(is, saveFilename);
			return d;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static  Object fetch(String address) throws MalformedURLException, IOException {
		URL url = new URL(address);
		Object content = url.getContent();
		return content;
	}
	

}
