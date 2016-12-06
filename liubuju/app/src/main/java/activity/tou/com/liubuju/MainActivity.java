package activity.tou.com.liubuju;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;

public class MainActivity extends FragmentActivity {
    private ViewPager vp;
    private Context context;
    private MyFragment f1;
    private MyFragment2 f2;
    private MyFragment3 f3;
    private MyFragment4 f4;
    private ArrayList fragments;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        init();
        ShareSDK.initSDK(this);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("tou", "onclick");
            }
        });

        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("tou", "ontouch");
                return true;
            }
        });
    }

    private void init(){
        vp = (ViewPager) findViewById(R.id.vp);
        fragments = new ArrayList<Fragment>();
        f1 = new MyFragment();
        f2 = new MyFragment2();
        f3 = new MyFragment3();
        f4 = new MyFragment4();
        fragments.add(f1);
        fragments.add(f2);
        fragments.add(f3);
        fragments.add(f4);
        vp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragments));
        vp.setCurrentItem(0);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if(ev.getAction() == MotionEvent.ACTION_DOWN){
//            vp.dispatchTouchEvent(ev);
//        }
//        return super.dispatchTouchEvent(ev);
//    }

    public class MyFragmentAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> list;
        public MyFragmentAdapter(FragmentManager fm,ArrayList<Fragment> list){
            super(fm);
            this.list = list;
        }
        @Override
        public Fragment getItem(int arg0) {
            // TODO Auto-generated method stub
            return list.get(arg0);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }
    }
}