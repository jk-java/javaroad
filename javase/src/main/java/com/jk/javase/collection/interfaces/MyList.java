package basicdatastructure.collection.interfaces;

import java.util.Collection;

public interface MyList<E> {

    boolean add(E e);
    boolean add(int index, E element);
    boolean addAll(Collection<? extends E> c);
    boolean addAll(int index, Collection<? extends E> c);
    boolean clear();
    boolean contains(Object o);

    boolean containsAll(Collection<?> c);
    boolean equals(Object o);
}
