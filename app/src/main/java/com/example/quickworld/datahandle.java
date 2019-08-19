package com.example.quickworld;

public class datahandle {
    protected String Username = "abc";
    protected String password = "xyz";

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
