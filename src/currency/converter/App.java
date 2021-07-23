/*
 * File: App.java
 * Author: r0paire
 * Last Update: 23/07/2021
 * Description: Application loader for currency-converter-app.
 */

package currency.converter;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{
    public void start (Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));

        Parent root = loader.load();
        Home hc = loader.<Home>getController();
        hc.setData(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Currency Converter");
        stage.getIcons().add(new Image(App.class.getResourceAsStream("images/exchange.png"))); // needs changed
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void main (String[]args) {
        launch(args);
    }
}
