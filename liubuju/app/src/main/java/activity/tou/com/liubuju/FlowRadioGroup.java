package activity.tou.com.liubuju;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;

/**
 * Created by Administrator on 2016/3/2.
 */
public class FlowRadioGroup extends RadioGroup{
    public FlowRadioGroup(Context context) {
        super(context);
    }

    public FlowRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
