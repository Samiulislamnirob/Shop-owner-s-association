package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class VendorPerformanceController {

    @FXML private TextField vendorNameField;
    @FXML private ComboBox<Integer> ratingComboBox;

    @FXML private TableView<VendorRating> ratingsTable;
    @FXML private TableColumn<VendorRating, String> vendorColumn;
    @FXML private TableColumn<VendorRating, String> ratingColumn;

    private final ObservableList<VendorRating> vendorRatings = FXCollections.observableArrayList();

    private VendorRating selectedRating = null;

    @FXML
    public void initialize() {
        // Populate ComboBox with ratings 1 to 5
        ratingComboBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));

        vendorColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getVendorName()));
        ratingColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(String.valueOf(data.getValue().getRating())));

        ratingsTable.setItems(vendorRatings);

        // Optional: select item in table to edit/delete
        ratingsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            selectedRating = newVal;
            if (newVal != null) {
                vendorNameField.setText(newVal.getVendorName());
                ratingComboBox.setValue(newVal.getRating());
            }
        });
    }

    @FXML
    private void handleSubmit() {
        String name = vendorNameField.getText();
        Integer rating = ratingComboBox.getValue();

        if (name.isEmpty() || rating == null) {
            showAlert("Please enter a vendor name and select a rating.");
            return;
        }

        vendorRatings.add(new VendorRating(name, rating));
        clearFields();
        showAlert("Feedback submitted.");
    }

    @FXML
    private void handleEdit() {
        if (selectedRating == null) {
            showAlert("Please select a rating to edit.");
            return;
        }

        String name = vendorNameField.getText();
        Integer rating = ratingComboBox.getValue();

        if (name.isEmpty() || rating == null) {
            showAlert("Please enter both vendor name and rating.");
            return;
        }

        selectedRating.setVendorName(name);
        selectedRating.setRating(rating);
        ratingsTable.refresh();
        clearFields();
        showAlert("Feedback updated.");
    }

    @FXML
    private void handleDelete() {
        if (selectedRating == null) {
            showAlert("Please select a rating to delete.");
            return;
        }

        vendorRatings.remove(selectedRating);
        clearFields();
        showAlert("Feedback deleted.");
    }

    @FXML
    private void handleView() {
        showAlert("Displaying all vendor ratings.");
    }

    @FXML
    private void handleLogout() {
        showAlert("Logging out...");
    }

    private void clearFields() {
        vendorNameField.clear();
        ratingComboBox.setValue(null);
        ratingsTable.getSelectionModel().clearSelection();
        selectedRating = null;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vendor Performance");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

