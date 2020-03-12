package com.gumdom.FunctionalInterface;

public class Strategize {
    Strategy strategy;//组合一个接口
    String msg;
    Strategize(String msg){//构造函数
        strategy=new Soft();
        this.msg=msg;
    }

    void communicate(){
        //调用接口类方法
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy){
        //变换接口中的对象
        this.strategy=strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies={
                new Strategy() {
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase()+"!";
                    }
                },
                msg1 -> msg1.substring(0,5),
                Unrelated::twice
        };
        Strategize s=new Strategize("Hello there");
        s.communicate();
        for (Strategy strategy : strategies) {
            s.changeStrategy(strategy);
            s.communicate();

        }
    }
}

interface Strategy{
    String approach(String msg);
}

class Soft implements Strategy{

    @Override
    public String approach(String msg) {
        return msg.toLowerCase()+"?";
    }
}

class Unrelated{
    static String twice(String msg){
        return msg+" "+msg;
    }
}

