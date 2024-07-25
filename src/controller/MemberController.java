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
import javafx.scene.input.KeyEvent;
import model.Member;
import tm.MemberTM;

public class MemberController {

    
    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMemberID;

    @FXML
    private TextField txtMemberName;

    @FXML
    private TextField txtMobileNumber;

    @FXML
    private TableColumn<MemberTM,String> colaction;

    @FXML
    private TableColumn<MemberTM,String> coladdress;

    @FXML
    private TableColumn<MemberTM,String> colemail;

    @FXML
    private TableColumn<MemberTM,String> colmembersid;

    @FXML
    private TableColumn<MemberTM,String> colmembersname;

    @FXML
    private TableColumn<MemberTM,String> colnumber;

    @FXML
    private TableView<MemberTM> tblmembers;

     public void initialize() throws ClassNotFoundException, SQLException {
        colmembersid.setCellValueFactory(new PropertyValueFactory<>("MemberID"));
        colmembersname.setCellValueFactory(new PropertyValueFactory<>("MemberName"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colnumber.setCellValueFactory(new PropertyValueFactory<>("MobileNumber"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colaction.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));

        
        getAllMembers();
    }

    public void getAllMembers() throws ClassNotFoundException, SQLException {
        
        PreparedStatement statement = DBConnection.getInstance().getConnection()
                .prepareStatement("SELECT * FROM members");
        ResultSet membersSet = statement.executeQuery();

        ArrayList<Member> membersList = new ArrayList<Member>();

        while (membersSet.next()) {
            Member member = new Member(
                    membersSet.getString(1),
                    membersSet.getString(2),
                    membersSet.getString(3),
                    membersSet.getString(4),
                    membersSet.getString(5));
                    

            membersList.add(member);
        }

   
        ObservableList<MemberTM> membersTMList = FXCollections.observableArrayList();

        for (Member member : membersList) {
            Button button = new Button("Delete");

            MemberTM memberTM = new MemberTM(
                    member.getMemberID(),
                    member.getMemberName(),
                    member.getEmail(),
                    member.getMobileNumber(),
                    member.getAddress(),
                    button);

            membersTMList.add(memberTM);
        }

        tblmembers.setItems(membersTMList);
    }
     


    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String MemberID = txtMemberID.getText();
        String MemberName = txtMemberName.getText();
        String Email = txtEmail.getText();
        String MobileNumber = txtMobileNumber.getText();
        String Address = txtAddress.getText();

        Member member = new Member(MemberID,MemberName,Email,MobileNumber,Address);
        System.out.println(member);

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO members VALUES (?,?,?,?,?)");
        statement.setObject(1, member.getMemberID());
        statement.setObject(2, member.getMemberName());
        statement.setObject(3, member.getEmail());
        statement.setObject(4, member.getMobileNumber());
        statement.setObject(5, member.getAddress());

        int rows = statement.executeUpdate();
        if(rows>0){
            System.out.println("Member Saved Successfully!!!");
            new Alert(Alert.AlertType.CONFIRMATION,"Member Saved Successfully!!!").show();
        }else{
            System.out.println("Error While Saving Member");
            new Alert(Alert.AlertType.ERROR,"Error While Saving Member").show();
        }

        initialize();
    }


      @FXML
    void enteronaction(KeyEvent event) throws Exception {
       
    
                String MemberID = txtMemberID.getText();
                String resp = deleteCustomer(MemberID);
                if(resp == "Success"){
                    System.out.println("Member Deleted Successfully!!!");
                    new Alert(Alert.AlertType.CONFIRMATION,"Member Deleted Successfully!!!").show();
                }else{
                    System.out.println("Error While Deleting Member");
                    new Alert(Alert.AlertType.ERROR,"Error While Deleting Member").show();
                }
        
                initialize();
        
    }



    public String deleteCustomer(String membersid) throws Exception{
        // String sql = "DELETE FROM members WHERE MemberID = ?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM members WHERE MemberID = ?");
        statement.setString(1,membersid);

        return statement.executeUpdate() >0 ? "Success" : "Fail";

    }
    
        

    
}
