package com.team35.drugspot;

public class OrderStateClass {
    String phr_email;
    String spinner;

    public OrderStateClass(String phr_email, String spinner) {
        this.phr_email = phr_email;
        this.spinner = spinner;
    }

    public String getPhr_email() {
        return phr_email;
    }

    public void setPhr_email(String phr_email) {
        this.phr_email = phr_email;
    }

    public String getSpinner() {
        return spinner;
    }

    public void setSpinner(String spinner) {
        this.spinner = spinner;
    }
}
