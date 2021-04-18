package com.team35.drugspot;

public class Distributor {
    String DisFullName;
    String DisNic;
    String DisNum;
    String DisEmail;
    String DisPassword;

    public Distributor(String DisFullName, String DisNic, String DisNum, String DisEmail, String DisPassword) {
        this.DisFullName = DisFullName;
        this.DisNic = DisNic;
        this.DisNum = DisNum;
        this.DisEmail = DisEmail;
        this.DisPassword = DisPassword;
    }

    public String getDisFullName() {
        return DisFullName;
    }

    public String getDisNic() {
        return DisNic;
    }

    public String getDisNum() {
        return DisNum;
    }

    public String getDisEmail() {
        return DisEmail;
    }

    public String getDisPassword() {
        return DisPassword;
    }
}
