package model;

public class Books {
    private String BookID;
    private String Title;
    private String Author;
    private double Price;
    private String CategoriesID;
    private int Copies;


    public String getBookID() {
        return BookID;
    }
    public void setBookID(String bookID) {
        BookID = bookID;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }
    public double getPrice() {
        return Price;
    }
    public void setPrice(double price) {
        Price = price;
    }
    public String getCategoriesID() {
        return CategoriesID;
    }
    public void setCategoriesID(String categoriesID) {
        CategoriesID = categoriesID;
    }
    public int getCopies() {
        return Copies;
    }
    public void setCopies(int copies) {
        Copies = copies;
    }

    
    public Books(String bookID, String title, String author, double price, String categoriesID, int copies) {
        this.BookID = bookID;
        this.Title = title;
        this.Author = author;
        this.Price = price;
        this.CategoriesID = categoriesID;
        this.Copies = copies;

        
    }


    public Books() {
    }
    @Override
    public String toString() {
        return "Books [BookID=" + BookID + ", Title=" + Title + ", Author=" + Author + ", Price=" + Price
                + ", CategoriesID=" + CategoriesID + ", Copies=" + Copies + "]";
    }


    

    
}
