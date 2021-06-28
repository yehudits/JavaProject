package Enums;

public enum LoginType {

    SIGNIN(0, "sign in"),
    SINGUP(1, "sing up");

    LoginType(int key, String value){
        this.key = key;
        this.value = value;
    }
    private int key;
    private String value;


}