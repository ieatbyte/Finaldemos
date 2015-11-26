package com.whlib.alib.Log;

import android.util.Log;

/**
 * Created by wanghui5-s on 2015/11/3.
 */
public class XLog {

    public static boolean LOG_ENABLED = true;

    private String cTag;

    private boolean enabled;

    private boolean enableGloalTagAppend;

    private String appendTagString;

    public XLog(Class clss) {
        this(clss, true);
    }

    public XLog(Class clss, boolean enabled) {
        this(clss, enabled, false);
    }

    public XLog(Class clss, boolean enabled, boolean enableGloalTagAppend) {
        this(clss, enabled, enableGloalTagAppend, "XLog");
    }

    public XLog(Class clss, boolean enabled, boolean enableGloalTagAppend, String appendTagString) {
        cTag = clss.getSimpleName();
        this.enabled = enabled;
        this.enableGloalTagAppend = enableGloalTagAppend;
        this.appendTagString = appendTagString;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private String buildMessageWithGlobalTag(String message) {
        if (enableGloalTagAppend) {
            message = "(" + appendTagString + ")" + message;
        }
        return message;
    }

    public void d(String message) {
        if (enabled) {
            message = buildMessageWithGlobalTag(message);
            d(cTag, message);
        }
    }

    public void d(String message, Exception e) {
        if (enabled) {
            message = buildMessageWithGlobalTag(message);
            d(cTag, message, e);
        }
    }

    public void w(String message) {
        if (enabled) {
            message = buildMessageWithGlobalTag(message);
            w(cTag, message);
        }
    }

    public void w(String message, Exception e) {
        if (enabled) {
            message = buildMessageWithGlobalTag(message);
            w(cTag, message, e);
        }
    }

    public void e(String message) {
        if (enabled) {
            message = buildMessageWithGlobalTag(message);
            e(cTag, message);
        }
    }

    public void e(String message, Exception e) {
        if (enabled) {
            message = buildMessageWithGlobalTag(message);
            e(cTag, message, e);
        }
    }

    public static void d(String tag, String message) {
        out(Log.DEBUG, tag, message, null);
    }

    public static void d(String tag, String message, Exception e) {
        out(Log.DEBUG, tag, message, e);
    }

    public static void w(String tag, String message) {
        out(Log.WARN, tag, message, null);
    }

    public static void w(String tag, String message, Exception e) {
        out(Log.WARN, tag, message, e);
    }

    public static void e(String tag, String message) {
        out(Log.ERROR, tag, message, null);
    }

    public static void e(String tag, String message, Exception e) {
        out(Log.ERROR, tag, message, e);
    }

    private static void out(int level, String tag, String message, Exception e) {
        if (LOG_ENABLED) {
            switch (level) {
                case Log.VERBOSE: {
                    if (e != null) {
                        Log.v(tag, message, e);
                    } else {
                        Log.v(tag, message);
                    }
                    break;
                }
                case Log.DEBUG: {
                    if (e != null) {
                        Log.d(tag, message, e);
                    } else {
                        Log.d(tag, message);
                    }
                    break;
                }
                case Log.INFO: {
                    if (e != null) {
                        Log.i(tag, message, e);
                    } else {
                        Log.i(tag, message);
                    }
                    break;
                }
                case Log.WARN: {
                    if (e != null) {
                        Log.w(tag, message, e);
                    } else {
                        Log.w(tag, message);
                    }
                    break;
                }
                case Log.ERROR: {
                    if (e != null) {
                        Log.e(tag, message, e);
                    } else {
                        Log.e(tag, message);
                    }
                    break;
                }
            }
        }
    }
}
