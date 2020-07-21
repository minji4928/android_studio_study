package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //캐싱을 해놓을 프래그먼트 개수
        mBinding.vpTestVp.setOffscreenPageLimit(3);

        //getSupportFragmentManager로 프래그먼트 참조가능
        MoviePagerAdapter adapter = new MoviePagerAdapter(getSupportFragmentManager());

        naverbutton fragment1 = new naverbutton();
        adapter.addItem(fragment1);

        naverbutton fragment2 = new naverbutton();
        adapter.addItem(fragment2);

        naverbutton fragment3 = new naverbutton();
        adapter.addItem(fragment3);

        mBinding.vpTestVp.setAdapter(adapter);
    }

    //어댑터 안에서 각각의 아이템을 데이터로서 관리한다
    class MoviePagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MoviePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item) {
            items.add(item);
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }
    }
}