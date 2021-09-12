package io.github.ejchathuranga.ctv;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.util.AttributeSet;

public class CustomTextView extends Ctv {


    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Set underline color for this CustomTextView.  Each each underline will apply a single color
     * that parse over {@code color} param.
     *
     * @param color The new color (including alpha) to set in the paint. See the {@link Color} class
     *              for more details.
     *
     * @attr ref io.github.ejchathuranga.ctv.R.styleable.CustomTextView_ctvUnderlineColor
     */
    public void setUnderLineColor(int color) {
        mPaint.setColor(color);
        invalidate();
    }

    public void setUnderlineDotWidthAndSpace(float width, float space) {
        mPaint.setPathEffect(new DashPathEffect(new float[]{width, space}, 0));
        invalidate();
    }

    public void setUnderlineThickness(int height){
        mStrokeWidth = mStrokeWidth + height;
        mPaint.setStrokeWidth(mStrokeWidth);
        invalidate();
    }

    public void setUnderlinePadding(int height){
        mUnderlinePadding = mUnderlinePadding + height;
        invalidate();
    }

}
