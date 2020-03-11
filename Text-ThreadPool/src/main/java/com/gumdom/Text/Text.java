package com.gumdom.Text;

public class Text {

    public static void main(String[] args) {

        outer:
        for (int i=0;i<4;i++){
            System.out.println("I:"+i);
            for (int j=0;j<4;j++){
                if (i==2){
                    continue outer;
                }
                System.out.println("J:"+j);
            }
        }
    }
}
