package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.event.ActionEvent;

public class MemberDashboardController {

    @FXML
    private void goToGoal1(ActionEvent event) { loadScene("owner_profiles.fxml"); }

    @FXML
    private void goToGoal2(ActionEvent event) { loadScene("member_complaints.fxml"); }

    @FXML
    private void goToGoal3(ActionEvent event) { loadScene("announcements.fxml"); }

    @FXML
    private void goToGoal4(ActionEvent event) { loadScene("member_feedback.fxml"); }

    @FXML
    private void goToGoal5(ActionEvent event) { loadScene("attendance_tracker.fxml"); }

    @FXML
    private void goToGoal6(ActionEvent event) { loadScene("program_registration.fxml"); }

    @FXML
    private void goToGoal7(ActionEvent event) { loadScene("internal_communication.fxml"); }

    @FXML
    private void goToGoal8(ActionEvent event) { loadScene("member_reports.fxml"); }

    @FXML
    private void handleLogout(ActionEvent event) {
        System.out.println("Logged out.");
        // You can return to login screen here
    }

    private void loadScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Member Manager Task");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

