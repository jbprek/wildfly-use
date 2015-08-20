package com.mibeez.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Provides a Gson instance with registered  custom serializers for LotosAPI
 *
 * @author prekezes
 */
public class GsonFactory {


    /**
     * Returns a Gson instance with registered  custom serializers for LotosAPI
     *
     * @return a Gson instance with registered  custom serializers for LotosAPI
     */
    public static Gson getInstance() {
        GsonBuilder gsonb = new GsonBuilder();
        gsonb
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
//                .registerTypeAdapter(UnsignedLong.class, new UnsignedLongSerializer())
//                .registerTypeAdapter(UnsignedInteger.class, new UnsignedIntegerSerializer())
//                .registerTypeAdapter(UnsignedShort.class, new UnsignedShortSerializer())
//                .registerTypeAdapter(UnsignedByte.class, new UnsignedByteSerializer())
//                .registerTypeAdapter(Date.class, new UnixTimeSerializer())
                .serializeNulls();
        return gsonb.create();
    }
}
