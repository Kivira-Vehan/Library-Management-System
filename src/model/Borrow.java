package model;

public class Borrow {
    private String BorrowingID;
    private String MemberID;
    private String BookID;
    private String BorrwDate;
    private String DueDate;
    private String ReturnDate;
    private double Fine;

    
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

    
    public Borrow() {
    }
    
    public Borrow(String borrowingID, String memberID, String bookID, String borrwDate, String dueDate,
            String returnDate, double fine) {
        this.BorrowingID = borrowingID;
        this.MemberID = memberID;
        this.BookID = bookID;
        this.BorrwDate = borrwDate;
        this.DueDate = dueDate;
        this.ReturnDate = returnDate;
        this.Fine = fine;
    }
    
    @Override
    public String toString() {
        return "Borrow [BorrowingID=" + BorrowingID + ", MemberID=" + MemberID + ", BookID=" + BookID + ", BorrwDate="
                + BorrwDate + ", DueDate=" + DueDate + ", ReturnDate=" + ReturnDate + ", Fine=" + Fine + "]";
    }


    

    
}
