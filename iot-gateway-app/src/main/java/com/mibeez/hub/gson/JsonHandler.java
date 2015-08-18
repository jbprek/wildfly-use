package com.mibeez.hub.gson;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * @author prekezes.
 */
public class JsonHandler {

    private static final Gson gson = GsonFactory.getInstance();



    /**
     * {@inheritDoc}
     */
    public <T> String toJson(T obj) {
        return gson.toJson(obj);
    }

    /**
     * {@inheritDoc}
     */
    public <T> T fromJson(String json, Type type) throws JsonSyntaxException {
            return gson.fromJson(json, type);

    }



}
