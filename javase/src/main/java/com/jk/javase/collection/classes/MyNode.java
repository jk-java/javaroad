package com.jk.javase.collection.classes;

/**
 * @author jk
 * @Date: 2020/3/12
 */
//链表节点
public class MyNode<T> {


    public T data;
    //    private MyNode<T> previous;
    public MyNode<T> next;

    MyNode(T data) {
        this.data = data;
    }



}
