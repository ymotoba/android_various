package com.example.android_test;

import android.R.integer;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * アニメーション描画のためのユーティリティを提供します
 * 
 * @author Kazz.
 * @since JDK1.5 Android Level 4
 *
 */

public class AnimationHelper {
    private static final int DURATION = 250;
    /**
     * 右から入ってくる動作表現するアニメーションを生成、取得します
     * @return Animation 生成したアニメーションが戻ります
     */
    public static Animation inFromRightAnimation() {

        Animation inFromRight = 
            new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT
                    , +1.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f);
        inFromRight.setDuration(DURATION);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }
    /**
     * 左に通過していく動作表現するアニメーションを生成、取得します
     * @return Animation 生成したアニメーションが戻ります
     */
    public static Animation outToLeftAnimation() {
        Animation outtoLeft = 
            new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , -1.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f);
        outtoLeft.setDuration(DURATION);
        outtoLeft.setInterpolator(new AccelerateInterpolator());
        return outtoLeft;
    }    
    /**
     * 左から入ってくる動作を表現するアニメーションを生成、取得します
     * @return Animation 生成したアニメーションが戻ります
     */
    public static Animation inFromLeftAnimation() {
        Animation inFromLeft = 
            new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT
                    , -1.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f);
        inFromLeft.setDuration(DURATION);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }
    /**
     * 右に通過していく動作を表現するアニメーションを生成、取得します
     * @return Animation 生成したアニメーションが戻ります
     */
    public static Animation outToRightAnimation() {
        Animation outtoRight = 
            new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , +1.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f );
        outtoRight.setDuration(DURATION);
        outtoRight.setInterpolator(new AccelerateInterpolator());
        return outtoRight;
    }           

    /**
     * 上から下がってくる動作表現するアニメーションを生成、取得します
     * @return Animation 生成したアニメーションが戻ります
     */
    public static Animation inFromTopAnimation() {

        Animation inFromTop = 
            new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , -1.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f);
        inFromTop.setDuration(DURATION);
        inFromTop.setInterpolator(new AccelerateInterpolator());
        return inFromTop;
    }
    /**
     * 下に通過していく動作表現するアニメーションを生成、取得します
     * @return Animation 生成したアニメーションが戻ります
     */
    public static Animation outToBottomAnimation() {
        Animation outToBottom = 
            new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , +1.0f);
        outToBottom.setDuration(DURATION);
        outToBottom.setInterpolator(new AccelerateInterpolator());
        return outToBottom;
    }    

    /**
     * 下から昇って入ってくる動作を表現するアニメーションを生成、取得します
     * @return Animation 生成したアニメーションが戻ります
     */
    public static Animation inFromBottomAnimation() {
        Animation inFromBottom = 
            new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 1.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f);
        inFromBottom.setDuration(DURATION);
        inFromBottom.setInterpolator(new AccelerateInterpolator());
        return inFromBottom;
    }
    /**
     * 上に通過していく動作を表現するアニメーションを生成、取得します
     * @return Animation 生成したアニメーションが戻ります
     */
    public static Animation outToTopAnimation() {
        Animation outToTop = 
            new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , 0.0f
                    , Animation.RELATIVE_TO_PARENT
                    , -1.0f );
        outToTop.setDuration(DURATION);
        outToTop.setInterpolator(new AccelerateInterpolator());
        return outToTop;
    }           
}