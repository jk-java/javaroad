package com.jk.javase.collection.classes;

import basicdatastructure.collection.interfaces.MyList;

import java.util.Collection;

public class MyArrayList<E> implements MyList<E>{

//    List list = new ArrayList();
//    AtomicInteger atomicInteger;

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean add(int index, Object element) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }
}
