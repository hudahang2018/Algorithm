package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class DirectSearch<T extends Comparable<? super T>>extends BaseSearch {
    DirectSearch(T[] items){
        super(items);
    }

    @Override
    int search(Comparable key) {
        return 0;
    }
}
