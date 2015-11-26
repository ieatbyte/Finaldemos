package com.whlib.jlib.file;

import java.io.File;

/**
 * Created by wanghui5-s on 2015/10/23.
 */
public class Path {

    public static String mergePathWithTailName(String prefixPath, String tailName) {
        return mergePathWithTailName(prefixPath, tailName, File.separator);
    }

    public static String mergePathWithTailName(String prefixPath, String tailName, String separator) {
        if (prefixPath == null || tailName == null) {
            return null;
        }
        StringBuilder mergedPath = new StringBuilder();
        if (prefixPath.endsWith(separator)) {
            mergedPath.append(prefixPath);
            if (!tailName.startsWith(separator)) {
                mergedPath.append(tailName);
            } else {
                mergedPath.append(tailName.substring(tailName.indexOf(separator) + 1));
            }
        } else {
            if (!tailName.startsWith(separator)) {
                mergedPath.append(prefixPath);
                mergedPath.append(separator);
                mergedPath.append(tailName);
            } else {
                mergedPath.append(prefixPath);
                mergedPath.append(tailName);
            }
        }
        return mergedPath.toString();
    }
}
