package com.jyn.subsectionseekbar;

import androidx.annotation.ColorInt;

/**
 * 颜色分段bean类
 */
public class SectionBean {
    /**
     * 颜色 RGB值
     */
    @ColorInt
    private int color;
    /**
     * 起点
     */
    private double origin;
    /**
     * 终点
     */
    private double terminus;

    /**
     * 是否要跳过
     */
    private boolean isSkip;

    public SectionBean(int color, double origin, double terminus, boolean isSkip) {
        this.color = color;
        this.origin = origin;
        this.terminus = terminus;
        this.isSkip = isSkip;
    }

    public int getColor() {
        return color;
    }

    public void setColor(@ColorInt int color) {
        this.color = color;
    }

    public double getOrigin() {
        return origin;
    }

    public void setOrigin(double origin) {
        this.origin = origin;
    }

    public double getTerminus() {
        return terminus;
    }

    public void setTerminus(double terminus) {
        this.terminus = terminus;
    }

    public boolean isSkip() {
        return isSkip;
    }

    public void setSkip(boolean skip) {
        isSkip = skip;
    }
}
