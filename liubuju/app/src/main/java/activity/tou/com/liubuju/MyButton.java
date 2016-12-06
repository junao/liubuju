package activity.tou.com.liubuju;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/3/2.
 */
public class MyButton extends View {
    private int mVideoWidth;
    private int mVideoHeight;
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width / 2, height / 2);
    }

    @Override
    public void layout(int l, int t, int r, int b) {

        super.layout(0, 10, r+50, b+50);
    }
}
