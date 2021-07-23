/*
 * File: Home.java
 * Author: r0paire
 * Last Update: 23/07/2021
 * Description: home/landing window of currency-converter-app
 */

package currency.converter;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    Stage stage;

    @FXML
    Button homeBtn, aboutBtn, exitBtn, conversionBtn, currencyBtn;

    @FXML
    Label welcomeLabel, titleLabel, welcomeTextLabel;

    @FXML
    ImageView logoImage, javaLogo;

    @FXML
    FlowPane titleFlowPane;

    @FXML
    Pane logoPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Button for About Window
        aboutBtn.setOnAction(new EventHandler() {
            public void handle(Event event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("About.fxml"));
                    Parent root = loader.load();
                    About ac = loader.<About>getController();
                    ac.setData(stage);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ioe) {
                }
            }
        });

        // Button for Conversion Window
        conversionBtn.setOnAction(new EventHandler() {
            public void handle(Event event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Conversion.fxml"));
                    Parent root = loader.load();
                    Conversion cc = loader.<Conversion>getController();
                    cc.setData(stage);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        });

        // Button for Currencies Window
        currencyBtn.setOnAction(new EventHandler() {
            public void handle(Event event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Currencies.fxml"));
                    Parent root = loader.load();
                    Currencies crc = loader.<Currencies>getController();
                    crc.setData(stage);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                catch (IOException ioe) {
                }
            }
        });

        // Button to close application
        exitBtn.setOnAction(new EventHandler() {
            public void handle(Event event) {
                stage.close();
            }
        });

    }

    @FXML
    // sets necessary data for Appointment Controller
    //called when loading AppointmentScreen.fxml
    public void setData ( Stage stage) {
        this.stage = stage;
    }
}
