package com.jk.javase.collection.classes;


//链表实现
//2020.3.12 单链表实现 链表节点只维护了next引用
public class MyLinkList<T> {

    private MyNode<T> head;
    private MyNode<T> last;
    private int size;

            //插入指定位置
    public void insert(T date , int index) throws Exception{
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        MyNode insertNode = new MyNode(date);
        //空链表
        if (size == 0){
            head = insertNode;
            last = insertNode;
        }
        //插入尾不
        else if (size == index){
            last.next = insertNode;
            last = insertNode;
        }
        //插入中间
        else {
            MyNode prevNode = getNode(index);
            MyNode nestNode = prevNode.next;
            prevNode.next = insertNode;
            insertNode.next = nestNode;
        }
        size++;
    }

    //插入链表尾部或者头部
    public void add(T data) throws Exception{
        insert(data , size);

    }


    //链表查找节点
    private MyNode getNode(int index) throws Exception{
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        MyNode temp = head;
        for(int i = 0 ; i<index ; i++){
            temp = temp.next;
        }
        return temp;
    }

    public T get(int index) throws Exception{
        MyNode<T> temp = getNode(index);
        return temp.data;
    }

    //删除链表节点
    public T remove(int index) throws Exception{
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        MyNode<T> removeNode = null;

        if(index == 0){
            //删除头结点
            removeNode = head;
            head = head.next;
        }else if (index == size -1){
            //删除尾节点
            //找到尾节点的上一个节点，切断原来的尾节点，重定向尾节点的引用
            MyNode prevNode = getNode(index -1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
//            removeNode = last;
//            last = last.previous;
//            last.next = null;
        }else{
            //删除中间节点
            //类似于尾节点的删除，只是需要给插入的节点做好节点引用
            MyNode prevNode = getNode(index -1);
            removeNode = prevNode.next;
            prevNode.next = prevNode.next.next;
        }
        size--;
        return removeNode.data;
    }






}
