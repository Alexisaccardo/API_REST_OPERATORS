package com.example.demo;

public class Users {

    public String code;
    public String name;
    public String operator;
    public String ciy;
    public String address;
    public String cellphone;

    public Users(String code, String name, String operator, String ciy, String address, String cellphone) {
        this.code = code;
        this.name = name;
        this.operator = operator;
        this.ciy = ciy;
        this.address = address;
        this.cellphone = cellphone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCiy() {
        return ciy;
    }

    public void setCiy(String ciy) {
        this.ciy = ciy;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
