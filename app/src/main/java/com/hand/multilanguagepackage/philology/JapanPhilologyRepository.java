package com.hand.multilanguagepackage.philology;

import android.content.Context;

import com.hand.multilanguagepackage.resource.ResourceReader;
import com.jcminarro.philology.PhilologyRepository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JapanPhilologyRepository implements PhilologyRepository {

    private Context mContext;
    private Map<String,String> mStrings = new HashMap<>();;

    public JapanPhilologyRepository(Context context){
        mContext = context;
        InputStream is;
        try {
            is = mContext.getResources().getAssets().open("Japan.xml");
            ResourceReader.xmlReader(mStrings,is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Nullable
    @Override
    public CharSequence getText(@NotNull String s) {
        if(mStrings.containsKey(s)){
            return mStrings.get(s);
        }
        return null;
    }
}
