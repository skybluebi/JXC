package com.priduct;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    List<String> data = new ArrayList<String>();
    public void produce(){
        synchronized (data) {
            if(data.size()>0){
                System.out.println("可以卖面包了");
                data.notifyAll();
                try {
                    data.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            String a = "面包"+System.currentTimeMillis();
            data.add(a);
            System.out.println("生成了："+a+",找人来吃，现在面包个数为："+data.size());
            //data.notify();
        }
 
    }
 
    public void sale(){
        synchronized (data) {
            if(data.size()==0){
                try {
                    System.out.println("没面包了该通知做面包了");
                    data.notifyAll();
                    data.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            String s = data.get(0);
            data.remove(0);
            System.out.println("吃掉了面包"+s);
            data.notifyAll();
        }
 
    }
 
    public static void main(String[] args) {
        Shop shop = new Shop();
        Thread productor = new Thread(new Productor(shop));
        Thread customer = new Thread(new Customer(shop));
        productor.start();
        customer.start();

 
 
    }
}
class Productor implements Runnable{
    Shop shop;
 
    public Productor(Shop shop) {
        super();
        this.shop = shop;
    }
 
    @Override
    public void run() {
        while(true){
            shop.produce();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // TODO Auto-generated method stub
 
    }
}
class Customer implements Runnable{
    Shop shop;
 
    public Customer(Shop shop) {
        super();
        this.shop = shop;
    }
    @Override
    public void run() {
 
        while(true){
            shop.sale();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
 
                e.printStackTrace();
            }
        }
 
    }
 
}
