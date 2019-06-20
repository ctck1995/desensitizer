package com.github.ctck1995.desensitizer.support.fastjson;

import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.ContextValueFilter;
import com.github.ctck1995.desensitizer.annotation.Desensitize;
import com.github.ctck1995.desensitizer.handler.ContextValueHandler;

/**
 * Created by ck on 2018/9/12.
 * <p/>
 */
public class DesensitizeFilter implements ContextValueFilter {

    @Override
    public Object process(BeanContext context, Object object, String name, Object value) {
        if (context != null) {
            Desensitize annation = context.getAnnation(Desensitize.class);
            value = ContextValueHandler.handle(annation, value);
        }
        return value;
    }
}
