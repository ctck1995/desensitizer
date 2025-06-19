package com.github.ctck1995.desensitizer.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by ck on 2018/9/11.
 * <p/>
 */
public class DesensitizeUtil {

    public static String fix_phone(String in) {
        return fix_common(in);
    }

    public static String fix_idcard(String in) {
        return fix_common(in);
    }

    public static String fix_common(String in) {
        if (StringUtils.isEmpty(in)) {
            return in;
        }
        if (in.length() > 6) {
            return StringUtils.left(in, 4)
                    .concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(in, 2),
                            StringUtils.length(in), "*"), "****"));
        }
        if (in.length() == 6 || in.length() == 5) {
            return StringUtils.left(in, 2)
                    .concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(in, 2),
                            StringUtils.length(in), "*"), "**"));
        }
        if (in.length() == 4 || in.length() == 3) {
            return StringUtils.left(in, 1)
                    .concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(in, 1),
                            StringUtils.length(in), "*"), "*"));
        }
        if (in.length() == 2) {
            return StringUtils.left(in, 1)
                    .concat("*");
        }
        return in;
    }

}
