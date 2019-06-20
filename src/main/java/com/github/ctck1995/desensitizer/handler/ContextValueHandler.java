package com.github.ctck1995.desensitizer.handler;

import com.github.ctck1995.desensitizer.adapter.IdCardTypeAdapter;
import com.github.ctck1995.desensitizer.adapter.NoneTypeAdapter;
import com.github.ctck1995.desensitizer.adapter.PhoneTypeAdapter;
import com.github.ctck1995.desensitizer.adapter.TypeAdapter;
import com.github.ctck1995.desensitizer.annotation.Desensitize;
import com.github.ctck1995.desensitizer.global.DesensitizeType;

/**
 * Created by ck on 2019/6/20.
 * <p/>
 */
public class ContextValueHandler {

    @SuppressWarnings("unchecked")
    public static Object handle(Desensitize annation, Object value) {
        if (annation != null) {
            DesensitizeType desensitizeType = annation.value();
            Class<? extends TypeAdapter> adapterCls;
            if (desensitizeType != DesensitizeType.FIX_NONE) {
                adapterCls = findAdapter(desensitizeType);
            } else {
                adapterCls = annation.adapterCls();
            }
            if (!adapterCls.equals(NoneTypeAdapter.class)) {
                try {
                    TypeAdapter typeAdapter = adapterCls.newInstance();
                    value =  typeAdapter.handle(value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    private static Class<? extends TypeAdapter<?>> findAdapter(DesensitizeType type) {
        switch (type) {
            case FIX_PHONE: {
                return PhoneTypeAdapter.class;
            }
            case FIX_IDCARD: {
                return IdCardTypeAdapter.class;
            }
            default: return NoneTypeAdapter.class;
        }
    }
}
