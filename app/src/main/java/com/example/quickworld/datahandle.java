package com.example.quickworld;


public class datahandle {
    protected String Username = "abc";
    protected String password = "xyz";
    private String Lat;
    private String Log;
    public static String ph="7018828810";


    public datahandle(){
    }

    public datahandle(String la,String lo){
        Lat = la;
        Log = lo;
    }

    public String getLat(){
        return Lat;
    }

    public String getLog(){
        return Log;
    }

    public boolean checkpass(String pwd){
        if(pwd.equals( password)){
            return true;
        }else {
            return false;
        }
    }

    public boolean checkuser(String une){
        if(une.equals(Username)){
            return true;
        }else {
            return false;
        }
    }

}
