package model;

public class Member {
    private String MemberID;
    private String MemberName;
    private String Email;
    private String MobileNumber;
    private String Address;
    

    public Member(String memberID, String memberName, String email, String mobileNumber, String address) {
        this.MemberID = memberID;
        this.MemberName = memberName;
        this.Email = email;
        this.MobileNumber = mobileNumber;
        this.Address = address;
    }

    
    public Member() {
    }


    public String getMemberID() {
        return MemberID;
    }
    public void setMemberID(String memberID) {
        MemberID = memberID;
    }
    public String getMemberName() {
        return MemberName;
    }
    public void setMemberName(String memberName) {
        MemberName = memberName;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getMobileNumber() {
        return MobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }


    @Override
    public String toString() {
        return "Member [MemberID=" + MemberID + ", MemberName=" + MemberName + ", Email=" + Email + ", MobileNumber="
                + MobileNumber + ", Address=" + Address + "]";
    }

    

}
