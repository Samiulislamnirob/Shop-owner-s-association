package com.example.demo3;

import javafx.fxml.FXML;

public class StatusUpdateController {
}package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StatusUpdateController {

    @FXML private TextField requestIdField;
    @FXML private ComboBox<String> statusComboBox;
    @FXML private TextArea commentField;

    @FXML private TableView<StatusUpdate> statusTable;
    @FXML private TableColumn<StatusUpdate, String> idColumn;
    @FXML private TableColumn<StatusUpdate, String> statusColumn;
    @FXML private TableColumn<StatusUpdate, String> commentColumn;

    private final ObservableList<StatusUpdate> updateList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Set up the table columns
        idColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getRequestId()));
        statusColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));
        commentColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getComment()));

        // Set the items to the table
        statusTable.setItems(updateList);

        // Optional: Add items to statusComboBox
        statusComboBox.setItems(FXCollections.observableArrayList("Pending", "In Progress", "Completed"));
    }

    @FXML
    private void handleSearch() {
        String id = requestIdField.getText();
        if (id.isEmpty()) {
            showAlert("Please enter a Request ID to search.");
            return;
        }

        // For demo: pretend to find it (real app would search database)
        showAlert("Request ID " + id + " found (demo only).");
    }

    @FXML
    private void handleSave() {
        String id = requestIdField.getText();
        String status = statusComboBox.getValue();
        String comment = commentField.getText();

        if (id.isEmpty() || status == null) {
            showAlert("Please fill in Request ID and Status.");
            return;
        }

        StatusUpdate update = new StatusUpdate(id, status, comment);
        updateList.add(update);

        clearFields();
        showAlert("Status updated successfully!");
    }

    @FXML
    private void handleClear() {
        clearFields();
    }

    @FXML
    private void handleLogout() {
        showAlert("Logged out (not really – just a message here).");
        // TODO: redirect to another scene if needed
    }

    private void clearFields() {
        requestIdField.clear();
        statusComboBox.setValue(null);
        commentField.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Status Update");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

