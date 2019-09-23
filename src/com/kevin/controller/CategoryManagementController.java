package com.kevin.controller;

import com.kevin.entity.Category;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryManagementController implements Initializable {
    public TextField isiID;
    public TextField isiName;
    public TableView<Category> catTable;
    public TableColumn<Category, Integer> colID;
    public TableColumn<Category, String> colcat;

    private MainFormController mainController;

    public void setMainController(MainFormController mainController) {
        this.mainController = mainController;
        catTable.setItems(mainController.getCategories());
    }

    public void saveCat(ActionEvent actionEvent) {
        if(isiID.getText().equals("") || isiName.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Something Missing");
            alert.setContentText("Please fill all the field");

            alert.showAndWait();
        }

        else{
            Category c=new Category();

            c.setNama(isiName.getText().trim());
            c.setID(Integer.parseInt(isiID.getText()));

            mainController.getCategories().add(c);


        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colID.setCellValueFactory(data -> {
            Category c = data.getValue();
            return new SimpleIntegerProperty(c.getID()).asObject();
        });

        colcat.setCellValueFactory(data ->{
            Category c=data.getValue();
            return new SimpleStringProperty(c.getNama());
        });
    }

}
