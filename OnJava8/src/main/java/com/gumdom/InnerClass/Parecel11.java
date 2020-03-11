package com.gumdom.InnerClass;

// innerclasses/Parcel11.java
// Nested classes (static inner classes)
public class Parecel11 {
    private static class ParcelContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected static final class ParcelDestination
            implements Destination {
        private String label;

        private ParcelDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }

        // Nested classes can contain other static elements:
        public static void f() {
        }

        static int x = 10;

        static class AnotherLevel {
            public static void f() {
            }

            static int x = 10;
        }
    }

    public static Destination destination(String s) {
        System.out.println("执行destination方法");
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        System.out.println("执行contens方法");
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
    }
}

