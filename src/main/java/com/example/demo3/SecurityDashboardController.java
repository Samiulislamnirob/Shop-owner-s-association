package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class SecurityDashboardController {

    @FXML
    private void goToGoal1(ActionEvent event) { loadScene("log_maintenance.fxml"); }

    @FXML
    private void goToGoal2(ActionEvent event) { loadScene("update_maintenance_status.fxml"); }

    @FXML
    private void goToGoal3(ActionEvent event) { loadScene("security_incident.fxml"); }

    @FXML
    private void goToGoal4(ActionEvent event) { loadScene("schedule_cleaning.fxml"); }

    @FXML
    private void goToGoal5(ActionEvent event) { loadScene("maintenance_report.fxml"); }

    @FXML
    private void goToGoal6(ActionEvent event) { loadScene("vendor_performance.fxml"); }

    @FXML
    private void goToGoal7(ActionEvent event) { loadScene("emergency_alert.fxml"); }

    @FXML
    private void goToGoal8(ActionEvent event) { loadScene("cctv_monitor.fxml"); }

    @FXML
    private void handleLogout(ActionEvent event) {
        System.out.println("Logged out.");
        // You can navigate back to login screen here
    }

    private void loadScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Security Task");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

