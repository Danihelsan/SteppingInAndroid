package pe.belatrix.steppingandroid.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.belatrix.steppingandroid.R;

/**
 * @author Danihelsan
 */
public class DemoLayoutFragment extends Fragment{

    public static Fragment newInstance() {
        return new DemoLayoutFragment();
    }

    @Bind(R.id.layout1)
    FrameLayout layout1;

    @Bind(R.id.layout2)
    FrameLayout layout2;

    @Bind(R.id.layout3)
    FrameLayout layout3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo2_fragment,container,false);

        ButterKnife.bind(this,view);

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        if (layout1!=null){
            Fragment fragment = MiniFragment.newInstance(R.color.black);
            transaction.replace(R.id.layout1,fragment,"Demo1Layout1");
        }
        if (layout2!=null){
            Fragment fragment = MiniFragment.newInstance(R.color.red);
            transaction.replace(R.id.layout2,fragment,"Demo1Layout2");
        }
        if (layout3!=null){
            Fragment fragment = MiniFragment.newInstance(R.color.blue);
            transaction.replace(R.id.layout3,fragment,"Demo1Layout3");
        }
        transaction.commit();
        return view;
    }
}
