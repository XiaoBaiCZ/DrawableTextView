package cc.xiaobaicz.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.util.AttributeSet;

/**
 * Created by xiaobai on 2017/7/15.
 */

public class DrawableCheckedTextView extends AppCompatCheckedTextView {

    private DrawableUtil mUtil = DrawableUtil.get();

    public DrawableCheckedTextView(Context context) {
        this(context, null);
    }

    public DrawableCheckedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.checkedTextViewStyle);
    }

    public DrawableCheckedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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
