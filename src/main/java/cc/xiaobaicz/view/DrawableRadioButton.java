package cc.xiaobaicz.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

/**
 * Created by xiaobai on 2017/7/15.
 */

public class DrawableRadioButton extends AppCompatRadioButton {

    private DrawableUtil mUtil = DrawableUtil.get();

    public DrawableRadioButton(Context context) {
        this(context, null);
    }

    public DrawableRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.radioButtonStyle);
    }

    public DrawableRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
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
