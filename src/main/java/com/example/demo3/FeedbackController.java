package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FeedbackController {

    @FXML private TextField shopNameField;
    @FXML private TextArea feedbackArea;
    @FXML private ComboBox<Integer> ratingBox;
    @FXML private ComboBox<String> filterBox;

    @FXML private TableView<Feedback> feedbackTable;
    @FXML private TableColumn<Feedback, String> nameCol;
    @FXML private TableColumn<Feedback, String> feedbackCol;
    @FXML private TableColumn<Feedback, Number> ratingCol;
    @FXML private TableColumn<Feedback, String> reviewedCol;

    private final ObservableList<Feedback> feedbackList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        ratingBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
        filterBox.setItems(FXCollections.observableArrayList("All", "1", "2", "3", "4", "5"));
        filterBox.setValue("All");

        nameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getShopName()));
        feedbackCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getFeedback()));
        ratingCol.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getRating()));
        reviewedCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().isReviewed() ? "Yes" : "No"));

        feedbackTable.setItems(feedbackList);
    }

    @FXML
    private void handleSubmit() {
        String name = shopNameField.getText();
        String feedbackText = feedbackArea.getText();
        Integer rating = ratingBox.getValue();

        if (name.isEmpty() || feedbackText.isEmpty() || rating == null) {
            showAlert("Please fill in all fields.");
            return;
        }

        feedbackList.add(new Feedback(name, feedbackText, rating));
        clearForm();
        showAlert("Feedback submitted.");
    }

    @FXML
    private void handleClear() {
        clearForm();
    }

    @FXML
    private void handleMarkReviewed() {
        Feedback selected = feedbackTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setReviewed(true);
            feedbackTable.refresh();
            showAlert("Marked as reviewed.");
        } else {
            showAlert("Please select a feedback entry.");
        }
    }

    private void clearForm() {
        shopNameField.clear();
        feedbackArea.clear();
        ratingBox.setValue(null);
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Feedback");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
