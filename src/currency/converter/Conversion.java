/*
 * File: Conversion.java
 * Author: r0paire
 * Last Update: 23/07/2021
 * Description: conversion window of currency-converter-app
 */

package currency.converter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import com.google.gson.JsonElement;
import javax.net.ssl.HttpsURLConnection;

public class Conversion implements Initializable {

    @FXML
    Stage stage;

    @FXML
    Button homeBtn, aboutBtn, exitBtn, convertBtn, currencyBtn, conversionBtn;

    @FXML
    MenuButton fromCurrencyMenu, toCurrencyMenu;

    @FXML
    RadioButton left2RightRadioBtn, right2LeftRadioBtn;

    @FXML
    MenuItem audBtn1, bgnBtn1, brlBtn1, cadBtn1, chfBtn1, cnyBtn1, czkBtn1,
            dkkBtn1, egpBtn1, etbBtn1, eurBtn1, gbpBtn1, hkdBtn1, hrkBtn1, hufBtn1,
            ikrBtn1, inrBtn1, irrBtn1, jpyBtn1, krwBtn1, mxnBtn1, ngnBtn1, nokBtn1,
            pkrBtn1, plzBtn1, ronBtn1, rsdBtn1, rubBtn1, sarBtn1, sekBtn1, sgdBtn1,
            tryBtn1, usdBtn1, zarBtn1, audBtn2, bgnBtn2, brlBtn2, cadBtn2, chfBtn2,
            cnyBtn2, czkBtn2, dkkBtn2, egpBtn2, etbBtn2, eurBtn2, gbpBtn2, hkdBtn2,
            hrkBtn2, hufBtn2, ikrBtn2, inrBtn2, irrBtn2, jpyBtn2, krwBtn2, mxnBtn2,
            ngnBtn2, nokBtn2, pkrBtn2, plzBtn2, ronBtn2, rsdBtn2, rubBtn2, sarBtn2,
            sekBtn2, sgdBtn2, tryBtn2, usdBtn2, zarBtn2;

    @FXML
    Label titleLabel, conversionTextLabel, conversionLabel;

    @FXML
    TextField fromCurrencyText1, toCurrencyText2;

    @FXML
    ImageView logoImage;

    @FXML
    FlowPane titleFlowPane;

    @FXML
    Pane logoPane;

    String fromCurrency = "";
    String toCurrency = "";
    Double amount1;
    Double amount2;
    String urlStr1;
    String urlStr2;
    boolean twoDot;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // filter for fromCurrency input
        fromCurrencyText1.setOnAction(event -> {
                try
                {
                    amount1 = Double.parseDouble(fromCurrencyText1.getText());
                    // Valid double
                }
                catch (NullPointerException | NumberFormatException ex)
                {
                    Alert a = new Alert(Alert.AlertType.NONE);
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText("Please enter a valid value for amount.");
                    amount1 = 1.00;
                }
        });

        // filter for toCurrency input
        toCurrencyText2.setOnAction(event -> {
                try
                {
                    amount2 = Double.parseDouble(toCurrencyText2.getText());
                    // Valid double
                }
                catch (NullPointerException | NumberFormatException ex)
                {
                    Alert a = new Alert(Alert.AlertType.NONE);
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText("Please enter a valid value for amount.");
                    amount2 = 1.00;
                }
        });

        // Currency inputs - from
        left2RightRadioBtn.setOnAction(event -> {
                    fromCurrencyText1.setEditable(true);
                    toCurrencyText2.setEditable(false);
        });

