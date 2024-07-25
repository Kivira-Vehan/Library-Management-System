package tm;

import javafx.scene.control.Button;

public class BorrowTM {
    private String BorrowingID;
    private String MemberID;
    private String BookID;
    private String BorrwDate;
    private String DueDate;
    private String ReturnDate;
    private double Fine;
    private Button btnDelete;

    
    public String getBorrowingID() {
        return BorrowingID;
    }
    public void setBorrowingID(String borrowingID) {
        BorrowingID = borrowingID;
    }
    public String getMemberID() {
        return MemberID;
    }
    public void setMemberID(String memberID) {
        MemberID = memberID;
    }
    public String getBookID() {
        return BookID;
    }
    public void setBookID(String bookID) {
        BookID = bookID;
    }
    public String getBorrwDate() {
        return BorrwDate;
    }
    public void setBorrwDate(String borrwDate) {
        BorrwDate = borrwDate;
    }
    public String getDueDate() {
        return DueDate;
    }
    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }
    public String getReturnDate() {
        return ReturnDate;
    }
    public void setReturnDate(String returnDate) {
        ReturnDate = returnDate;
    }
    public double getFine() {
        return Fine;
    }
    public void setFine(double fine) {
        Fine = fine;
    }
    public Button getBtnDelete() {
        return btnDelete;
    }
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    
    public BorrowTM(String borrowingID, String memberID, String bookID, String borrwDate, String dueDate,
            String returnDate, double fine, Button btnDelete) {
        BorrowingID = borrowingID;
        MemberID = memberID;
        BookID = bookID;
        BorrwDate = borrwDate;
        DueDate = dueDate;
        ReturnDate = returnDate;
        Fine = fine;
        this.btnDelete = btnDelete;
    }

    
    @Override
    public String toString() {
        return "Borrow [BorrowingID=" + BorrowingID + ", MemberID=" + MemberID + ", BookID=" + BookID + ", BorrwDate="
                + BorrwDate + ", DueDate=" + DueDate + ", ReturnDate=" + ReturnDate + ", Fine=" + Fine + ", btnDelete="
                + btnDelete + "]";
    }


   
    

    
    
}
