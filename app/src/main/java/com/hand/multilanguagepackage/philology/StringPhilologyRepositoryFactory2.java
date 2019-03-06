package com.hand.multilanguagepackage.philology;

import android.content.Context;

import com.jcminarro.philology.PhilologyRepository;
import com.jcminarro.philology.PhilologyRepositoryFactory;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public class StringPhilologyRepositoryFactory2 implements PhilologyRepositoryFactory {
    private Context mContext;
    public StringPhilologyRepositoryFactory2(Context context){
        mContext = context;
    }

    @Nullable
    @Override
    public PhilologyRepository getPhilologyRepository(@NotNull Locale locale) {
        if(Locale.ENGLISH.getLanguage().equals(locale.getLanguage())){
            return new JapanPhilologyRepository(mContext);
        }
        return null;
    }
}
