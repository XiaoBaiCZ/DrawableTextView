package cc.xiaobaicz.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextClock;

/**
 * Created by xiaobai on 2017/7/15.
 */

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class DrawableTextClock extends TextClock {

    private DrawableUtil mUtil = DrawableUtil.get();

    public DrawableTextClock(Context context) {
        this(context, null);
    }

    public DrawableTextClock(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableTextClock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Drawable[] drawables = mUtil.getDrawable(context, attrs, defStyleAttr);

        setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
    }

    public void setDrawableRect(Rect l, Rect t, Rect r, Rect b){
        mUtil.setRect(l, t, r, b);
        Drawable[] drawables = getCompoundDrawables();
        mUtil.setDrawableBounds(drawables);
        setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
    }

    public void setDrawable(Drawable[] drawables){
        mUtil.setDrawableBounds(drawables);
        setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
    }
}
