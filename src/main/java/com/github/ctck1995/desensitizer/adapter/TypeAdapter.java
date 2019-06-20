package com.github.ctck1995.desensitizer.adapter;

/**
 * Created by ck on 2019/6/20.
 * <p/>
 */
public interface TypeAdapter<T> {
    T handle(T in);
}
