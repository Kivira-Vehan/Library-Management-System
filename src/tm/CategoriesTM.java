package tm;

import javafx.scene.control.Button;

public class CategoriesTM {
    private String CategoriesID;
    private String CategoriesName;
    private Button btnDelete;

    
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
    public Button getBtnDelete() {
        return btnDelete;
    }
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }
    
    public CategoriesTM(String string, String categoriesName, Button btnDelete) {
        CategoriesID = string;
        CategoriesName = categoriesName;
        this.btnDelete = btnDelete;
    }
    @Override
    public String toString() {
        return "CategoriesTM [CategoriesID=" + CategoriesID + ", CategoriesName=" + CategoriesName + ", btnDelete="
                + btnDelete + "]";
    }
    
   

    
}
