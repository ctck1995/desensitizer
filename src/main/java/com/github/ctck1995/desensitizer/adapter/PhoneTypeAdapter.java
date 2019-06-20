package com.github.ctck1995.desensitizer.adapter;

import com.github.ctck1995.desensitizer.util.DesensitizeUtil;

/**
 * Created by ck on 2019/6/20.
 * <p/>
 */
public class PhoneTypeAdapter implements TypeAdapter<String> {
    @Override
    public String handle(String in) {
        return DesensitizeUtil.fix_phone(in);
    }
}
