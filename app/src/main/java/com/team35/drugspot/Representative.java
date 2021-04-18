package com.team35.drugspot;

public class Representative {
    String RepFullName;
    String RepNic;
    String RepNum;
    String RepEmail;
    String RepPassword;

    public Representative(String repFullName, String repNic, String repNum, String repEmail, String repPassword) {
        RepFullName = repFullName;
        RepNic = repNic;
        RepNum = repNum;
        RepEmail = repEmail;
        RepPassword = repPassword;
    }

    public String getRepFullName() {
        return RepFullName;
    }

    public String getRepNic() {
        return RepNic;
    }

    public String getRepNum() {
        return RepNum;
    }

    public String getRepEmail() {
        return RepEmail;
    }

    public String getRepPassword() {
        return RepPassword;
    }
}
