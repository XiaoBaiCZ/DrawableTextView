package cc.xiaobaicz.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

/**
 * Created by xiaobai on 2017/7/15.
 */

public class DrawableCheckBox extends AppCompatCheckBox {
    public DrawableCheckBox(Context context) {
        this(context, null);
    }

    public DrawableCheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Drawable[] drawables = DrawableUtil.get().getDrawable(context, attrs, defStyleAttr);

        setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
    }
}
