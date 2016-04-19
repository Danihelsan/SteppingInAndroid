package pe.belatrix.steppingandroid.fragments;

import android.content.Intent;
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
import pe.belatrix.steppingandroid.activities.ExtraActivity;

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

    @Nullable
    @Bind(R.id.layout3)
    FrameLayout layout3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo3_fragment,container,false);

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

        loadActions();
        return view;
    }

    private void loadActions() {
        if (layout3==null){
            layout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(MiniFragment.KEY_BACKGROUND,R.color.blue);

                    Intent intent = new Intent(getContext(), ExtraActivity.class);
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
            });
        }
    }
}
