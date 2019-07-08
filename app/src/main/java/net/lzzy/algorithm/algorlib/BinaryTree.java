package net.lzzy.algorithm.algorlib;

import android.util.Pair;

import java.security.Key;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:二叉树
 */

public class BinaryTree<T extends Comparable<? super T>> extends BaseSearch<T> {
    private Pair<Integer, T> root;
    //记录他们的值(T)还有位置(Integer)
    // 左子树  右子树

    private BinaryTree<T> left, right;

    BinaryTree(T[] items) {
        super(items);
        root = new Pair<>(0, items[0]);
        for (int i = 1; i < items.length; i++) {
            addNode(new Pair<>(i, items[i]));
        }
    }
    //构造器

    private BinaryTree(Pair<Integer, T> node) {
        root = node;
    }

    private void addNode(Pair<Integer, T> node) {
        //todo:增加节点的方法
        int comp = compare(node.second, root.second);
        //右子树

        if (comp > 0) {
            if (comp > 0) {
                if (right == null) {
                    right = new BinaryTree<>(node);
                }
            } else {
                right.addNode(node);
            }
        }
        //左子树

        if (comp < 0) {
            if (left == null) {
                left = new BinaryTree<>(node);
            } else {
                left.addNode(node);
            }
        }

    }

    private long start = -1;

    @Override
    public int search(T key) {
        if (start < 0) {
            start = System.currentTimeMillis();
        }
        int comp = compare(key, root.second);
        if (comp == 0) {
            setDuration(System.currentTimeMillis() - start);
            return root.first;
        } else if (comp > 0) {
            if (right == null) {
                setDuration(System.currentTimeMillis() - start);
                return -1;
            } else {
                return right.search(key);
            }
        } else {
            if (left == null) {
                setDuration(System.currentTimeMillis() - start);
                return -1;
            } else {
                return left.search(key);
            }
        }
    }
}

