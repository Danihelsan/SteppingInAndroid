package pe.belatrix.steppingandroid.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import pe.belatrix.steppingandroid.R;
import pe.belatrix.steppingandroid.fragments.MiniFragment;

/**
 * @author Danihelsan
 */
public class HomeAdapter extends FragmentPagerAdapter {

    public HomeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return MiniFragment.newInstance(R.color.red);
            case 2: return MiniFragment.newInstance(R.color.green);
            default: return MiniFragment.newInstance(R.color.blue);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
