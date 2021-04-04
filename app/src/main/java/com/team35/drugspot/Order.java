package com.team35.drugspot;

public class Order {
    String phmAddress;
    String phmEmail;
    String phmName;
    String phmNum;
    String phmOrder;

    public Order(String phmAddress, String phmEmail, String phmName, String phmNum, String phmOrder) {
        this.phmAddress = phmAddress;
        this.phmEmail = phmEmail;
        this.phmName = phmName;
        this.phmNum = phmNum;
        this.phmOrder = phmOrder;
    }

    public String getPhmAddress() {
        return phmAddress;
    }

    public String getPhmEmail() {
        return phmEmail;
    }

    public String getPhmName() {
        return phmName;
    }

    public String getPhmNum() {
        return phmNum;
    }

    public String getPhmOrder() {
        return phmOrder;
    }
}
