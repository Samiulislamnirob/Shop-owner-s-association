package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class MaintenanceReportController {

    @FXML private DatePicker fromDatePicker;
    @FXML private DatePicker toDatePicker;

    @FXML private TableView<MaintenanceReportEntry> reportTable;
    @FXML private TableColumn<MaintenanceReportEntry, String> dateColumn;
    @FXML private TableColumn<MaintenanceReportEntry, String> taskColumn;
    @FXML private TableColumn<MaintenanceReportEntry, String> areaColumn;
    @FXML private TableColumn<MaintenanceReportEntry, String> statusColumn;
    @FXML private TableColumn<MaintenanceReportEntry, String> staffColumn;

    private final ObservableList<MaintenanceReportEntry> reportList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        dateColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDate()));
        taskColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTask()));
        areaColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getArea()));
        statusColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));
        staffColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStaff()));

        reportTable.setItems(reportList);
    }

    @FXML
    private void handleViewActivities() {
        LocalDate from = fromDatePicker.getValue();
        LocalDate to = toDatePicker.getValue();

        if (from == null || to == null) {
            showAlert("Please select both From and To dates.");
            return;
        }

        // Fake data for now
        reportList.clear();
        reportList.add(new MaintenanceReportEntry("2025-04-22", "Fix AC", "Block A", "Completed", "Mizan"));
        reportList.add(new MaintenanceReportEntry("2025-04-23", "Clean Restroom", "Block C", "Pending", "Faruk"));

        showAlert("Maintenance activities loaded.");
    }

    @FXML
    private void handleExport() {
        showAlert("Exporting report... (demo)");
    }

    @FXML
    private void handleSavePdf() {
        showAlert("Saving report as PDF... (demo)");
    }

    @FXML
    private void handlePrint() {
        showAlert("Sending to printer... (demo)");
    }

    @FXML
    private void handleClear() {
        fromDatePicker.setValue(null);
        toDatePicker.setValue(null);
        reportList.clear();
        showAlert("Filters and table cleared.");
    }

    @FXML
    private void handleLogout() {
        showAlert("Logging out... (demo)");
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Maintenance Report");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

