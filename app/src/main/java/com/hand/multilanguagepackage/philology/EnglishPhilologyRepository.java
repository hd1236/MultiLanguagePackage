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

public class EnglishPhilologyRepository implements PhilologyRepository {

    private Context mContext;
    private Map<String,String> mStrings = new HashMap<>();;

    public EnglishPhilologyRepository(Context context){
        mContext = context;
        InputStream is;
        try {
            is = mContext.getResources().getAssets().open("English.xml");
            ResourceReader.xmlReader(mStrings,is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public CharSequence getText(@NotNull String s) {
//        if(s.equals("main_activity")){
//            return "First page,hello world";
//        }
//        if(s.equals("click_go")){
//            return "click jump";
//        }
//        if(s.equals("second_activity")){
//            return "Second page,I'm the word that needs to be converted";
//        }
        if(mStrings.containsKey(s)){
            return mStrings.get(s);
        }
        return null;
    }
}
