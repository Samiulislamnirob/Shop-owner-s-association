package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MaintenanceController {

    @FXML private TextField shoptextfield;
    @FXML private ComboBox<String> issuetype;
    @FXML private TextArea description;
    @FXML private ComboBox<String> urgencycombobox;

    @FXML private TableView<MaintenanceRequest> tableview;
    @FXML private TableColumn<MaintenanceRequest, String> shopnamecolumn;
    @FXML private TableColumn<MaintenanceRequest, String> issuetypecolumn;
    @FXML private TableColumn<MaintenanceRequest, String> descriptioncolumn;
    @FXML private TableColumn<MaintenanceRequest, String> urgentcolumn;

    @FXML private PasswordField passTextfield;
    @FXML private TextField username;

    private ObservableList<MaintenanceRequest> requestList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        shopnamecolumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getShopName()));
        issuetypecolumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getIssueType()));
        descriptioncolumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescription()));
        urgentcolumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getUrgencyLevel()));

        tableview.setItems(requestList);
    }

    @FXML
    void handlelogin() {
        System.out.println("Login pressed");
    }

    @FXML
    void handlesubmit() {
        String shop = shoptextfield.getText();
        String issue = issuetype.getValue();
        String desc = description.getText();
        String urgency = urgencycombobox.getValue();

        if (shop.isEmpty() || issue == null || desc.isEmpty() || urgency == null) {
            showAlert("Please fill all fields.");
            return;
        }

        MaintenanceRequest request = new MaintenanceRequest(shop, issue, desc, urgency);
        requestList.add(request);
        clearFields();
    }

    @FXML
    void handleclear() {
        clearFields();
    }

    private void clearFields() {
        shoptextfield.clear();
        issuetype.setValue(null);
        description.clear();
        urgencycombobox.setValue(null);
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    void handlelogout() {
        System.out.println("Logout clicked");
    }

    @FXML
    void handleeditrequest() {
        showAlert("Edit functionality coming soon!");
    }
}
