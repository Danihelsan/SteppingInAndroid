package pe.belatrix.steppingandroid;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * @author Danihelsan
 */
public class App extends Application {
    @Override public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
