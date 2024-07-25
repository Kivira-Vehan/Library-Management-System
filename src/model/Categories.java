package model;

public class Categories {
    private String CategoriesID;
    private String CategoriesName;


    public String getCategoriesID() {
        return CategoriesID;
    }
    public void setCategoriesID(String categoriesID) {
        CategoriesID = categoriesID;
    }
    public String getCategoriesName() {
        return CategoriesName;
    }
    public void setCategoriesName(String categoriesName) {
        CategoriesName = categoriesName;
    }

    public Categories(String categoriesID, String categoriesName) {
        this.CategoriesID = categoriesID;
        this.CategoriesName = categoriesName;
    }

    public Categories() {
    }
    @Override
    public String toString() {
        return "Categories [CategoriesID=" + CategoriesID + ", CategoriesName=" + CategoriesName + "]";
    }

    
}
