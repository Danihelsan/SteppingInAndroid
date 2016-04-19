package pe.belatrix.steppingandroid.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.belatrix.steppingandroid.R;
import pe.belatrix.steppingandroid.adapters.DemoAdapter;
import pe.belatrix.steppingandroid.adapters.OnClickListener;

/**
 * @author Danihelsan
 */
public class DemoLayoutFragment extends Fragment{

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    public static Fragment newInstance() {
        return new DemoLayoutFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo4_fragment,container,false);

        ButterKnife.bind(this,view);

        OnClickListener listener = new OnClickHandler();
        DemoAdapter adapter = new DemoAdapter(getContext(), listener);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        return view;
    }


    private class OnClickHandler implements OnClickListener{

        @Override
        public void onClick(int position) {
            ((DemoAdapter)recyclerView.getAdapter()).removeItem(position);
        }
    }
}
