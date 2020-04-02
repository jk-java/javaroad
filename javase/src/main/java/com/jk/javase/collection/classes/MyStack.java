package com.jk.javase.collection.classes;

//2020.3.12 开始栈实现
public class MyStack<T> {

   static class MyStackByArray<T> {
        private int size;
        private int top = -1;

        private T[] stack;

        MyStackByArray(int capacity) {
            stack = (T[]) new Object[capacity];

        }

        MyStackByArray() {
            this(16);
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(T data) {
            if(data != null) {
                stack[++top] = data;
                size++;
            }
        }

        public T pop() {
            if (isEmpty()) {
                return null;
            }
            T t = stack[top--];
            size--;
            return t;
        }

        public void print() {
            if (isEmpty()) {
                System.out.println("这是个空栈");
            } else {
                int topTemp = top;
                while (topTemp >= 0) {
                    System.out.println(stack[topTemp--]);
                }
            }
        }

        //原数组扩容
        //验证是否需要扩容，并解决扩容的
        private void ensureCapacityInternal(int minCapacity) {

        }

    }

    //3.16 链表栈实现完成
    static class MyStackByLink<T> {
        private int size;

        private MyNode<T> head;

        //链表入栈
        public void push(T data) {
            if (data == null) {
                return;
            }
            MyNode pushNode = new MyNode(data);
            if (head == null) {
                head = pushNode;
            } else {
                pushNode.next = head;
                head = pushNode;
            }
            size++;
        }

        //链表出栈
        public T pop() throws Exception {
            if (isEmpty()) {
                return null;
            }
            MyNode<T> popNode = head;
            head = head.next;
            popNode.next = null;//清空引用，可以帮助垃圾回收
            size--;
            return popNode.data;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void print() {
            if (head == null) {
                System.out.println("这是个空栈");
            } else {
                MyNode node = head;
                while (node != null) {
                    System.out.println(node.data);
                    node = node.next;
                }

            }
        }


    }

    public static void main(String[] args) throws Exception {
//        MyStackByLink<Integer> myStackByLink = new MyStackByLink<Integer>();
//        myStackByLink.push(2);
//        myStackByLink.push(1);
//        myStackByLink.push(3);
//        myStackByLink.push(4);
//        myStackByLink.pop();
//        myStackByLink.pop();
//        myStackByLink.pop();
//        myStackByLink.pop();
//        myStackByLink.push(4);
//        myStackByLink.pop();
//        myStackByLink.pop();
////        int stackSize = myStackByLink.size();
////        System.out.println(stackSize);
//        myStackByLink.print();
//        System.out.println("---------------");

        MyStackByArray<Integer> myStackByArray = new MyStackByArray<Integer>();

        myStackByArray.push(2);
        myStackByArray.push(1);
        myStackByArray.push(3);
        myStackByArray.push(4);
        myStackByArray.push(6);
        myStackByArray.pop();
        myStackByArray.pop();
        myStackByArray.pop();
        myStackByArray.pop();
        myStackByArray.pop();
        myStackByArray.pop();
        myStackByArray.push(6);
        myStackByArray.print();
    }
}
