package com.example.slidingtabstriptest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.astuetz.viewpager.extensions.PagerSlidingTabStrip;

public class MainActivity extends FragmentActivity {
	private PagerSlidingTabStrip slidingTabStrip;
	private ViewPager viewPager;
	private String[] titles = {"郁闷", "失神", "生气"};
	private Fragment mFragment1,mFragment2,mFragment3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		slidingTabStrip = (PagerSlidingTabStrip)super.findViewById(R.id.tabs);
		viewPager = (ViewPager)super.findViewById(R.id.pager);
		viewPager.setOffscreenPageLimit(1);
		viewPager.setAdapter(new TabPagerAdapter(getSupportFragmentManager()));
		slidingTabStrip.setViewPager(viewPager);
	}
class TabPagerAdapter extends FragmentPagerAdapter{


	public TabPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return titles[position];
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			if (mFragment1 == null) {
				mFragment1 = new mFragment1();
			}
			return mFragment1;
		case 1:
			if (mFragment2 == null) {
				mFragment2 = new mFragment2();
			}
			return mFragment2;
		case 2:
			if (mFragment3 == null) {
				mFragment3 = new mFragment3();
			}
			return mFragment3;
		default:
			break;
		}
		return null;
	}

	@Override
	public int getCount() {
		return titles.length;
	}

}

}
