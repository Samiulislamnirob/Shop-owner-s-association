package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReportController {

    @FXML private ComboBox<String> reportTypeBox;
    @FXML private TextField memberFilterField;
    @FXML private DatePicker datePicker;
    @FXML private TextArea reportOutput;

    @FXML
    public void initialize() {
        reportTypeBox.getItems().addAll("Attendance", "Feedback", "Events");
    }

    @FXML
    private void handleGenerate() {
        String type = reportTypeBox.getValue();
        String member = memberFilterField.getText();
        String date = (datePicker.getValue() != null) ? datePicker.getValue().toString() : "Any Date";

        if (type == null) {
            showAlert("Please select a report type.");
            return;
        }

        // Simulate report generation
        String content = "Report Type: " + type + "\n" +
                "Filtered By: " + (member.isEmpty() ? "All Members" : member) + "\n" +
                "Date: " + date + "\n\n" +
                "[Sample Report Data Here...]";

        reportOutput.setText(content);
    }

    @FXML
    private void handleExportPDF() {
        showAlert("Report exported as PDF (simulated).");
    }

    @FXML
    private void handlePrint() {
        showAlert("Sending report to printer (simulated).");
    }

    @FXML
    private void handleLogout() {
        showAlert("Logged out.");
        // Navigation logic can go here
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Report Generator");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
