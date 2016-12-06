package activity.tou.com.liubuju;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

/**
 * Created by Administrator on 2016/3/17.
 */
public class MyFragment extends Fragment {
    private View view;
    private HorizontalScrollView hsc1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frg_1, container, false);
        hsc1 = (HorizontalScrollView) view.findViewById(R.id.hsc1);
        return view;
    }

}
