package com.hand.multilanguagepackage.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.jcminarro.philology.Philology;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(Philology.INSTANCE.wrap(newBase)));
    }
}
