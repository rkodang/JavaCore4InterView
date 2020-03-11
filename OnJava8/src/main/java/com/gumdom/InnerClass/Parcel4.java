package com.gumdom.InnerClass;

public class Parcel4 {
    private class PContents implements Contents{
        private int i=11;
        @Override
        public int value() {

            return i;
        }

        protected final class PDestination implements Destination{
            private String label;
            private PDestination(String value){
                this.label=value;
            }
            @Override
            public String readLabel() {
                return label;
            }
        }

    }
//    public Destination destination(String s){
//        return new PDestination(s);//-->因为是private的,所以无法构建.
//    }

    public Contents contents(){
        return new PContents();
    }

    public static void main(String[] args) {
        Parcel4 p=new Parcel4();
        Contents c=p.contents();
//        Destination d=p.destination("测试用");//-->无法编译,
    }
}

interface Destination{
    String readLabel();
}
interface Contents{
    int value();
}