        // Currency inputs - to
        right2LeftRadioBtn.setOnAction(event -> {
                fromCurrencyText1.setEditable(false);
                toCurrencyText2.setEditable(true);
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

        // Button for About Window
        aboutBtn.setOnAction(event -> {
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
        });

        // Button for Home window
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

        UnaryOperator<TextFormatter.Change> doubleFilter = change -> {
            String input = change.getText();

            if ((input.matches("[\\d\\.]+")) || change.isDeleted()) {
                return change;
            }
            return null;
        };

        fromCurrencyText1.setTextFormatter(new TextFormatter<String> (doubleFilter));
        toCurrencyText2.setTextFormatter(new TextFormatter<String> (doubleFilter));

        if(fromCurrencyText1.getText().indexOf('.', fromCurrencyText1.getText().indexOf('.') + 1) != -1) {
            twoDot = true;
        }
        else {
            twoDot = false;
        }

        if(toCurrencyText2.getText().indexOf('.', toCurrencyText2.getText().indexOf('.') + 1) != -1) {
            twoDot = true;
        }
        else {
            twoDot = false;
        }

        // Button for Currencies Window
        convertBtn.setOnAction(event -> {
                try {
                    if (left2RightRadioBtn.isSelected()){
                        String curr1Check = fromCurrencyText1.getText();
                        double zeroCheck1;
                        if(!curr1Check.isEmpty()) {
                            zeroCheck1 = Double.parseDouble(curr1Check);
                        }
                        else {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Input", ButtonType.OK);
                            alert.setTitle("Error");
                            alert.setHeaderText("Invalid input!");
                            alert.setContentText("Amount cannot be empty!");
                            alert.showAndWait();
                            return;
                        }
                        if(getDoubleDot(curr1Check) == true || curr1Check.equals(null)) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Input", ButtonType.OK);
                            alert.setTitle("Error");
                            alert.setHeaderText("Invalid Inputs");
                            alert.setContentText("Only doubles or floats can be used for inputs.");
                            alert.showAndWait();
                            return;
                        }
                        else if (zeroCheck1 < 0.01) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Input", ButtonType.OK);
                            alert.setTitle("Error");
                            alert.setHeaderText("Invalid unit used");
                            alert.setContentText("Amount cannot be less than a cent-like unit.");
                            alert.showAndWait();
                            return;
                        }
                        else {
                            toCurrencyText2.setText(" ");
                            urlStr1 = "";
                            conversion(fromCurrency, toCurrency);
                        }
                    }
                    else if (right2LeftRadioBtn.isSelected()) {
                        String curr2Check = toCurrencyText2.getText();
                        double zeroCheck2 = Double.parseDouble(curr2Check);
                        if(getDoubleDot(curr2Check) == true || curr2Check.equals("") || curr2Check.equals(null)) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Input", ButtonType.OK);
                            alert.setTitle("Error");
                            alert.setHeaderText("Invalid Inputs");
                            alert.setContentText("Only doubles or floats can be used for inputs.");
                            // show the dialog
                            alert.showAndWait();
                            return;
                        }
                        else if (zeroCheck2 < 0.01) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Input", ButtonType.OK);
                            alert.setTitle("Error");
                            alert.setHeaderText("Invalid unit used");
                            alert.setContentText("Amount cannot be less than a cent-like unit.");
                            // show the dialog
                            alert.showAndWait();
                            return;
                        }
                        else {
                            fromCurrencyText1.clear();
                            //urlStr2 = new String();
                            urlStr2 = "";
                            conversion(fromCurrency, toCurrency);
                        }
                    }
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
        });

        // Button to close application
        exitBtn.setOnAction(event -> {
                stage.close();
        });

        // Currencies - fromCurrency
        // Australian Dollar
        audBtn1.setOnAction(event -> {
            fromCurrency = "AUD";
            fromCurrencyMenu.setText(audBtn1.getText());
        });

        // Brazilian Real
        brlBtn1.setOnAction(event -> {
            fromCurrency = "BRL";
            fromCurrencyMenu.setText(brlBtn1.getText());

        });

        // Bulgarian lev
        bgnBtn1.setOnAction(event -> {
            fromCurrency = "BGN";
            fromCurrencyMenu.setText(bgnBtn1.getText());
        });

        // Canadian Dollar
        cadBtn1.setOnAction(event -> {
            fromCurrency = "CAD";
            fromCurrencyMenu.setText(cadBtn1.getText());
        });

        // Chinese Yuan Renimbi
        cnyBtn1.setOnAction(event -> {
            fromCurrency = "CNY";
            fromCurrencyMenu.setText(cnyBtn1.getText());
        });

        // Croatian Kuna
        hrkBtn1.setOnAction(event -> {
            fromCurrency = "HRK";
            fromCurrencyMenu.setText(hrkBtn1.getText());
        });

        // Czech Koruna
        czkBtn1.setOnAction(event -> {
            fromCurrency = "CZK";
            fromCurrencyMenu.setText(czkBtn1.getText());
        });

        // Danish Krone
        dkkBtn1.setOnAction(event -> {
            fromCurrency = "DKK";
            fromCurrencyMenu.setText(dkkBtn1.getText());
        });

        // Egyptian Pound
        egpBtn1.setOnAction(event -> {
            fromCurrency = "EGP";
            fromCurrencyMenu.setText(egpBtn1.getText());
        });

        // Ethiopian Birr
        etbBtn1.setOnAction(event -> {
            fromCurrency = "ETB";
            fromCurrencyMenu.setText(etbBtn1.getText());
        });

        // Euro
        eurBtn1.setOnAction(event -> {
            fromCurrency = "EUR";
            fromCurrencyMenu.setText(eurBtn1.getText());

        });

        // Hong Kong Dollar
        hkdBtn1.setOnAction(event -> {
            fromCurrency = "HKD";
            fromCurrencyMenu.setText(hkdBtn1.getText());
        });

        // Hungarian Forint
        hufBtn1.setOnAction(event -> {
            fromCurrency = "HUF";
            fromCurrencyMenu.setText(hufBtn1.getText());
        });

        // Icelandic Króna
        ikrBtn1.setOnAction(event -> {
            fromCurrency = "IKR";
            fromCurrencyMenu.setText(ikrBtn1.getText());
        });

        // Indian Rupee
        inrBtn1.setOnAction(event -> {
            fromCurrency = "INR";
            fromCurrencyMenu.setText(inrBtn1.getText());
        });

        // Iranian Rial
        irrBtn1.setOnAction(event -> {
            fromCurrency = "IRR";
            fromCurrencyMenu.setText(irrBtn1.getText());
        });

        // Japanese Yen
        jpyBtn1.setOnAction(event -> {
            fromCurrency = "JPY";
            fromCurrencyMenu.setText(jpyBtn1.getText());
        });

        // Mexican Peso
        mxnBtn1.setOnAction(event -> {
            fromCurrency = "MXN";
            fromCurrencyMenu.setText(mxnBtn1.getText());
        });

        // Nigerian Naira
        ngnBtn1.setOnAction(event -> {
            fromCurrency = "NGN";
            fromCurrencyMenu.setText(ngnBtn1.getText());
        });

        // Norwegian Krone
        nokBtn1.setOnAction(event -> {
            fromCurrency = "NOK";
            fromCurrencyMenu.setText(nokBtn1.getText());
        });

        // Pakistani Rupee
        pkrBtn1.setOnAction(event -> {
            fromCurrency = "PKR";
            fromCurrencyMenu.setText(pkrBtn1.getText());
        });

        // Polish Złoty
        plzBtn1.setOnAction(event -> {
            fromCurrency = "PLZ";
            fromCurrencyMenu.setText(plzBtn1.getText());
        });

        // British Pound Sterling
        gbpBtn1.setOnAction(event -> {
            fromCurrency = "GBP";
            fromCurrencyMenu.setText(gbpBtn1.getText());
        });

        // Romanian Leu
        ronBtn1.setOnAction(event -> {
            fromCurrency = "RON";
            fromCurrencyMenu.setText(ronBtn1.getText());
        });

        // Russian Ruble
        rubBtn1.setOnAction(event -> {
            fromCurrency = "RUB";
            fromCurrencyMenu.setText(rubBtn1.getText());
        });

        // Saudi Riyal
        sarBtn1.setOnAction(event -> {
            fromCurrency = "SAR";
            fromCurrencyMenu.setText(sarBtn1.getText());
        });

        // Serbian Dinar
        rsdBtn1.setOnAction(event -> {
            fromCurrency = "RSD";
            fromCurrencyMenu.setText(rsdBtn1.getText());
        });

        // Singaporean Dollar
        sgdBtn1.setOnAction(event -> {
            fromCurrency = "SGD";
            fromCurrencyMenu.setText(sgdBtn1.getText());
        });

        // South African Rand
        zarBtn1.setOnAction(event -> {
            fromCurrency = "ZAR";
            fromCurrencyMenu.setText(zarBtn1.getText());
        });

        // South Korean Won
        krwBtn1.setOnAction(event -> {
            fromCurrency = "KRW";
            fromCurrencyMenu.setText(krwBtn1.getText());
        });

        // Swedish Krona
        sekBtn1.setOnAction(event -> {
            fromCurrency = "SEK";
            fromCurrencyMenu.setText(sekBtn1.getText());
        });

        // Swiss Franc
        chfBtn1.setOnAction(event -> {
            fromCurrency = "CHF";
            fromCurrencyMenu.setText(chfBtn1.getText());
        });

        // Turkish Lira
        tryBtn1.setOnAction(event -> {
            fromCurrency = "TRY";
            fromCurrencyMenu.setText(tryBtn1.getText());
        });

        // US Dollars
        usdBtn1.setOnAction(event -> {
            fromCurrency = "USD";
            fromCurrencyMenu.setText(usdBtn1.getText());
        });

        // Currencies - toCurrency
        // Australian Dollar
        audBtn2.setOnAction(event -> {
            toCurrency = "AUD";
            toCurrencyMenu.setText(audBtn2.getText());
        });

        // Brazilian Real
        brlBtn2.setOnAction(event -> {
            toCurrency = "BRL";
            toCurrencyMenu.setText(brlBtn2.getText());
        });

        // Bulgarian lev
        bgnBtn2.setOnAction(event -> {
            toCurrency = "BGN";
            toCurrencyMenu.setText(bgnBtn2.getText());
        });

        // Canadian Dollar
        cadBtn2.setOnAction(event -> {
            toCurrency = "CAD";
            toCurrencyMenu.setText(cadBtn2.getText());
        });

        // Chinese Yuan Renimbi
        cnyBtn2.setOnAction(event -> {
            toCurrency = "CNY";
            toCurrencyMenu.setText(cnyBtn2.getText());
        });

        // Croatian Kuna
        hrkBtn2.setOnAction(event -> {
            toCurrency = "HRK";
            toCurrencyMenu.setText(hrkBtn2.getText());
        });

        // Czech Koruna
        czkBtn2.setOnAction(event -> {
            toCurrency = "CZK";
            toCurrencyMenu.setText(czkBtn2.getText());
        });

        // Danish Krone
        dkkBtn2.setOnAction(event -> {
            toCurrency = "DKK";
            toCurrencyMenu.setText(dkkBtn2.getText());
        });

        // Egyptian Pound
        egpBtn2.setOnAction(event -> {
            toCurrency = "EGP";
            toCurrencyMenu.setText(egpBtn2.getText());
        });

        // Ethiopian Birr
        etbBtn2.setOnAction(event -> {
            toCurrency = "ETB";
            toCurrencyMenu.setText(etbBtn2.getText());
        });

        // Euro
        eurBtn2.setOnAction(event -> {
            toCurrency = "EUR";
            toCurrencyMenu.setText(eurBtn2.getText());
        });

        // Hong Kong Dollar
        hkdBtn2.setOnAction(event -> {
            toCurrency = "HKD";
            toCurrencyMenu.setText(hkdBtn2.getText());
        });

        // Hungarian Forint
        hufBtn2.setOnAction(event -> {
            toCurrency = "HUF";
            toCurrencyMenu.setText(hufBtn2.getText());
        });

        // Icelandic Króna
        ikrBtn2.setOnAction(event -> {
            toCurrency = "IKR";
            toCurrencyMenu.setText(ikrBtn2.getText());
        });

        // Indian Rupee
        inrBtn2.setOnAction(event -> {
            toCurrency = "INR";
            toCurrencyMenu.setText(inrBtn2.getText());
        });

        // Iranian Rial
        irrBtn2.setOnAction(event -> {
            toCurrency = "IRR";
            toCurrencyMenu.setText(irrBtn2.getText());
        });

        // Japanese Yen
        jpyBtn2.setOnAction(event -> {
            toCurrency = "JPY";
            toCurrencyMenu.setText(jpyBtn2.getText());
        });

        // Mexican Peso
        mxnBtn2.setOnAction(event -> {
            toCurrency = "MXN";
            toCurrencyMenu.setText(mxnBtn2.getText());
        });

        // Nigerian Naira
        ngnBtn2.setOnAction(event -> {
            toCurrency = "NGN";
            toCurrencyMenu.setText(ngnBtn2.getText());
        });

        // Norweigan Krone
        nokBtn2.setOnAction(event -> {
            toCurrency = "NOK";
            toCurrencyMenu.setText(nokBtn2.getText());
        });

        // Pakistani Rupee
        pkrBtn2.setOnAction(event -> {
            toCurrency = "PKR";
            toCurrencyMenu.setText(pkrBtn2.getText());
        });

        // Polish Złoty
        plzBtn2.setOnAction(event -> {
            toCurrency = "PLZ";
            toCurrencyMenu.setText(plzBtn2.getText());
        });

        // British Pound Sterling
        gbpBtn2.setOnAction(event -> {
            toCurrency = "GBP";
            toCurrencyMenu.setText(gbpBtn2.getText());
        });

        // Romanian Leu
        ronBtn2.setOnAction(event -> {
            toCurrency = "RON";
            toCurrencyMenu.setText(ronBtn2.getText());
        });

        // Russian Ruble
        rubBtn2.setOnAction(event -> {
            toCurrency = "RUB";
            toCurrencyMenu.setText(rubBtn2.getText());
        });

        // Saudi Riyal
        sarBtn2.setOnAction(event -> {
            toCurrency = "SAR";
            toCurrencyMenu.setText(sarBtn2.getText());
        });

        // Serbian Dinar
        rsdBtn2.setOnAction(event -> {
            toCurrency = "RSD";
            toCurrencyMenu.setText(rsdBtn2.getText());
        });

        // Singaporean Dollar
        sgdBtn2.setOnAction(event -> {
            toCurrency = "SGD";
            toCurrencyMenu.setText(sgdBtn2.getText());
        });

        // South African Rand
        zarBtn2.setOnAction(event -> {
            toCurrency = "ZAR";
            toCurrencyMenu.setText(zarBtn2.getText());
        });

        // South Korean Won
        krwBtn2.setOnAction(event -> {
            toCurrency = "KRW";
            toCurrencyMenu.setText(krwBtn2.getText());
        });

        // Swedish Krona
        sekBtn2.setOnAction(event -> {
            toCurrency = "SEK";
            toCurrencyMenu.setText(sekBtn2.getText());
        });

        // Swiss Franc
        chfBtn2.setOnAction(event -> {
            toCurrency = "CHF";
            toCurrencyMenu.setText(chfBtn2.getText());
        });

        // Turkish Lira
        tryBtn2.setOnAction(event -> {
            toCurrency = "TRY";
            toCurrencyMenu.setText(tryBtn2.getText());
        });

        // US Dollars
        usdBtn2.setOnAction(event -> {
            toCurrency = "USD";
            toCurrencyMenu.setText(usdBtn2.getText());
        });

    }

    public void conversion(String fromCurrency, String toCurrency) throws IOException, ParseException {
        // API-key (get a free one at exchangerate-api.com to use their API)
        String apiKey = "15778a570d407694b419736a";

        // Setting URL
        if (left2RightRadioBtn.isSelected()) {
            String amount1 = new String();
            amount1 = fromCurrencyText1.getText();

            urlStr1 = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + fromCurrency + "/" + toCurrency +
                    "/" + amount1;

            // Making Request
            URL url = new URL(urlStr1);
            HttpsURLConnection request = (HttpsURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonObj = root.getAsJsonObject();

            // Accessing object
            String req_result = jsonObj.get("conversion_result").getAsString();
            toCurrencyText2.setText(req_result);
        }
        else if (right2LeftRadioBtn.isSelected()) {
            fromCurrencyText1.clear();
            urlStr2 = "";
            String amount2;
            amount2 = toCurrencyText2.getText();

            urlStr2 = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + toCurrency + "/" + fromCurrency +"/"
                        + amount2;

            // Making Request
            URL url = new URL(urlStr2);
            HttpsURLConnection request = (HttpsURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonObj = root.getAsJsonObject();

            // Accessing object
            String req_result = jsonObj.get("conversion_result").getAsString();
            fromCurrencyText1.setText(req_result);
        }
        else if (fromCurrency.equals(toCurrency)){
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Currencies convert the same currency!");
        }
        else {
            System.err.println("issue with conversion API");
        }
    }

    public boolean getDoubleDot(String string) {
        if (string.indexOf('.', string.indexOf('.') + 1) != -1){
            return true;
        }
        else {
            return false;
        }
    }

    @FXML
    // sets necessary data for Appointment Controller
    //called when loading AppointmentScreen.fxml
    public void setData ( Stage stage) {
        this.stage = stage;
    }
}

