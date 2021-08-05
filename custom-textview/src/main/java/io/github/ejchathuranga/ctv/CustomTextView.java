package io.github.ejchathuranga.ctv;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;


public class CustomTextView extends AppCompatTextView {
    private static final String TAG = "CustomTextView";

    private Rect mRect;
    private Paint mPaint;
    private float mStrokeWidth;
    private int mUnderlinePadding;

    public CustomTextView(Context context) {
        this(context, null, 0);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);

        /// turning off hardware acceleration
        // can be removed/commented out if no dashed underline needed.
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    private void init(Context context, AttributeSet attributeSet, int defStyle) {

        float density = context.getResources().getDisplayMetrics().density;

        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, io.github.ejchathuranga.ctv.R.styleable.CustomTextView, defStyle, 0);
        int underlineColor = typedArray.getColor(io.github.ejchathuranga.ctv.R.styleable.CustomTextView_ctvUnderlineColor, ContextCompat.getColor(context, R.color.transparent));
        mStrokeWidth = typedArray.getDimension(io.github.ejchathuranga.ctv.R.styleable.CustomTextView_underlineWidth, density * 2);
        mUnderlinePadding = typedArray.getInteger(R.styleable.CustomTextView_underlinePadding, 2);
        int dotWidth = typedArray.getInteger(R.styleable.CustomTextView_ctvUnderLineDotWidth, 10);
        int dotSpace = typedArray.getInteger(R.styleable.CustomTextView_ctvUnderLineDotSpace, 5);
        typedArray.recycle();

        mRect = new Rect();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(underlineColor);
        mPaint.setStrokeWidth(mStrokeWidth);

        // Comment below line if no dashed underline needed.
        mPaint.setPathEffect(new DashPathEffect(new float[]{dotWidth, dotSpace}, 0));
    }

//    private void setTransparentUnderline

    public int getUnderLineColor() {
        return mPaint.getColor();
    }

    public void setUnderLineColor(int mColor) {
        mPaint.setColor(mColor);
        invalidate();
    }

    public void setUnderlineWidth(float mStrokeWidth) {
        this.mStrokeWidth = mStrokeWidth;
        invalidate();
    }

    public void setUnderlineDotWidthAndSpace(float width, float space) {
        mPaint.setPathEffect(new DashPathEffect(new float[]{width, space}, 0));
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {

        int count = getLineCount();
        final Layout layout = getLayout();
        float x_start, x_stop, x_diff;
        int firstCharInLine, lastCharInLine;

        for (int i = 0; i < count; i++) {
            int baseline = getLineBounds(i, mRect) + mUnderlinePadding;
            firstCharInLine = layout.getLineStart(i);
            lastCharInLine = layout.getLineEnd(i);

            x_start = layout.getPrimaryHorizontal(firstCharInLine);
            x_diff = layout.getPrimaryHorizontal(firstCharInLine + 1) - x_start;
            x_stop = layout.getPrimaryHorizontal(lastCharInLine - 1) + x_diff;

            canvas.drawLine(x_start, baseline + mStrokeWidth, x_stop, baseline + mStrokeWidth, mPaint);
        }

        super.onDraw(canvas);
    }
}