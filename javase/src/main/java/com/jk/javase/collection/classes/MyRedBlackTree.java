package com.jk.javase.collection.classes;

/**
 * @author jk
 * @Date: 2020/4/1
 */
public class MyRedBlackTree<K , V> {

    private RedBlackTreeNode<K , V> root;

    private static final boolean RED   = false;
    private static final boolean BLACK = true;

    class RedBlackTreeNode<K , V>{
        boolean color;        // 颜色
        K key;                // 关键字(键)
        V value;              // 关键字(值)

        RedBlackTreeNode<K , V> left;    // 左孩子
        RedBlackTreeNode<K , V> right;    // 右孩子
        RedBlackTreeNode<K , V> parent;    // 父结点
    }


    public static void main(String[] args) {
        System.out.println("ss");
    }
}
