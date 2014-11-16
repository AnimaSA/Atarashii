package net.somethingdreadful.MAL;

import android.content.res.Configuration;
import android.content.res.Resources;

import com.crashlytics.android.Crashlytics;

import org.holoeverywhere.ThemeManager;
import org.holoeverywhere.app.Application;

import java.util.Locale;

public class Theme extends Application {

    Locale locale;
    Configuration config;

    @Override
    public void onCreate() {
        super.onCreate();
        Crashlytics.start(this);
        locale = (new PrefManager(getApplicationContext())).getLocale();
        config = new Configuration();
        config.locale = locale;
        setLanguage(); //Change language when it is started
        Crashlytics.setString("Language", locale.toString());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setLanguage(); //Change language after orientation.
    }

    public void setLanguage() {
        Resources res = getBaseContext().getResources();
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

    static {
        ThemeManager.setDefaultTheme(ThemeManager.MIXED);
    }
}
