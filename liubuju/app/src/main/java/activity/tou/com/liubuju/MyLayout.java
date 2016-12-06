package activity.tou.com.liubuju;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/15.
 */
public class MyLayout extends LinearLayout {
    private int heigh;
    private int width;

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() > 0) {
            for (int i = 0; i < getChildCount(); i++) {
                View view = getChildAt(0);
                measureChild(view, widthMeasureSpec, heightMeasureSpec);
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int mViewGroupWidth = getMeasuredWidth();  //当前ViewGroup的总宽度
        int mViewGroupHeigh = getMeasuredHeight();
        int mPainterPosX = 0;  //当前绘图光标横坐标位置
        int mPainterPosY = 0;  //当前绘图光标纵坐标位置

        int childCount = getChildCount();
        List<Integer> a = new ArrayList<>();
        int b = 0;
        for(int j=0; j<childCount; j++){
            View childView = getChildAt(j);

            int width  = childView.getMeasuredWidth();
            int height = childView.getMeasuredHeight();

            //如果剩余的空间不够，则移到下一行开始位置
            if( mPainterPosX + width > mViewGroupWidth ) {
                a.add(b,(mViewGroupWidth - mPainterPosX) / 4);
                mPainterPosX = 0;
                b++;
            }
            mPainterPosX += width;
        }
int ff = a.get(0);
        for ( int i = 0; i < childCount; i++ ) {

            View childView = getChildAt(i);

            int width  = childView.getMeasuredWidth();
            int height = childView.getMeasuredHeight();

            //如果剩余的空间不够，则移到下一行开始位置
            if( ff + width > mViewGroupWidth ) {
                ff = a.get(0);
                mPainterPosY += height;
            }
            //执行ChildView的绘制l
            childView.layout(ff,mPainterPosY,ff+width, mPainterPosY+height);

            //记录当前已经绘制到的横坐标位置
            ff = ff+width+a.get(0);
        }
    }
}
