package com.wh.finaldemos.demos.resource.ResourceMatch;

import com.wh.finaldemos.Demo;

/**
 * Created by wanghui5-s on 2016/2/16.
 * <p/>
 * Conclusion:
 * #1: dump displaymetrics, if density==3.0 use xxhdpi, if density==2.0 use xhdpi,
 *      if density==3.5 use xxxhdpi, that is 1(not include)-1.5 use hdpi,
 *      1.5(not include)-2 use xhdpi, 2(not include)-3 use xxhdpi,
 *      above 3(not include) use xxxhdpi.
 *
 * #2: scaledDensity: A scaling factor for fonts displayed on the display.
 *      This is the same as density, except that it may be adjusted in smaller
 *      increments at runtime based on a user preference for the font size.
 *      will change with setting -> bigger font
 *
 * #3: adb -s fdccece6 shell dumpsys window, in configuration 560dpi,
 *      density=560dpi/160dpi = 3.5 that
 *      match xxxhdpi
 */
public class ResourceMatchDemo extends Demo {

    @Override
    public Class getLaunchActivityClass() {
        return ResourceMatchDemoActivity.class;
    }
}
