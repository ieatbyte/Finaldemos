package com.wh.finaldemos.demos.media;

import com.wh.finaldemos.DemoGroup;
import com.wh.finaldemos.demos.media.video.surfaceview.simpleplay.SurfaceViewPlayMp4Demo;
import com.wh.finaldemos.demos.media.video.textureview.simpleplay.TextureViewPlayMp4Demo;
import com.wh.finaldemos.demos.media.video.videoview.simplePlay.VideoViewPlayMp4Demo;

/**
 * Created by wanghui5-s on 2015/12/7.
 * <p/>
 * Conclusion:
 * #1:
 */
public class MediaDemos extends DemoGroup {

    private final Class[] demos = new Class[]{
            VideoViewPlayMp4Demo.class, SurfaceViewPlayMp4Demo.class, TextureViewPlayMp4Demo.class
    };

    @Override
    public Class[] getSubDemoClasses() {
        return demos;
    }

    @Override
    public Class getLaunchActivityClass() {
        return MediaDemosListActivity.class;
    }
}
