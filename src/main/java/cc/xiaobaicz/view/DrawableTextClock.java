package cc.xiaobaicz.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextClock;

/**
 * Created by xiaobai on 2017/7/15.
 */

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class DrawableTextClock extends TextClock {

    public DrawableTextClock(Context context) {
        this(context, null);
    }

    public DrawableTextClock(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableTextClock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Drawable[] drawables = DrawableUtil.get().getDrawable(context, attrs, defStyleAttr);

        setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
    }
}
