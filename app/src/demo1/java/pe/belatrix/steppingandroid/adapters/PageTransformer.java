package pe.belatrix.steppingandroid.adapters;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * @author Danihelsan
 */
public class PageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.85f;

    private ViewPager mViewPager;
    private float mPositionFixer;
    private boolean isSetFixer = false;

    public  PageTransformer(ViewPager viewPager) {
        mViewPager = viewPager;
    }

    public void transformPage(View view, float position) {
        final int pageWidth = view.getWidth();
        final int pageHeight = view.getHeight();

        if(!isSetFixer) {
            final int mClientWidth = mViewPager.getMeasuredWidth() -
                    mViewPager.getPaddingLeft() - mViewPager.getPaddingRight();
            mPositionFixer = ((float)mViewPager.getPaddingStart()) / mClientWidth;
            isSetFixer = true;
        }

        position -= mPositionFixer;

        if (position <= 1) {
            final float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            final float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            final float horzMargin = pageWidth * (1 - scaleFactor) / 2;

            if (position < 0) {
                view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }

            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
        }
    }
}