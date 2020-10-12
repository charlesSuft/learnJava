package com.example.demo.proxy;


/**
 *  静态代理
 *  接口：
 *  1. 真实角色
 *  2. 代理角色
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
    }
}

interface Marry {
    void happyMarry();
}

class You implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("you and 嫦娥 终于奔月了");
    }
}

// 代理角色
class WeddingCompany implements Marry {

    // 真实角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    private void ready() {
        System.out.println("准备");
    }

    private void after() {
        System.out.println("收拾");
    }
}
