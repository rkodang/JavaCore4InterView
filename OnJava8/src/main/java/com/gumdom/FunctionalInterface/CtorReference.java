package com.gumdom.FunctionalInterface;

// functional/CtorReference.java

class Dog {
    String name;
    int age = -1; // For "unknown"
    Dog() { name = "stray";
        System.out.println("无参");}
    Dog(String nm) { name = nm;
        System.out.println("一个参数");}
    Dog(String nm, int yrs) { name = nm; age = yrs;
        System.out.println("两个参数");}
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Arg {
    Dog make(String nm);
}

interface Make2Args {
    Dog make(String nm, int age);
}

public class CtorReference {
    public static void main(String[] args) {
        MakeNoArgs mna = Dog::new; // [1]
        Make1Arg m1a = Dog::new;   // [2]
        Make2Args m2a = Dog::new;  // [3]

        Dog dn = mna.make();
        Dog d1 = m1a.make("Comet");
        Dog d2 = m2a.make("Ralph", 4);
    }
}

