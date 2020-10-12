package com.example.demo.thread;


/**
 *  lambda 表达式 （带参数）
 */
public class LambdaReturn {
    public static void main(String[] args) {
        IInterest interest = (int a, int b) -> {
            System.out.println("i interest lambda --> " + (a + b));
            return (a + b);
        };

        interest.lambda(100, 200);

        // 简化 省略类型
        IInterest interest2 = (a, b) -> {
            System.out.println("i interest lambda --> " + (a + b));
            return (a + b);
        };

        // 简化 省略（）括号

        // 简化 省略{}括号
        IInterest interest4 = (a, b) -> a + b;
    }
}

interface IInterest {
    int lambda(int a, int b);
}

// 外部类
class Interest implements IInterest {

    @Override
    public int lambda(int a, int b) {
        System.out.println("i interest lambda --> " + (a + b));
        return (a + b);
    }
}
