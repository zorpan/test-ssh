package test.pxy.newsreader;

import android.app.Fragment;
import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import test.pxy.newsreader.frame.Fragment1;
import test.pxy.newsreader.frame.Fragment2;
import test.pxy.newsreader.frame.Fragment3;
import test.pxy.newsreader.frame.Fragment4;

public class MainActivity extends FragmentActivity {

    private RadioGroup navGroup;
    String tabs[]={"Tab1","Tab2","Tab3","Tab4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        navGroup = (RadioGroup)findViewById(R.id.frames);
        navGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.fram1:
                        switchFragmentSupport(R.id.content,tabs[0]);
                        break;
                    case R.id.fram2:
                        switchFragmentSupport(R.id.content,tabs[1]);
                        break;
                    case R.id.fram3:
                        switchFragmentSupport(R.id.content,tabs[2]);
                        break;
                    case R.id.fram4:
                        switchFragmentSupport(R.id.content,tabs[3]);
                        break;
                }
            }
        });
        RadioButton btn = (RadioButton)navGroup.getChildAt(0);
        btn.toggle();
    }
    private void switchFragmentSupport(int containId,String tag){
        //获取FramegrameManager管理器
        FragmentManager manager = getFragmentManager();
        //根据标签查找是否已存在对应的frame对象
        Fragment destFrament = manager.findFragmentByTag(tag);
        //如果不存在则初始化
        if(destFrament == null){
           if(tag.equals(tabs[0])){destFrament = new Fragment1();}
           if(tag.equals(tabs[1])){destFrament = new Fragment2();}
           if(tag.equals(tabs[2])){destFrament = new Fragment3();}
           if(tag.equals(tabs[3])){destFrament = new Fragment4();}
        }

        //获取FramegramentTransaction事务对象
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(containId,destFrament,tag);
        ft.commit();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}
