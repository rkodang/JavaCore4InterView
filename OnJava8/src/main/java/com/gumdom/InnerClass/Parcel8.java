package com.gumdom.InnerClass;

// innerclasses/Parcel8.java
// Calling the base-class constructor
public class Parcel8 {
    public Wrapping wrapping(int x) {
        // Base constructor call:
        return new Wrapping(x) { // [1]
            @Override
            public int value() {
                return super.value() * 47;
            }
        }; // [2]
    }
    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
    }
}

class Wrapping {
    private int i;
    public Wrapping(int x) { i = x; }
    public int value() { return i; }
}