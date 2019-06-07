package com;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList<T> implements List<T> {
    public static void main(String[] args) {
//        MyList<Integer> integers = new MyList<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        integers.add(4);
//        System.out.println(integers);
        for (int i = 0; i < 10; i++) {
            if (i==5){
                break;
            }
            System.out.println(i);
        }
//        int [] ints=new int[34];
//        int size=0;
//        ints[size++]=5;
//        System.out.println(ints[0]);
//
//       Student a=new Student(3,"a");
//       Student b=a;
//       a=null;
//        System.out.println("a:"+a+",b:"+b);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < tArray.length; i++) {
            stringBuffer.append(tArray[i]);
        }
        return stringBuffer.toString();
    }

    private Object[] tArray = {};
    private int capacity;
    private int size;

    public MyList() {
        tArray = new Object[16];
        capacity = 16;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        tArray[size] = t;
        size++;
        //数组扩容
        if (size > tArray.length / 2) {
            Object[] newArr = new Object[capacity * 2];
            for (int i = 0; i < tArray.length; i++) {
                newArr[i] = tArray[i];
            }
            tArray = newArr;
            capacity=newArr.length;
        }

        return true;
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
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
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
    public T get(int index) {
        if (index>capacity-1){
            throw new IndexOutOfBoundsException("数组越界！");
        }

        return (T) tArray[index];
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
