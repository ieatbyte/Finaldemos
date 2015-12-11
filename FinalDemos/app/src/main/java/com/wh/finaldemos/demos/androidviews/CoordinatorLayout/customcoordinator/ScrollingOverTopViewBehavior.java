package com.wh.finaldemos.demos.androidviews.CoordinatorLayout.customcoordinator;

/**
 * Created by wanghui5-s on 2015/12/10.
 * <p/>
 * Conclusion:
 * #1:
 */
public class ScrollingOverTopViewBehavior { // extends HeaderScrollingViewBehavior {


//    private int mOverlayTop;
//
//    public ScrollingOverTopViewBehavior() {}
//
//    public ScrollingOverTopViewBehavior(Context context, AttributeSet attrs) {
//        super(context, attrs);
//
//        TypedArray a = context.obtainStyledAttributes(attrs,
//                android.support.design.R.styleable.ScrollingViewBehavior_Params);
//        mOverlayTop = a.getDimensionPixelSize(
//                android.support.design.R.styleable.ScrollingViewBehavior_Params_behavior_overlapTop, 0);
//        a.recycle();
//    }
//
//    @Override
//    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
//        // We depend on any AppBarLayouts
//        return dependency instanceof AppBarLayout;
//    }
//
//    @Override
//    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
//        // First lay out the child as normal
//        super.onLayoutChild(parent, child, layoutDirection);
//
//        // Now offset us correctly to be in the correct position. This is important for things
//        // like activity transitions which rely on accurate positioning after the first layout.
//        final List<View> dependencies = parent.getDependencies(child);
//        for (int i = 0, z = dependencies.size(); i < z; i++) {
//            if (updateOffset(parent, child, dependencies.get(i))) {
//                // If we updated the offset, break out of the loop now
//                break;
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public boolean onDependentViewChanged(CoordinatorLayout parent, View child,
//                                          View dependency) {
//        updateOffset(parent, child, dependency);
//        return false;
//    }
//
//    private boolean updateOffset(CoordinatorLayout parent, View child, View dependency) {
//        final CoordinatorLayout.Behavior behavior =
//                ((CoordinatorLayout.LayoutParams) dependency.getLayoutParams()).getBehavior();
//        if (behavior instanceof CoordinatorLayout.Behavior) {
//            // Offset the child so that it is below the app-bar (with any overlap)
//            final int offset = ((CoordinatorLayout.Behavior) behavior).getTopBottomOffsetForScrollingSibling();
//            setTopAndBottomOffset(dependency.getHeight() + offset
//                    - getOverlapForOffset(dependency, offset));
//            return true;
//        }
//        return false;
//    }
//
//    private int getOverlapForOffset(final View dependency, final int offset) {
//        if (mOverlayTop != 0 && dependency instanceof AppBarLayout) {
//            final AppBarLayout abl = (AppBarLayout) dependency;
//            final int totalScrollRange = abl.getTotalScrollRange();
//            final int preScrollDown = abl.getDownNestedPreScrollRange();
//
//            if (preScrollDown != 0 && (totalScrollRange + offset) <= preScrollDown) {
//                // If we're in a pre-scroll down. Don't use the offset at all.
//                return 0;
//            } else {
//                final int availScrollRange = totalScrollRange - preScrollDown;
//                if (availScrollRange != 0) {
//                    // Else we'll use a interpolated ratio of the overlap, depending on offset
//                    final float percScrolled = offset / (float) availScrollRange;
//                    return MathUtils.constrain(
//                            Math.round((1f + percScrolled) * mOverlayTop), 0, mOverlayTop);
//                }
//            }
//        }
//        return mOverlayTop;
//    }
//
//    /**
//     * Set the distance that this view should overlap any {@link AppBarLayout}.
//     *
//     * @param overlayTop the distance in px
//     */
//    public void setOverlayTop(int overlayTop) {
//        mOverlayTop = overlayTop;
//    }
//
//    /**
//     * Returns the distance that this view should overlap any {@link AppBarLayout}.
//     */
//    public int getOverlayTop() {
//        return mOverlayTop;
//    }
//
//    @Override
//    View findFirstDependency(List<View> views) {
//        for (int i = 0, z = views.size(); i < z; i++) {
//            View view = views.get(i);
//            if (view instanceof AppBarLayout) {
//                return view;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    int getScrollRange(View v) {
//        if (v instanceof AppBarLayout) {
//            return ((AppBarLayout) v).getTotalScrollRange();
//        } else {
//            return super.getScrollRange(v);
//        }
//    }
}
