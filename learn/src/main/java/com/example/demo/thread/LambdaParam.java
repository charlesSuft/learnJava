package com.example.demo.thread;


/**
 *  lambda 表达式 （带参数）
 */
public class LambdaParam {
    public static void main(String[] args) {
        ILove love = (int a) -> {
            System.out.println("i love lambda --> " + a);
        };

        love.lambda(100);

        // 简化 省略类型
        ILove love2 = (a) -> {
            System.out.println("i love lambda --> " + a);
        };

        // 简化 省略（）括号
        ILove love3 = a -> {
            System.out.println("i love lambda --> " + a);
        };

        // 简化 省略{}括号
        ILove love4 = a -> System.out.println("i love lambda --> " + a);
    }
}

interface ILove {
    void lambda(int a);
}

// 外部类
class love implements ILove {

    @Override
    public void lambda(int a) {
        System.out.println("i love lambda --> " + a);
    }
}
