package com.ej.customtextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;

public class DashTextView extends AppCompatTextView {

    private static final String TAG = "DashTextView";

    private Paint mPaint;
    private Path mPath;
    private String tips;
    private String title;
    private int color;
    private boolean dash = true; // default has a dotted line

    public DashTextView(Context context) {
        super(context);
    }

    public DashTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    public DashTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    private void initView(Context context,AttributeSet attrs){
        color = R.color.gray;
        if(attrs != null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DashTextView);
                         // Click on the pop-up title
            if (typedArray.hasValue(R.styleable.DashTextView_title)) {
                title = typedArray.getString(R.styleable.DashTextView_title);
            }
                         // Click on the pop-up content
            if (typedArray.hasValue(R.styleable.DashTextView_tips)) {
                tips = typedArray.getString(R.styleable.DashTextView_tips);
            }
            //Dash line color
            if (typedArray.hasValue(R.styleable.DashTextView_color)) {
                color = typedArray.getResourceId(R.styleable.DashTextView_color,R.color.gray);
            }
                         // Do not show the dotted line
            if (typedArray.hasValue(R.styleable.DashTextView_dash)) {
                dash = typedArray.getBoolean(R.styleable.DashTextView_dash,true);
            }
        }
        initPaint();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//            new CommonAlertDialog(context).showTipsDialog(TextUtils.isEmpty(title) ? getText().toString() : title,tips);
                Log.d(TAG, "initView: ");
            }
        });
    }

    private void initPaint(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //Default use textview current color
        mPaint.setColor(getResources().getColor(color));
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setPathEffect(new DashPathEffect(new float[] {5, 5}, 0));
        mPath = new Path();
                 // Set the dotted line distance
        setPadding(0,0,0,3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        int centerY = getHeight();
        mPath.reset();
        mPath.moveTo(0, centerY);
        mPath.lineTo(getTextWidth(), centerY);
        canvas.drawPath(mPath, mPaint);
    }

    //Get the length of each line and choose the maximum length. Because some mobile phone line breaks cause the dotted line to be too long
    private float getTextWidth(){
        float textWidth = 0;
                 // Loop through the print each line
        for (int i = 0; i < getLineCount(); i++) {
            if(textWidth < getLayout().getLineWidth(i)){
                textWidth = getLayout().getLineWidth(i);
            }
        }
        return textWidth == 0 ? getWidth() : textWidth;
    }

}
