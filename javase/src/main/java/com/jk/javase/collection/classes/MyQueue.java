package com.jk.javase.collection.classes;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MyQueue<Item> implements Iterable<Item>, Queue<Item> {

    private Node first;
    private Node last;
    private int size;
//LinkedList linkList;

    private class Node {
        Item item;
        Node next;
    }


    @Override
    public boolean add(Item item) {
        //添加元素，向表尾添加，由于结构是链表形式，即 将原链表尾节点中的指针指向新增加的节点。。。

        //1. 记录下原尾节点
        Node oldlast = last;

        //2. 将变量last更新为新添加的尾节点，组织节点数据
        last = new Node();
        last.item = item;
        last.next = null;

        //3. 将原来的尾节点指向现在的尾节点
        if (isEmpty()) {
            //若是第一次添加，说明上一个尾节点为 NULL ，无需操作，该节点即也是头结点
            first = last;
        } else {
            //若非第一次添加，则需将上一个尾节点指向新增加的节点，头结点不需动
            oldlast.next = last;
        }

        //4. 添加完毕后让队列大小自增1
        size++;
        //5. 返回添加正确的结果
        return true;
    }

    @Override
    public boolean offer(Item item) {
        return false;
    }

    /**\
     *检索并删除此队列的头。
     * @return
     */
    @Override
    public Item remove() {
        Item item = poll();
        if(item == null ){
            throw new NoSuchElementException();
        }
        return item;
    }

    /**
     * 检索并删除此队列的头，如果此队列为空，则返回 null 。
     * @return
     */
    @Override
    public Item poll() {
        if (first == null) {
            return null;
        } else {
            Node oldfirst = first;
            Node next = first.next;
            Item item = oldfirst.item;
            oldfirst.item = null;
            oldfirst.next = null;//help GC
            first = next;
            if (first == null) {
                last = null;
            }
            size--;
            return item;
        }

    }

    /**
     * 检索但不删除这个队列的头。 此方法与peek的不同之处在于，如果此队列为空，它将抛出异常。
     * @return
     */
    @Override
    public Item element() {
        Node oldfirst = first;
        if (oldfirst == null)
            throw new NoSuchElementException();
        return oldfirst.item;
    }

    /**
     * 检索但不删除此队列的头部，如果此队列为空，则返回 null 。
     *
     * @return
     */
    @Override
    public Item peek() {
        Node oldfirst = first;

        return oldfirst == null ? null : oldfirst.item;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean addAll(Collection<? extends Item> c) {
        return false;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
