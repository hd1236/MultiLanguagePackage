package com.hand.multilanguagepackage.activity;

import android.os.Bundle;
import android.view.View;

import com.hand.multilanguagepackage.R;
import com.hand.multilanguagepackage.philology.StringPhilologyRepositoryFactory;
import com.hand.multilanguagepackage.philology.StringPhilologyRepositoryFactory2;
import com.jcminarro.philology.Philology;
import com.jcminarro.philology.PhilologyRepositoryFactory;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


}
