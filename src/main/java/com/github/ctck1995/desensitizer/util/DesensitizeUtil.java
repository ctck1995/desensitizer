package com.github.ctck1995.desensitizer.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by ck on 2018/9/11.
 * <p/>
 */
public class DesensitizeUtil {

    /**
     * [手机号码] 前4位和后2位显示
     */
    public static String fix_phone(String in) {
        if (StringUtils.isEmpty(in)) {
            return in;
        }
        return StringUtils.left(in, 4)
                .concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(in, 2),
                        StringUtils.length(in), "*"), "****"));
    }

    /**
     * [身份证号码] 前4位和后2位显示
     */
    public static String fix_idcard(String in) {
        if (StringUtils.isEmpty(in)) {
            return in;
        }
        return StringUtils.left(in, 4)
                .concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(in, 2),
                        StringUtils.length(in), "*"), "****"));
    }

}
