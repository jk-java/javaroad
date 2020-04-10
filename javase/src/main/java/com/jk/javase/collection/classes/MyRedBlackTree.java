package com.jk.javase.collection.classes;

/**
 * @author jk
 * @Date: 2020/4/1
 */
public class MyRedBlackTree<K , V> {

    private RedBlackTreeNode<K , V> root;

    private static final boolean RED   = false;
    private static final boolean BLACK = true;

    







    static class RedBlackTreeNode<K , V>{
        boolean color;        // 颜色
        K key;                // 关键字(键)
        V value;              // 关键字(值)

        RedBlackTreeNode<K , V> left;    // 左孩子
        RedBlackTreeNode<K , V> right;    // 右孩子
        RedBlackTreeNode<K , V> parent;    // 父结点

        public RedBlackTreeNode(K key , V value , boolean color){
            new RedBlackTreeNode(key , value , color , null , null , null);
        }

        public RedBlackTreeNode(K key , V value , boolean color ,RedBlackTreeNode<K , V> parent , RedBlackTreeNode<K , V> left, RedBlackTreeNode<K , V> right){
            this.key = key;
            this.value = value;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }



    }


    public static void main(String[] args) {
        System.out.println("ss");
    }
}
