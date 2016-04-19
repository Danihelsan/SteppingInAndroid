package pe.belatrix.steppingandroid.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.belatrix.steppingandroid.R;

/**
 * @author Danihelsan
 */
public class MiniFragment extends Fragment{
    public static final String KEY_BACKGROUND = "background";
    public static Fragment newInstance(){
        Fragment fragment = new MiniFragment();
        return fragment;
    }
    public static Fragment newInstance(int backgroundColor){
        Fragment fragment = new MiniFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_BACKGROUND, backgroundColor);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.minilayout,container,false);

        if (getArguments()!=null && getArguments().containsKey(KEY_BACKGROUND)){
            int backgroundColor = getArguments().getInt(KEY_BACKGROUND);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                view.setBackgroundColor(getResources().getColor(backgroundColor,null));
            } else {
                view.setBackgroundColor(getResources().getColor(backgroundColor));
            }

        }
        return view;
    }
}
