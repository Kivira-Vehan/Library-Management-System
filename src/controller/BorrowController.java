package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Borrow;
import tm.BorrowTM;

public class BorrowController {
 @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtBorrowingDate;

    @FXML
    private TextField txtBorrowingID;

    @FXML
    private TextField txtDueDate;

    @FXML
    private TextField txtFine;

    @FXML
    private TextField txtMemberID;

    @FXML
    private TextField txtReturnDate;

    @FXML
    private TableColumn<BorrowTM,String> colborrowdate;

    @FXML
    private TableColumn<BorrowTM,String> colaction;

    @FXML
    private TableColumn<BorrowTM,String> colbookid;

    @FXML
    private TableColumn<BorrowTM,String> colborrowid;

    @FXML
    private TableColumn<BorrowTM,String> colduedate;

    @FXML
    private TableColumn<BorrowTM,Double> colfine;

    @FXML
    private TableColumn<BorrowTM,String> colmemberid;

    @FXML
    private TableColumn<BorrowTM,String> colreturndate;

    @FXML
    private TableView<BorrowTM> tblborrow;

   
    public void initialize() throws ClassNotFoundException, SQLException {
        colborrowid.setCellValueFactory(new PropertyValueFactory<>("BorrowingID"));
        colmemberid.setCellValueFactory(new PropertyValueFactory<>("MemberID"));
        colbookid.setCellValueFactory(new PropertyValueFactory<>("BookID"));
        colborrowdate.setCellValueFactory(new PropertyValueFactory<>("BorrwDate"));
        colduedate.setCellValueFactory(new PropertyValueFactory<>("DueDate"));
        colreturndate.setCellValueFactory(new PropertyValueFactory<>("ReturnDate"));
        colfine.setCellValueFactory(new PropertyValueFactory<>("Fine"));
        colaction.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));

        
        getAllBorrows();
    }

    public void getAllBorrows() throws ClassNotFoundException, SQLException {
        
        PreparedStatement statement = DBConnection.getInstance().getConnection()
                .prepareStatement("SELECT * FROM borrowings");
        ResultSet borrowSet = statement.executeQuery();

        ArrayList<Borrow> borrowList = new ArrayList<Borrow>();

        while (borrowSet.next()) {
            Borrow borrow = new Borrow(
                    borrowSet.getString(1),
                    borrowSet.getString(2),
                    borrowSet.getString(3),
                    borrowSet.getString(4),
                    borrowSet.getString(5),
                    borrowSet.getString(6),
                    borrowSet.getDouble(7));

            borrowList.add(borrow);
        }

   
        ObservableList<BorrowTM> borrowTMList = FXCollections.observableArrayList();

        for (Borrow borrow : borrowList) {
            Button button = new Button("Delete");

            BorrowTM borrowTM = new BorrowTM(
                    borrow.getBorrowingID(),
                    borrow.getMemberID(),
                    borrow.getBookID(),
                    borrow.getBorrwDate(),
                    borrow.getDueDate(),
                    borrow.getReturnDate(),
                    borrow.getFine(),
                    button);

            borrowTMList.add(borrowTM);
        }

        tblborrow.setItems(borrowTMList);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String BorrowingID = txtBorrowingID.getText();
        String MemberID = txtMemberID.getText();
        String BookID = txtBookID.getText();
        String BorrwDate = txtBorrowingDate.getText();
        String DueDate = txtDueDate.getText();
        String ReturnDate = txtReturnDate.getText();
        double Fine = Double.parseDouble(txtFine.getText());

        Borrow borrow = new Borrow(BorrowingID,MemberID,BookID,BorrwDate,DueDate, ReturnDate,Fine);
        System.out.println(borrow);

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO borrowings VALUES (?,?,?,?,?,?,?)");
        statement.setObject(1, borrow.getBorrowingID());
        statement.setObject(2, borrow.getMemberID());
        statement.setObject(3, borrow.getBookID());
        statement.setObject(4, borrow.getBorrwDate());
        statement.setObject(5, borrow.getDueDate());
        statement.setObject(6, borrow.getReturnDate());
        statement.setObject(7, borrow.getFine());

        int rows = statement.executeUpdate();
        if(rows>0){
            System.out.println("Borrow Saved Successfully!!!");
            new Alert(Alert.AlertType.CONFIRMATION,"Borrow Saved Successfully!!!").show();
        }else{
            System.out.println("Error While Saving Borrow");
            new Alert(Alert.AlertType.ERROR,"Error While Saving Borrow").show();
        }

        initialize();
    }

   
}
