package com.gumdom.FunctionalInterface;

// functional/LambdaExpressions.java

interface Description {
    String brief();
}

interface Body {
    String detailed(String head);
}

interface Multi {
    String twoArg(String head, Double d);
}

public class LamdaExpressions {

    static Body bod = h -> h + " No Parens!"; // [1]h是代表head形参参数,只有一个参数可以不写括号

    // [2]->正常情况适用()包裹参数,为了保持一致性,也可以使用()包裹单个参数
    static Body bod2 = (h) -> h + " More details";

    static Description desc = () -> "Short info"; // [3]->没有参数必须用()表示空参数列表

    static Multi mult = (h, n) -> h + n; // [4]多个参数则必须使用()来表示空参数列表

    // [5]如果Lambda表达式中确实需要多行就必须将代码写在{}内
    static Description moreLines = () -> {
        System.out.println("moreLines()");
        return "from moreLines()";
    };

    public static void main(String[] args) {
        System.out.println(bod.detailed("Oh!"));
        System.out.println(bod2.detailed("Hi!"));
        System.out.println(desc.brief());
        System.out.println(mult.twoArg("Pi! ", 3.14159));
        System.out.println(moreLines.brief());
    }
}
