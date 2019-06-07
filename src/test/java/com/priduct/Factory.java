package com.priduct;

public class Factory {
    private Emp emp = new Emp();


    public synchronized void produce() throws InterruptedException {
        while (emp.isEmpty()){
            emp.add();
        }
        this.wait();
        notifyAll();

    }
    public synchronized void remove() throws InterruptedException {
        while (emp.isFull()){
            emp.remove();
        }
        wait();
        notifyAll();
    }
}
