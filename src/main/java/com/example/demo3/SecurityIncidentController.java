package com.example.demo3;

public class SecurityIncidentController {
}package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SecurityIncidentController {

    @FXML private TextField incidentTypeField;
    @FXML private TextField locationField;
    @FXML private TextField timeField;
    @FXML private TextArea descriptionField;

    @FXML private TableView<SecurityIncident> incidentTable;
    @FXML private TableColumn<SecurityIncident, String> typeColumn;
    @FXML private TableColumn<SecurityIncident, String> locationColumn;
    @FXML private TableColumn<SecurityIncident, String> timeColumn;
    @FXML private TableColumn<SecurityIncident, String> descriptionColumn;

    private final ObservableList<SecurityIncident> incidentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Link table columns to model properties
        typeColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getIncidentType()));
        locationColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getLocation()));
        timeColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTime()));
        descriptionColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescription()));

        // Attach data to table
        incidentTable.setItems(incidentList);
    }

    @FXML
    private void handleSubmit() {
        String type = incidentTypeField.getText();
        String location = locationField.getText();
        String time = timeField.getText();
        String description = descriptionField.getText();

        if (type.isEmpty() || location.isEmpty() || time.isEmpty()) {
            showAlert("Please fill in all required fields.");
            return;
        }

        SecurityIncident incident = new SecurityIncident(type, location, time, description);
        incidentList.add(incident);
        clearFields();
        showAlert("Incident submitted successfully.");
    }

    @FXML
    private void handleClear() {
        clearFields();
    }

    @FXML
    private void handleDelete() {
        SecurityIncident selected = incidentTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            incidentList.remove(selected);
            showAlert("Selected incident deleted.");
        } else {
            showAlert("Please select an incident to delete.");
        }
    }

    @FXML
    private void handleLogout() {
        showAlert("Logged out (demo action).");
        // TODO: Switch to login/dashboard scene if needed
    }

    private void clearFields() {
        incidentTypeField.clear();
        locationField.clear();
        timeField.clear();
        descriptionField.clear();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Security Incident Log");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

