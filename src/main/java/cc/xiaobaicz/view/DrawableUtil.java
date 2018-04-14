package cc.xiaobaicz.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
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

    //是否压缩，开启压缩则只能识别bitmap，默认不开启
    boolean isCompress = false;

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

        //图片id
        final int[] D_IDS = new int[]{-1, -1, -1, -1};

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
                D_IDS[0] = attr;
            } else if (attr == R.styleable.DrawableTextView_drawableTop) {
                D_IDS[1] = attr;
            } else if (attr == R.styleable.DrawableTextView_drawableRight) {
                D_IDS[2] = attr;
            } else if (attr == R.styleable.DrawableTextView_drawableBottom) {
                D_IDS[3] = attr;
            } else if (attr == R.styleable.DrawableTextView_compress) {
                isCompress = a.getBoolean(attr, false);
            }
        }

        if(isCompress){
            for(int i = 0; i < D_IDS.length; i++){
                Rect rect;
                switch (i){
                    default:
                        rect = mRectL;
                        break;
                    case 1:
                        rect = mRectT;
                        break;
                    case 2:
                        rect = mRectR;
                        break;
                    case 3:
                        rect = mRectB;
                        break;
                }
                if(D_IDS[i] != -1){
                    D_IDS[i] = a.getResourceId(D_IDS[i], -1);
                    drawables[i] = compress(context, D_IDS[i], rect);
                }
            }
        }else{
            for(int i = 0; i < D_IDS.length; i++){
                if(D_IDS[i] != -1){
                    drawables[i] = a.getDrawable(D_IDS[i]);
                }
            }
        }

        a.recycle();

        setDrawableBounds(drawables);

        return drawables;
    }

    private Drawable compress(Context context, int id, Rect rect){
        Drawable drawable = null;

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), id, options);
        final int def_w = options.outWidth;
        final int def_h = options.outHeight;

        final int w = rect.width();
        final int h = rect.height();

        int size_w;
        int sw = (size_w = def_w / w) > 0 ? size_w : 1;
        int size_h;
        int sh = (size_h = def_h / h) > 0 ? size_h : 1;
        int size = sw > sh ? sh : sw;

        options.inJustDecodeBounds = false;
        options.inSampleSize = size;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), id, options);

        drawable = new BitmapDrawable(bitmap);

        return drawable;
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

    void setDrawableBounds(Drawable[] drawable){
        if(drawable[0] != null)
            drawable[0].setBounds(mRectL);
        if(drawable[1] != null)
            drawable[1].setBounds(mRectT);
        if(drawable[2] != null)
            drawable[2].setBounds(mRectR);
        if(drawable[3] != null)
            drawable[3].setBounds(mRectB);
    }
}
