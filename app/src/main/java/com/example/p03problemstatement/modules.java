package com.example.p03problemstatement;

import java.io.Serializable;
import java.util.ArrayList;

public class modules implements Serializable {
    private String name;
    private String code;
    private ArrayList<String> dg;
    private String email;

    public modules(String name, String code, ArrayList<String> dg, String email) {
        this.name = name;
        this.code = code;
        this.dg = dg;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<String> getDg() {
        return dg;
    }

    public void setDg(ArrayList<String> dg) {
        this.dg = dg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
