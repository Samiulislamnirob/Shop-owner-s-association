package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistrationController {

    @FXML private TextField memberIdField;
    @FXML private TextField memberNameField;
    @FXML private ComboBox<String> programBox;

    @FXML private TableView<Registration> registrationTable;
    @FXML private TableColumn<Registration, String> memberIdCol;
    @FXML private TableColumn<Registration, String> memberNameCol;
    @FXML private TableColumn<Registration, String> programCol;

    private final ObservableList<Registration> registrations = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        programBox.setItems(FXCollections.observableArrayList("Leadership Workshop", "Community Clean-up", "Marketing Bootcamp"));

        memberIdCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getMemberId()));
        memberNameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getMemberName()));
        programCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getProgram()));

        registrationTable.setItems(registrations);
    }

    @FXML
    private void handleConfirm() {
        String id = memberIdField.getText();
        String name = memberNameField.getText();
        String program = programBox.getValue();

        if (id.isEmpty() || name.isEmpty() || program == null) {
            showAlert("Please fill all fields.");
            return;
        }

        registrations.add(new Registration(id, name, program));
        clearForm();
        showAlert("Member registered successfully.");
    }

    @FXML
    private void handleUpdate() {
        Registration selected = registrationTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setMemberName(memberNameField.getText());
            selected.setProgram(programBox.getValue());
            registrationTable.refresh();
            showAlert("Registration updated.");
        } else {
            showAlert("Select a registration to update.");
        }
    }

    @FXML
    private void handleRemove() {
        Registration selected = registrationTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            registrations.remove(selected);
            showAlert("Registration removed.");
        } else {
            showAlert("Please select a member to remove.");
        }
    }

    @FXML
    private void handleClear() {
        clearForm();
    }

    @FXML
    private void handleLogout() {
        showAlert("Logged out.");
        // Add navigation code
    }

    private void clearForm() {
        memberIdField.clear();
        memberNameField.clear();
        programBox.setValue(null);
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Program Registration");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
