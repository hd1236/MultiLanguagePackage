package com.hand.multilanguagepackage.resource;

import android.text.TextUtils;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ResourceReader {

    public static void xmlReader(Map<String,String> strings, InputStream inputStream){
        XmlPullParser parser = Xml.newPullParser();
        try {
            int eventType = parser.getEventType();
            parser.setInput(inputStream,"UTF-8");
            while (eventType != XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:
                        if(strings == null){
                            strings = new HashMap<>();
                        }
                        break;
                    case XmlPullParser.START_TAG:
                        String xName = parser.getName();
                        if("string".equals(xName)){
                            String key = parser.getAttributeValue(0);
                            String value = parser.nextText();
                            if(!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                                strings.put(key, value);
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
