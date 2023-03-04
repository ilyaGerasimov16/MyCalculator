package com.example.helloworld;

import java.io.Serializable;

public class IntermediateValue implements Serializable {
    private String intermediateValue = "";

    public String getIntermediateValue() {
        return intermediateValue;
    }

    public void setIntermediateValue(String intermediateValue) {
        this.intermediateValue = intermediateValue;
    }

    void resetToZero(){
        intermediateValue = "";
    }
}
