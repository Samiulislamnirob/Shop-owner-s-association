package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AttendanceController {

    @FXML private ComboBox<String> eventComboBox;
    @FXML private TableView<Attendance> attendanceTable;
    @FXML private TableColumn<Attendance, String> memberNameCol;
    @FXML private TableColumn<Attendance, String> statusCol;

    @FXML private ComboBox<String> statusBox;

    private final ObservableList<Attendance> attendanceList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        eventComboBox.setItems(FXCollections.observableArrayList("Monthly Meeting", "Security Briefing", "Maintenance Review"));
        statusBox.setItems(FXCollections.observableArrayList("Present", "Absent"));

        memberNameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getMemberName()));
        statusCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));

        // Sample members
        attendanceList.addAll(
                new Attendance("Ahmed Hossain", "Present"),
                new Attendance("Mansura Rahman", "Absent"),
                new Attendance("Taslima Akter", "Present")
        );

        attendanceTable.setItems(attendanceList);
    }

    @FXML
    private void handleUpdateStatus() {
        Attendance selected = attendanceTable.getSelectionModel().getSelectedItem();
        String newStatus = statusBox.getValue();
        if (selected != null && newStatus != null) {
            selected.setStatus(newStatus);
            attendanceTable.refresh();
            showAlert("Status updated.");
        } else {
            showAlert("Select a member and a status.");
        }
    }

    @FXML
    private void handleSave() {
        showAlert("Attendance record saved.");
    }

    @FXML
    private void handleEdit() {
        showAlert("You can now update member statuses.");
    }

    @FXML
    private void handleClear() {
        attendanceList.clear();
        showAlert("Attendance sheet cleared.");
    }

    @FXML
    private void handleLogout() {
        showAlert("Logged out.");
        // Add navigation code here
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Attendance");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
