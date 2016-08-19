package ice.tea09.demoswipeviewtablayout;

import ice.tea09.demoswipeviewtablayout.fragment.FirstTabFragment;
import ice.tea09.demoswipeviewtablayout.fragment.SecondTabFragment;
import ice.tea09.demoswipeviewtablayout.fragment.ThirdTabFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerViewAdapter extends FragmentPagerAdapter {

	public PagerViewAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {
		switch (index) {
		case 0:
			return new FirstTabFragment();
		case 1:
			return new SecondTabFragment();
		case 2:
			return new ThirdTabFragment();
		default:
			return new FirstTabFragment();
		}
	}

	@Override
	public int getCount() {
		return 3;
	}

}
