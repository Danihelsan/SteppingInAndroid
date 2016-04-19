package pe.belatrix.steppingandroid.activities;

import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.belatrix.steppingandroid.R;

public class HomeAndroid extends AppCompatActivity {
    @Bind(R.id.pager)
    ViewPager pager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1_activity);
        ButterKnife.bind(this);

        pager.setAdapter(new HomeAdapter(getSupportFragmentManager()));
        pager.setPageTransformer(false, new PageTransformer(pager));
    }
}
