package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CCTVController {

    @FXML private ComboBox<String> cameraZoneComboBox;
    @FXML private TextArea notesField;

    @FXML private TableView<CCTVLog> logTable;
    @FXML private TableColumn<CCTVLog, String> zoneColumn;
    @FXML private TableColumn<CCTVLog, String> timestampColumn;
    @FXML private TableColumn<CCTVLog, String> notesColumn;

    private final ObservableList<CCTVLog> logList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        cameraZoneComboBox.setItems(FXCollections.observableArrayList("Zone A", "Zone B", "Zone C", "Main Gate"));

        zoneColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getZone()));
        timestampColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTimestamp()));
        notesColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNotes()));

        logTable.setItems(logList);
    }

    @FXML
    private void handleViewLiveFeed() {
        showAlert("Displaying live CCTV feed (simulated).");
    }

    @FXML
    private void handleViewLogs() {
        showAlert("Displaying recorded logs (simulated).");
    }

    @FXML
    private void handleSaveLog() {
        String zone = cameraZoneComboBox.getValue();
        String notes = notesField.getText();

        if (zone == null || notes.isEmpty()) {
            showAlert("Please select a camera zone and write some notes.");
            return;
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logList.add(new CCTVLog(zone, timestamp, notes));

        showAlert("Log entry saved.");
        clearForm();
    }

    @FXML
    private void handleDownloadSnapshot() {
        showAlert("Snapshot downloaded (simulated).");
    }

    @FXML
    private void handleClearForm() {
        clearForm();
    }

    @FXML
    private void handleLogout() {
        showAlert("Logging out...");
    }

    private void clearForm() {
        cameraZoneComboBox.setValue(null);
        notesField.clear();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CCTV Monitoring");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
