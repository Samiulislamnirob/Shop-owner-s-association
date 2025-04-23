package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OwnerProfileController {

    @FXML private TextField nameField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;
    @FXML private TextField shopNameField;

    @FXML private TableView<ShopOwner> ownerTable;
    @FXML private TableColumn<ShopOwner, String> nameCol;
    @FXML private TableColumn<ShopOwner, String> phoneCol;
    @FXML private TableColumn<ShopOwner, String> emailCol;
    @FXML private TableColumn<ShopOwner, String> shopCol;

    private final ObservableList<ShopOwner> ownerList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));
        phoneCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getPhone()));
        emailCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getEmail()));
        shopCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getShopName()));

        ownerTable.setItems(ownerList);
    }

    @FXML
    private void handleSave() {
        ShopOwner owner = getOwnerFromFields();
        if (owner != null) {
            ownerList.add(owner);
            showAlert("Profile saved successfully.");
            clearForm();
        }
    }

    @FXML
    private void handleUpdate() {
        ShopOwner selected = ownerTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setName(nameField.getText());
            selected.setPhone(phoneField.getText());
            selected.setEmail(emailField.getText());
            selected.setShopName(shopNameField.getText());
            ownerTable.refresh();
            showAlert("Profile updated.");
            clearForm();
        } else {
            showAlert("Please select a profile to update.");
        }
    }

    @FXML
    private void handleDelete() {
        ShopOwner selected = ownerTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            ownerList.remove(selected);
            showAlert("Profile deleted.");
            clearForm();
        } else {
            showAlert("Please select a profile to delete.");
        }
    }

    @FXML
    private void handleClear() {
        clearForm();
    }

    @FXML
    private void handleLogout() {
        showAlert("Logging out...");
    }

    private void clearForm() {
        nameField.clear();
        phoneField.clear();
        emailField.clear();
        shopNameField.clear();
    }

    private ShopOwner getOwnerFromFields() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String shop = shopNameField.getText();

        if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || shop.isEmpty()) {
            showAlert("All fields must be filled.");
            return null;
        }

        return new ShopOwner(name, phone, email, shop);
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Shop Owner Profile");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

