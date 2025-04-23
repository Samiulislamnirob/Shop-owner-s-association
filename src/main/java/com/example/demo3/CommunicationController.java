package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CommunicationController {

    @FXML private ComboBox<String> recipientBox;
    @FXML private TextArea messageBox;

    @FXML private TableView<Message> messageTable;
    @FXML private TableColumn<Message, String> senderCol;
    @FXML private TableColumn<Message, String> recipientCol;
    @FXML private TableColumn<Message, String> contentCol;

    private final ObservableList<Message> messageList = FXCollections.observableArrayList();

    private final String currentUser = "Mansura Rahman"; // Logged-in user (can be dynamic)

    @FXML
    public void initialize() {
        recipientBox.setItems(FXCollections.observableArrayList("Samiul", "Taslima", "Admin"));

        senderCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getSender()));
        recipientCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getRecipient()));
        contentCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getContent()));

        messageTable.setItems(messageList);
    }

    @FXML
    private void handleSend() {
        String recipient = recipientBox.getValue();
        String content = messageBox.getText();

        if (recipient == null || content.isEmpty()) {
            showAlert("Please enter a message and select a recipient.");
            return;
        }

        messageList.add(new Message(currentUser, recipient, content));
        messageBox.clear();
        showAlert("Message sent.");
    }

    @FXML
    private void handleEdit() {
        Message selected = messageTable.getSelectionModel().getSelectedItem();
        if (selected != null && selected.getSender().equals(currentUser)) {
            selected.setContent(messageBox.getText());
            messageTable.refresh();
            showAlert("Message edited.");
        } else {
            showAlert("You can only edit your own messages.");
        }
    }

    @FXML
    private void handleDelete() {
        Message selected = messageTable.getSelectionModel().getSelectedItem();
        if (selected != null && selected.getSender().equals(currentUser)) {
            messageList.remove(selected);
            showAlert("Message deleted.");
        } else {
            showAlert("You can only delete your own messages.");
        }
    }

    @FXML
    private void handleClear() {
        messageBox.clear();
        recipientBox.setValue(null);
    }

    @FXML
    private void handleLogout() {
        showAlert("Logged out.");
        // Implement scene switch logic
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Communication");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
