package test.java;

import java.util.Arrays;

public class MyArrayList<E> {

    private int size=0;
    private Object[] elements;

    public MyArrayList() {
        int capacity = 10;
        elements = new Object[capacity];
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCap();
        }
        elements[size++] = e;
    }
    private void ensureCap() {
        int newSize=2*elements.length;
        elements = Arrays.copyOf(elements,newSize);
    }
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }

    public int size() {
        return size;
    }

}
