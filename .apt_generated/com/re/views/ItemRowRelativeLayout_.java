//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package com.re.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.re.app.MyApplication;
import com.re.app.R.id;
import com.re.app.R.layout;


/**
 * We use @SuppressWarning here because our java code
 * generator doesn't know that there is no need
 * to import OnXXXListeners from View as we already
 * are in a View.
 * 
 */
@SuppressWarnings("unused")
public final class ItemRowRelativeLayout_
    extends ItemRowRelativeLayout
{

    private Context context_;
    private boolean mAlreadyInflated_ = false;

    public ItemRowRelativeLayout_(Context context) {
        super(context);
        init_();
    }

    public ItemRowRelativeLayout_(Context context, AttributeSet attrs) {
        super(context, attrs);
        init_();
    }

    public ItemRowRelativeLayout_(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init_();
    }

    private void init_() {
        context_ = getContext();
        if (context_ instanceof Activity) {
            Activity activity = ((Activity) context_);
            application = ((MyApplication) activity.getApplication());
        }
    }

    private void afterSetContentView_() {
        usability = ((TextView) findViewById(id.usability));
        image = ((ImageView) findViewById(id.image));
        date_created = ((TextView) findViewById(id.date_created));
        distance = ((TextView) findViewById(id.distance));
        looks = ((TextView) findViewById(id.looks));
        title = ((TextView) findViewById(id.title));
    }

    /**
     * The mAlreadyInflated_ hack is needed because of an Android bug
     * which leads to infinite calls of onFinishInflate()
     * when inflating a layout with a parent and using
     * the <merge /> tag.
     * 
     */
    @Override
    public void onFinishInflate() {
        if (!mAlreadyInflated_) {
            mAlreadyInflated_ = true;
            inflate(getContext(), layout.view_item_row, this);
            afterSetContentView_();
        }
        super.onFinishInflate();
    }

    public static ItemRowRelativeLayout build(Context context) {
        ItemRowRelativeLayout_ instance = new ItemRowRelativeLayout_(context);
        instance.onFinishInflate();
        return instance;
    }

    public static ItemRowRelativeLayout build(Context context, AttributeSet attrs) {
        ItemRowRelativeLayout_ instance = new ItemRowRelativeLayout_(context, attrs);
        instance.onFinishInflate();
        return instance;
    }

    public static ItemRowRelativeLayout build(Context context, AttributeSet attrs, int defStyle) {
        ItemRowRelativeLayout_ instance = new ItemRowRelativeLayout_(context, attrs, defStyle);
        instance.onFinishInflate();
        return instance;
    }

}
