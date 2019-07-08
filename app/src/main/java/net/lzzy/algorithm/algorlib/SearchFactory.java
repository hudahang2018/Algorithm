package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:查找的工厂类
 */
public class SearchFactory {
    public static <T extends Comparable<? super T>> BaseSearch<T> getInstance(int key, T[] items) {
        BaseSearch<T> search;
        switch (key) {
            case 0:
                search = new DirectSearch<>(items);
                break;
            case 1:
                search = new BinarySearch<>(items);
                break;
            case 2:
                search = new BinaryTree<>(items);
                break;
            default:
                return null;
        }
        return search;
    }

    public static String[] getSearchNames() {
        return new String[]{"顺序查找", "二分查找",};
    }

}
