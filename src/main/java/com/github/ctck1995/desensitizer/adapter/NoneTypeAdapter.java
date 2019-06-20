package com.github.ctck1995.desensitizer.adapter;

/**
 * Created by ck on 2019/6/20.
 * <p/>
 */
public class NoneTypeAdapter implements TypeAdapter<Object> {
    @Override
    public Object handle(Object in) {
        return null;
    }
}
