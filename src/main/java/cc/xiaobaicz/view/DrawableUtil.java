package cc.xiaobaicz.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/**
 * Created by xiaobai on 2017/7/15.
 */

final class DrawableUtil {

    final Rect mRectL = new Rect(0, 0, -1, -1);
    final Rect mRectT = new Rect(0, 0, -1, -1);
    final Rect mRectR = new Rect(0, 0, -1, -1);
    final Rect mRectB = new Rect(0, 0, -1, -1);

    private DrawableUtil(){
    }

    public static DrawableUtil get(){
        return new DrawableUtil();
    }

    public Drawable[] getDrawable(Context context, AttributeSet attrs, int defStyleAttr){
        Drawable[] drawables = new Drawable[4];

        final Resources.Theme theme = context.getTheme();

        TypedArray a = theme.obtainStyledAttributes(
                attrs, R.styleable.DrawableTextView, defStyleAttr, 0);

        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.DrawableTextView_drawable_width) {
                int width = a.getDimensionPixelSize(attr, -1);
                mRectL.right = width;
                mRectT.right = width;
                mRectR.right = width;
                mRectB.right = width;
            } else if (attr == R.styleable.DrawableTextView_drawable_height) {
                int height = a.getDimensionPixelSize(attr, -1);
                mRectL.bottom = height;
                mRectT.bottom = height;
                mRectR.bottom = height;
                mRectB.bottom = height;
            } else if (attr == R.styleable.DrawableTextView_drawableLeft_width) {
                mRectL.right = a.getDimensionPixelSize(attr, -1);
            } else if (attr == R.styleable.DrawableTextView_drawableLeft_height) {
                mRectL.bottom = a.getDimensionPixelSize(attr, -1);
            } else if (attr == R.styleable.DrawableTextView_drawableTop_width) {
                mRectT.right = a.getDimensionPixelSize(attr, -1);
            } else if (attr == R.styleable.DrawableTextView_drawableTop_height) {
                mRectT.bottom = a.getDimensionPixelSize(attr, -1);
            } else if (attr == R.styleable.DrawableTextView_drawableRight_width) {
                mRectR.right = a.getDimensionPixelSize(attr, -1);
            } else if (attr == R.styleable.DrawableTextView_drawableRight_height) {
                mRectR.bottom = a.getDimensionPixelSize(attr, -1);
            } else if (attr == R.styleable.DrawableTextView_drawableBottom_width) {
                mRectB.right = a.getDimensionPixelSize(attr, -1);
            } else if (attr == R.styleable.DrawableTextView_drawableBottom_height) {
                mRectB.bottom = a.getDimensionPixelSize(attr, -1);
            } else if (attr == R.styleable.DrawableTextView_drawableLeft) {
                drawables[0] = a.getDrawable(attr);
            } else if (attr == R.styleable.DrawableTextView_drawableTop) {
                drawables[1] = a.getDrawable(attr);
            } else if (attr == R.styleable.DrawableTextView_drawableRight) {
                drawables[2] = a.getDrawable(attr);
            } else if (attr == R.styleable.DrawableTextView_drawableBottom) {
                drawables[3] = a.getDrawable(attr);
            }
        }

        a.recycle();

        setDrawableBounds(drawables);

        return drawables;
    }

    void setDrawableBounds(Drawable[] drawable) {
        if(drawable[0] != null)
            drawable[0].setBounds(mRectL);
        if(drawable[1] != null)
            drawable[1].setBounds(mRectT);
        if(drawable[2] != null)
            drawable[2].setBounds(mRectR);
        if(drawable[3] != null)
            drawable[3].setBounds(mRectB);
    }

    void setRect(Rect l, Rect t, Rect r, Rect b) {
        if(l != null)
            mRectL.set(l);
        if(t != null)
            mRectT.set(t);
        if(r != null)
            mRectR.set(r);
        if(b != null)
            mRectB.set(b);
    }
}
