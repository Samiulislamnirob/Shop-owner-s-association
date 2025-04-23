package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmergencyAlertController {

    @FXML private TextField alertTypeField;
    @FXML private TextField locationField;

    @FXML private TableView<EmergencyAlert> alertHistoryTable;
    @FXML private TableColumn<EmergencyAlert, String> alertTypeColumn;
    @FXML private TableColumn<EmergencyAlert, String> locationColumn;
    @FXML private TableColumn<EmergencyAlert, String> dateTimeColumn;

    private final ObservableList<EmergencyAlert> alertHistory = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        alertTypeColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getAlertType()));
        locationColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getLocation()));
        dateTimeColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDateTime()));

        alertHistoryTable.setItems(alertHistory);
    }

    @FXML
    private void handleSendAlert() {
        String alertType = alertTypeField.getText();
        String location = locationField.getText();

        if (alertType.isEmpty() || location.isEmpty()) {
            showAlert("Please enter both alert type and location.");
            return;
        }

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        alertHistory.add(new EmergencyAlert(alertType, location, dateTime));
        showAlert("Alert sent to all members.");

        clearFields();
    }

    @FXML
    private void handleConfirm() {
        showAlert("Alert confirmed sent.");
    }

    @FXML
    private void handleClear() {
        clearFields();
        showAlert("Form cleared.");
    }

    @FXML
    private void handleExport() {
        showAlert("Exporting alert logs... (demo action)");
    }

    @FXML
    private void handleLogout() {
        showAlert("Logging out... (demo action)");
    }

    private void clearFields() {
        alertTypeField.clear();
        locationField.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Emergency Alert");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

