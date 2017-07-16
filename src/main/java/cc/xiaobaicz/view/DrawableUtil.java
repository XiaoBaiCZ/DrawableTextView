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

    private DrawableUtil(){
    }

    public static DrawableUtil get(){
        return new DrawableUtil();
    }

    public Drawable[] getDrawable(Context context, AttributeSet attrs, int defStyleAttr){
        Drawable[] drawables = new Drawable[4];

        int width = -1, height = -1;

        final Resources.Theme theme = context.getTheme();

        TypedArray a = theme.obtainStyledAttributes(
                attrs, R.styleable.DrawableTextView, defStyleAttr, 0);

        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.DrawableTextView_drawable_width) {
                width = a.getDimensionPixelSize(attr, -1);
            } else if (attr == R.styleable.DrawableTextView_drawable_height) {
                height = a.getDimensionPixelSize(attr, -1);
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

        Rect rect = new Rect(0, 0, width, height);

        for(int i = 0; i < drawables.length; i++){
            if(drawables[i] != null)
                drawables[i].setBounds(rect);
        }

        return drawables;
    }

}
