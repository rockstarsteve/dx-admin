package com.dx.easypoi.util;

import java.io.File;
import java.util.UUID;

/**
 * @author yaojian
 * @Description
 * @createTime 2021/11/26
 */
public class ExcelUtil {
    /**
     * 获取下载路径
     *
     * @param filename 文件名称
     */
    public static String getAbsoluteFile(String filename)
    {
        String downloadPath = "D://" + filename;
        File desc = new File(downloadPath);
        if (!desc.getParentFile().exists())
        {
            desc.getParentFile().mkdirs();
        }
        return downloadPath;
    }

    /**
     * 编码文件名
     */
    public static String encodingFilename(String filename)
    {
        filename = UUID.randomUUID().toString() + "_" + filename + ".xlsx";
        return filename;
    }
}
