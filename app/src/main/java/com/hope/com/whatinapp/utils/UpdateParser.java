package com.hope.com.whatinapp.utils;

import android.util.Xml;

import com.hope.com.whatinapp.domain.UpdateInfo;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Day on 2016/8/28.
 */
public class UpdateParser {
    //解析XML

    public static UpdateInfo getUpdateInfo(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        UpdateInfo updateInfo = new UpdateInfo();
        xmlPullParser.setInput(inputStream, "UTF-8");
        int eventType = xmlPullParser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case (XmlPullParser.START_DOCUMENT):
                    if ("version".equals(xmlPullParser.getName())) {
                        String version = xmlPullParser.nextText();
                        updateInfo.setVersion(version);
                    } else if ("description".equals(xmlPullParser.getName())) {
                        String description = xmlPullParser.nextText();
                        updateInfo.setVersion(description);
                    } else if ("url".equals(xmlPullParser.getName())) {
                        String url = xmlPullParser.nextText();
                        updateInfo.setVersion(url);
                    }
                    break;
            }
            eventType = xmlPullParser.next();
        }
        return updateInfo;


    }
}