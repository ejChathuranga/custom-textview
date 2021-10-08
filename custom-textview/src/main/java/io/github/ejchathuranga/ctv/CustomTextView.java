package io.github.ejchathuranga.ctv;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.util.AttributeSet;
import android.util.Log;

public class CustomTextView extends Ctv {
    private static final String TAG = "CustomTextView";

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

    public void setUnderlineThickness(int height) {
        float density = getContext().getResources().getDisplayMetrics().density;
        mStrokeWidth =  density * Const.UNDERLINE_THICKNESS + height;
        mPaint.setStrokeWidth(mStrokeWidth);
        this.setLineSpacing((mStrokeWidth + mUnderlinePadding), 1);
        invalidate();
    }

    public void setUnderlinePadding(int height) {
        mUnderlinePadding = Const.UNDERLINE_PADDING + height;
        this.setLineSpacing((mStrokeWidth + mUnderlinePadding), 1);
        invalidate();
    }

    public void reset() {
        mPaint.setColor(Const.COLOR_TRANS);

        mPaint.setPathEffect(new DashPathEffect(new float[]{Const.UNDERLINE_DOT_WIDTH, Const.UNDERLINE_DOT_SPACE}, 0));

        mStrokeWidth = Const.UNDERLINE_THICKNESS;
        float density = getContext().getResources().getDisplayMetrics().density;
        mStrokeWidth =  density * mStrokeWidth ;
        mPaint.setStrokeWidth(mStrokeWidth);
        this.setLineSpacing(mStrokeWidth, 1);

        mUnderlinePadding = Const.UNDERLINE_PADDING;

        invalidate();
    }


}
