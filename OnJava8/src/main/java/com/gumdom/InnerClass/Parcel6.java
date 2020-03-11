package com.gumdom.InnerClass;

public class Parcel6 {
    private void internalTracking(boolean b){
        if(b){
            class TrackingSlip{
                private String id;
                TrackingSlip(String value){
                    this.id=value;
                };
                void getSlip(){
                    System.out.println(id);
                }
            }
            TrackingSlip ts01=new TrackingSlip("Parcel6测试用");
            ts01.getSlip();
        }

    }
    public void track(){internalTracking(true);}
    public static void main(String[] args) {
        Parcel6 p=new Parcel6();
        p.track();
    }
}
