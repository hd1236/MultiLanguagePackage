package com.hand.multilanguagepackage;

import android.app.Application;

import com.hand.multilanguagepackage.philology.StringPhilologyRepositoryFactory;
import com.jcminarro.philology.Philology;
import com.jcminarro.philology.PhilologyInterceptor;
import com.jcminarro.philology.PhilologyRepositoryFactory;

import io.github.inflationx.viewpump.ViewPump;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PhilologyRepositoryFactory repositoryFactory = new StringPhilologyRepositoryFactory(getApplicationContext());
        Philology.INSTANCE.init(repositoryFactory);
        ViewPump.init(ViewPump.builder().addInterceptor(PhilologyInterceptor.INSTANCE).build());
    }
}
