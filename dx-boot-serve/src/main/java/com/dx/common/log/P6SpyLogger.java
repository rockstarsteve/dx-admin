package com.dx.common.log;

import com.p6spy.engine.common.P6Util;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

import java.util.Date;

/**
 * Description: com.dx.log
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/6/12
 */
public class P6SpyLogger implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {

        StringBuilder sb = new StringBuilder();
        sb
                .append("\n=====================================================\n")
                .append("连接id：").append(connectionId).append("\n")
                .append("当前时间：").append(now).append("\n")
                .append("类别：").append(category).append("\n")
                .append("花费时间：").append(elapsed).append("ms \n")
                .append("url：").append(url).append("\n")
                .append("预编译sql：").append(P6Util.singleLine(prepared)).append("\n")
                .append("最终执行的sql：").append(!"".equals(sql.trim()) ? new Date() + " | " + category + " | connection " + connectionId + "\n " + sql + ";" : "")
                .append("\n=====================================================\n");
        return sb.toString();


    }
}
