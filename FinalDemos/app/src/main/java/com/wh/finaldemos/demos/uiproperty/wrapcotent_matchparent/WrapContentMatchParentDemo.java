package com.wh.finaldemos.demos.uiproperty.wrapcotent_matchparent;

import com.wh.finaldemos.Demo;

/**
 * Created by wanghui5-s on 2016/4/5.
 * <p/>
 * Conclusion:
 * #1:Buttons in Lollipop and higher have a default elevation to them which causes them to always draw on top. You can change this by overriding the default StateListAnimator.
 *      see http://stackoverflow.com/questions/33017735/incorrect-overlay-behavior-in-framelayout
 *
 * #2: parent with wrap_content, child with match_parent is a special case, for framelayout and linerlayout, it does have meaning but with different way
 *
 *      for framelayout, child match parent does not really work, it turns to be like wrap_content
 *      for linearlayout, child match parent will work; child best be all match parent but not with wrap_cotent, see ok2
 *      both better unify with all wrapcontent or match parent for child, if not exception may happen
 *
 *      it will ask the child with UNSPECIFIED and set self size with child size
 */
public class WrapContentMatchParentDemo extends Demo {

    @Override
    public Class getLaunchActivityClass() {
        return WrapContentMatchParentDemoActivity.class;
    }
}
