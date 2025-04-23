package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class ScheduleController {

    @FXML private TextField taskField;
    @FXML private TextField areaField;
    @FXML private DatePicker datePicker;
    @FXML private TextField timeField;
    @FXML private TextField staffField;

    @FXML private TableView<ScheduledTask> scheduleTable;
    @FXML private TableColumn<ScheduledTask, String> taskColumn;
    @FXML private TableColumn<ScheduledTask, String> areaColumn;
    @FXML private TableColumn<ScheduledTask, String> dateColumn;
    @FXML private TableColumn<ScheduledTask, String> timeColumn;
    @FXML private TableColumn<ScheduledTask, String> staffColumn;

    private final ObservableList<ScheduledTask> taskList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        taskColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTask()));
        areaColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getArea()));
        dateColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDate()));
        timeColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTime()));
        staffColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStaff()));

        scheduleTable.setItems(taskList);
    }

    @FXML
    private void handleSubmit() {
        String task = taskField.getText();
        String area = areaField.getText();
        LocalDate date = datePicker.getValue();
        String time = timeField.getText();
        String staff = staffField.getText();

        if (task.isEmpty() || area.isEmpty() || date == null || time.isEmpty() || staff.isEmpty()) {
            showAlert("All fields are required.");
            return;
        }

        ScheduledTask newTask = new ScheduledTask(task, area, date.toString(), time, staff);
        taskList.add(newTask);
        clearFields();
        showAlert("Task scheduled successfully.");
    }

    @FXML
    private void handleClear() {
        clearFields();
    }

    @FXML
    private void handleLogout() {
        showAlert("Logging out (demo message).");
        // TODO: Scene switch to login/dashboard
    }

    private void clearFields() {
        taskField.clear();
        areaField.clear();
        datePicker.setValue(null);
        timeField.clear();
        staffField.clear();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Schedule Manager");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}



