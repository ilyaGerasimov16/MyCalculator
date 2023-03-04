package com.example.helloworld;


import java.io.Serializable;

public class CurrentNumber implements Serializable {
    String number = "";

    String getNumber() {
        return number;
    }

    void addDigit(String digit){
        this.number = number + digit;
    }

    void resetToZero(){
        setNumber("");
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
