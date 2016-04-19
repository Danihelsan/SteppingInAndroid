package pe.belatrix.steppingandroid.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.belatrix.steppingandroid.R;
import pe.belatrix.steppingandroid.fragments.MiniFragment;

/**
 * @author Danihelsan
 */
public class ExtraActivity extends AppCompatActivity {
    @Bind(R.id.layout1)
    FrameLayout layout1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo3_activity_extra);
        ButterKnife.bind(this);

        int backgroundColor = getIntent().getExtras().getInt(MiniFragment.KEY_BACKGROUND);
        Fragment fragment = MiniFragment.newInstance(backgroundColor);
        fragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(R.id.layout1,fragment).commit();

    }
}
