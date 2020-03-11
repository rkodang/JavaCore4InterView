package com.gumdom.InnerClass;

public class Parcel5 {
    public Destination destination(String s){
        final class PDestination implements Destination{
            private String label;
            private PDestination(String value){
                this.label=value;
            }
            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    };

    public static void main(String[] args) {
        Parcel5 p=new Parcel5();
        Destination d=p.destination("Parcel5测试用");
        System.out.println(d.readLabel());
    }
}
