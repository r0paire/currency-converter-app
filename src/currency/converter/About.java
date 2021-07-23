/*
 * File: About.java
 * Author: r0paire
 * Last Update: 23/07/2021
 * Description: about window of currency-converter-app
 */

package currency.converter;

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
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class About implements Initializable {

    @FXML
    Stage stage;

    @FXML
    Button homeBtn, aboutBtn, exitBtn, conversionBtn, currencyBtn, repoTextBtn;

    @FXML
    Label aboutLabel, aboutText, titleLabel, versionLabel, jdkLabel, jfxLabel, r0paireLabel, repoLabel;

    @FXML
    ImageView logoImage, githubLogo, javaLogo;

    @FXML
    FlowPane titleFlowPane;

    @FXML
    Pane logoPane;

    String repoUrl = "https://www.github.com/r0paire/currency-converter-app/";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Button for Home Window
        homeBtn.setOnAction(event -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
                    Parent root = loader.load();
                    Home hc = loader.<Home>getController();
                    hc.setData(stage);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ioe) {
                }
        });

        // Button for Currencies Window
        currencyBtn.setOnAction(event -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Currencies.fxml"));
                    Parent root = loader.load();
                    Currencies crc = loader.<Currencies>getController();
                    crc.setData(stage);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ioe) {
                }
        });

        // Button for Currencies Window
        conversionBtn.setOnAction(event -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Conversion.fxml"));
                    Parent root = loader.load();
                    Conversion cc = loader.<Conversion>getController();
                    cc.setData(stage);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ioe) {
                }
        });

        // Button to close application
        exitBtn.setOnAction(event -> {
                stage.close();
        });

        // Button to close application
        repoTextBtn.setOnAction(event -> {
                try {
                    Desktop.getDesktop().browse(new URL(repoUrl).toURI());
                }
                catch (Exception e) {
                    System.out.println("Error: repo url invalid");
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
