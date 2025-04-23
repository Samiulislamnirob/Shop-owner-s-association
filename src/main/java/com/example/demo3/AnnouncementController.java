package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class AnnouncementController {

    @FXML private TextArea messageArea;
    @FXML private ComboBox<String> audienceBox;

    @FXML private TableView<Announcement> announcementTable;
    @FXML private TableColumn<Announcement, String> messageCol;
    @FXML private TableColumn<Announcement, String> audienceCol;
    @FXML private TableColumn<Announcement, String> dateCol;

    private final ObservableList<Announcement> announcements = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        messageCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getMessage()));
        audienceCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getAudience()));
        dateCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDate()));

        announcementTable.setItems(announcements);
    }

    @FXML
    private void handleSend() {
        String message = messageArea.getText();
        String audience = audienceBox.getValue();

        if (message.isEmpty() || audience == null) {
            showAlert("Please enter both message and audience.");
            return;
        }

        Announcement ann = new Announcement(message, audience, LocalDate.now().toString());
        announcements.add(ann);
        clearForm();
        showAlert("Announcement sent!");
    }

    @FXML
    private void handleEdit() {
        Announcement selected = announcementTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            messageArea.setText(selected.getMessage());
            audienceBox.setValue(selected.getAudience());
            announcements.remove(selected);
        } else {
            showAlert("Select an announcement to edit.");
        }
    }

    @FXML
    private void handleDelete() {
        Announcement selected = announcementTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            announcements.remove(selected);
            showAlert("Announcement deleted.");
        } else {
            showAlert("Select an announcement to delete.");
        }
    }

    @FXML
    private void handleLogout() {
        showAlert("Logging out...");
        // Add navigation logic here
    }

    private void clearForm() {
        messageArea.clear();
        audienceBox.setValue(null);
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Announcement");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

