package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:查找
 */
public abstract class BaseSearch<T extends Comparable<? super T>> {
    //region 1.field字段   最小权限原则

    T[] items;
    long duration;
    private int compareCount;
    private int swapCount;
    int moveStep;
    //endregion

    BaseSearch(){

    }

    BaseSearch(T[] items) {
        this.items = items;
        compareCount = 0;
        swapCount = 0;
        moveStep = 0;
    }

    boolean equal(T a, T b) {
        compareCount++;
        return a.compareTo(b) == 0;
    }

    int compare(T a, T b) {
        compareCount++;
        return a.compareTo(b);
    }

    public abstract int search(T key);


    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getCompareCount() {
        return compareCount;
    }

    public void setCompareCount(int compareCount) {
        this.compareCount = compareCount;
    }

    public int getSwapCount() {
        return swapCount;
    }

    public void setSwapCount(int swapCount) {
        this.swapCount = swapCount;
    }

}



