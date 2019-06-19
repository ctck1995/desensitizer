package com.github.ctck1995.desensitizer.support.fastjson;

import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.ContextValueFilter;
import com.github.ctck1995.desensitizer.annotation.Desensitize;
import com.github.ctck1995.desensitizer.global.DesensitizeType;
import com.github.ctck1995.desensitizer.util.DesensitizeUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by ck on 2018/9/12.
 * <p/>
 */
public class DesensitizeFilter implements ContextValueFilter {

    @Override
    public Object process(BeanContext context, Object object, String name, Object value) {
        if (context != null && value != null && value instanceof String) {
            Desensitize annation = context.getAnnation(Desensitize.class);
            if (annation != null) {
                String in = (String) value;
                if (!StringUtils.isBlank(in)) {
                    return dss(in, annation.value());
                }
            }
        }
        return value;
    }

    private String dss(String in, DesensitizeType type) {
        try {
            switch (type) {
                case FIX_PHONE: {
                    in = DesensitizeUtil.fix_phone(in);
                    break;
                }
                case FIX_IDCARD: {
                    in = DesensitizeUtil.fix_idcard(in);
                    break;
                }
                default: break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return in;
    }
}
