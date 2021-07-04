package com.mycompany.mavenproject2.Enums;




public enum UserType {
    ORGANIZER(0, "organizer"),
    VISITOR(1, "visitor");

    UserType(int num, String value){
        this.key = num;
        this.value = value;
    }
    private int key;
    private String value;


}
