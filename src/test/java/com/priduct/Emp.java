package com.priduct;

import java.util.ArrayList;
import java.util.List;

public class Emp {
    private static final int caprcity=1;
    private List list = new ArrayList(caprcity);

    public void add() {
            list.add(new Object());
        System.out.println(Thread.currentThread().getName()+"add");
    }
    public void remove(){
        if (!list.isEmpty()){
            list.clear();
        }else {
            throw new RuntimeException("数组为空");
        }
        System.out.println(Thread.currentThread().getName()+"remove");
    }
    public boolean isFull(){
        return list.size()==caprcity;
    }
    public boolean isEmpty(){
        return list.size()==0;
    }
}
