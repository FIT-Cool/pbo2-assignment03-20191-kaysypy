package com.kevin.controller;

import com.kevin.Main;
import com.kevin.entity.Category;
import com.kevin.entity.Item;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    @FXML
    private TextField isiID;
    @FXML
    private TextField isiNama;
    @FXML
    private ComboBox<Category> comCat;
    @FXML
    private DatePicker isiDate;
    @FXML
    private TableView<Item> tabItem;
    @FXML
    private TableColumn<Item,Integer> colID;
    @FXML
    private TableColumn<Item,String> colName;
    @FXML
    private TableColumn<Item,String> colCat;
    @FXML
    private TableColumn<Item, Date> colDate;

    private ObservableList<Category> categories;
    private ObservableList<Item> items;

    public ObservableList<Category> getCategories() {
        return categories;
    }

    public ObservableList<Item> getItems() {
        return items;
    }

    public void setCategories(ObservableList<Category> categories) {
        this.categories = categories;
    }

    public void setItems(ObservableList<Item> items) {
        this.items = items;
    }

    @FXML
    private void toCategory(ActionEvent actionEvent) {
        try {
            //Parent root = FXMLLoader.load(Main.class.getResource("view/FacultyForm.fxml"));
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/CategoryManagement.fxml"));
            BorderPane root=loader.load();
            CategoryManagementController controller=loader.getController();//harus dipanggil setelah loader load
            controller.setMainController(this);
            Stage mainStage=new Stage();

            mainStage.setTitle("Category Form");
            mainStage.setScene(new Scene(root));
            mainStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void saveItem(ActionEvent actionEvent) {
		if(isiID.getText().equals("") || isiNama.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Something Missing");
            alert.setContentText("Please fill all the field");

            alert.showAndWait();
        }

        else{
            Item i=new Item();
            i.setID(Integer.parseInt(isiID.getText().trim()));
            i.setNama(isiNama.getText().trim());
            i.setKategori(comCat.getValue());
            i.setDate(isiDate.getValue());
            mainController.getItems().add(i);
        }
    }

    @FXML
    private void resItem(ActionEvent actionEvent) {
		isiID.clear();  
		isiNama.clear();  
		comCat.clear();  
		isiDate.clear();  
    }

    @FXML
    private void upItem(ActionEvent actionEvent) { 
		String change = isiID.getText();
		Item i=new Item();
        i.setID(Integer.parseInt(isiID.getText().trim()));
        i.setNama(isiNama.getText().trim());
        i.setKategori(comCat.getValue());
        i.setDate(isiDate.getValue());
        mainController.getItems().add(i);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
		colID.setCellValueFactory(data ->{
            Item i=data.getValue();
            return new SimpleStringProperty(i.getID());
        });

        colName.setCellValueFactory(data ->{
            Item i=data.getValue();
            return new SimpleStringProperty(p.getNama());
        });

        colCat.setCellValueFactory(data ->{
            Item i=data.getValue();
            return new SimpleStringProperty(i.getCategories().getNama());
        });
		
		colDate.setCellValueFactory(data ->{
            Item i=data.getValue();
            return new SimpleStringProperty(i.getDate());
        });
    }
}
