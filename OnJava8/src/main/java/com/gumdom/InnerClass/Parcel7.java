package com.gumdom.InnerClass;

// innerclasses/Parcel7.java
// Returning an instance of an anonymous inner class
public class Parcel7 {
    public Contents contents() {
        return new Contents() { // Insert class definition
            private int i = 11;

            @Override
            public int value() { return i; }
        }; // Semicolon required
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }
}

class Parcel7b {
    class MyContents implements Contents {
        private int i = 11;
        @Override
        public int value() { return i; }
    }

    public Contents contents() {
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel7b p = new Parcel7b();
        Contents c = p.contents();
    }
}