package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ComplaintController {

    @FXML private TextField memberNameField;
    @FXML private ComboBox<String> complaintTypeBox;
    @FXML private TextArea complaintDetailsField;

    @FXML private TableView<Complaint> complaintTable;
    @FXML private TableColumn<Complaint, String> nameCol;
    @FXML private TableColumn<Complaint, String> typeCol;
    @FXML private TableColumn<Complaint, String> detailsCol;
    @FXML private TableColumn<Complaint, String> statusCol;

    private final ObservableList<Complaint> complaints = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getMemberName()));
        typeCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getType()));
        detailsCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDetails()));
        statusCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));

        complaintTable.setItems(complaints);
    }

    @FXML
    private void handleSubmit() {
        String name = memberNameField.getText();
        String type = complaintTypeBox.getValue();
        String details = complaintDetailsField.getText();

        if (name.isEmpty() || type == null || details.isEmpty()) {
            showAlert("All fields must be filled.");
            return;
        }

        complaints.add(new Complaint(name, type, details, "Submitted"));
        showAlert("Complaint submitted.");
        clearForm();
    }

    @FXML
    private void handleUpdateStatus() {
        Complaint selected = complaintTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Resolved");
            complaintTable.refresh();
            showAlert("Status updated to Resolved.");
        } else {
            showAlert("Select a complaint to update.");
        }
    }

    @FXML
    private void handleClear() {
        clearForm();
    }

    @FXML
    private void handleLogout() {
        showAlert("Logging out...");
    }

    private void clearForm() {
        memberNameField.clear();
        complaintTypeBox.setValue(null);
        complaintDetailsField.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Complaints");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
