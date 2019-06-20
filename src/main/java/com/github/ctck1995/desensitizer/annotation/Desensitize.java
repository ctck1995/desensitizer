package com.github.ctck1995.desensitizer.annotation;

import com.github.ctck1995.desensitizer.adapter.NoneTypeAdapter;
import com.github.ctck1995.desensitizer.adapter.TypeAdapter;
import com.github.ctck1995.desensitizer.global.DesensitizeType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ck on 2018/9/12.
 * <p/>
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Desensitize {
    DesensitizeType value() default DesensitizeType.FIX_NONE;
    Class<? extends TypeAdapter> adapterCls() default NoneTypeAdapter.class;
}
