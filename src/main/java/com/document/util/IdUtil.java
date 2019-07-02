package com.document.util;

import com.relops.snowflake.Snowflake;
import org.apache.commons.lang3.RandomUtils;

public class IdUtil {

    private static Snowflake s = new Snowflake(RandomUtils.nextInt(0, 1024));

    public static String next(){
        String id = s.next() + "";
        String pre = id.substring(0, 10);
        String suf = id.substring(10, 19);
        id = Long.parseLong(pre) + Long.parseLong(suf) + "";
        return id;
    }
}
