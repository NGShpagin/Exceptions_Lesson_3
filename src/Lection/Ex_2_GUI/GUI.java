package Lection.Ex_2_GUI;

import java.awt.*;
import java.io.IOException;

//public class GUI extends Application {

//    public void start(Stage primaryStage) throws Exception {
//        Button button = new Button("Save");
//        button.setOnAction((event) -> {
//            SaveService saveService = new SaveService();
//            try {
//                saveService.save();
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Saved successfully", ButtonType.OK);
//                alert.getDialogPane().setStyle("-fx-font-family: 'serif'");
//                alert.showAndWait();
//            } catch (SavedException e) {
//                Alert alert = new Alert(Alert.AlertType.ERROR, "Saved failed at "+e.getStartDate(), ButtonType.OK);
//                alert.getDialogPane().setStyle("-fx-font-family: 'serif'");
//                alert.showAndWait();
//                e.printStackTrace();
//            }
//        });

//        prepareStage(button, primaryStage);
//        primaryStage.show();
//    }
//}
