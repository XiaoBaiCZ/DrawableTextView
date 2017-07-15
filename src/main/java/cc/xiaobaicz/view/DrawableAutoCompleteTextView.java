package cc.xiaobaicz.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;

/**
 * Created by xiaobai on 2017/7/15.
 */

public class DrawableAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    public DrawableAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public DrawableAutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Drawable[] drawables = DrawableUtil.getDrawable(context, attrs, defStyleAttr);

        setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
    }
}
