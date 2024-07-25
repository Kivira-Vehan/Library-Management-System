package tm;

import javafx.scene.control.Button;

public class MemberTM {
    private String MemberID;
    private String MemberName;
    private String Email;
    private String MobileNumber;
    private String Address;
    private Button btnDelete;


    
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
    public Button getBtnDelete() {
        return btnDelete;
    }
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    
    public MemberTM(String memberID, String memberName, String email, String mobileNumber, String address,
            Button btnDelete) {
        MemberID = memberID;
        MemberName = memberName;
        Email = email;
        MobileNumber = mobileNumber;
        Address = address;
        this.btnDelete = btnDelete;
    }

    @Override
    public String toString() {
        return "MemberTM [MemberID=" + MemberID + ", MemberName=" + MemberName + ", Email=" + Email + ", MobileNumber="
                + MobileNumber + ", Address=" + Address + ", btnDelete=" + btnDelete + "]";
    }


    

    
}
