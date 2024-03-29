package io.github.ejchathuranga.ctv;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;


public class Ctv extends AppCompatTextView {
    private static final String TAG = "CustomTextView";

    Rect mRect;
    Paint mPaint;
    float mStrokeWidth;
    int mUnderlinePadding;
    float density;

    public Ctv(Context context) {
        this(context, null, 0);
    }

    public Ctv(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Ctv(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);

        /// turning off hardware acceleration
        // can be removed/commented out if no dashed underline needed.
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    private void init(Context context, AttributeSet attributeSet, int defStyle) {

        density = context.getResources().getDisplayMetrics().density;
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, io.github.ejchathuranga.ctv.R.styleable.CustomTextView, defStyle, 0);
        int underlineColor = typedArray.getColor(io.github.ejchathuranga.ctv.R.styleable.CustomTextView_ctvUnderlineColor, Const.COLOR_TRANS);
        mStrokeWidth = typedArray.getDimension(io.github.ejchathuranga.ctv.R.styleable.CustomTextView_underlineWidth, density * Const.UNDERLINE_THICKNESS);
        mUnderlinePadding = typedArray.getInteger(R.styleable.CustomTextView_ctvUnderlinePadding, Const.UNDERLINE_PADDING);
        int dotWidth = typedArray.getInteger(R.styleable.CustomTextView_ctvUnderLineDotWidth, Const.UNDERLINE_DOT_WIDTH);
        int dotSpace = typedArray.getInteger(R.styleable.CustomTextView_ctvUnderLineDotSpace, Const.UNDERLINE_DOT_SPACE);
        typedArray.recycle();


        mRect = new Rect();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(underlineColor);
        mPaint.setStrokeWidth(mStrokeWidth);

        // Comment below line if no dashed underline needed.
        mPaint.setPathEffect(new DashPathEffect(new float[]{dotWidth, dotSpace}, 0));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mPaint.getColor() != Const.COLOR_TRANS) {

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

                float newStroke = mStrokeWidth - (mStrokeWidth/2);
//                Log.d(TAG, "onDraw: baseline: " + baseline +  "  mStrokeWidth: " + mStrokeWidth + "    sum: "+  (baseline + mStrokeWidth)+  "  newStrock: " + newStrock);
                canvas.drawLine(x_start, (baseline + newStroke), x_stop, (baseline + newStroke) , mPaint);
            }

        }
        super.onDraw(canvas);

    }
}