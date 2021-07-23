/*
 * File: Currencies.java
 * Author: r0paire
 * Last Update: 23/07/2021
 * Description: currencies window of currency-converter-app
 */

package currency.converter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Currencies implements Initializable {

    @FXML
    Stage stage;

    @FXML
    Button homeBtn, aboutBtn, exitBtn, conversionBtn, currencyBtn, convertBtn;

    @FXML
    MenuButton currenciesMenu;

    @FXML
    MenuItem audBtn, bgnBtn, brlBtn, cadBtn, chfBtn, cnyBtn, czkBtn,
            dkkBtn, egpBtn, etbBtn, eurBtn, gbpBtn, hkdBtn, hrkBtn,
            hufBtn, ikrBtn, inrBtn, irrBtn, jpyBtn, krwBtn, mxnBtn,
            ngnBtn, nokBtn, pkrBtn, plzBtn, ronBtn, rsdBtn, rubBtn,
            sarBtn, sekBtn, sgdBtn, tryBtn, usdBtn, zarBtn;

    @FXML
    TextArea currencyDetailsText;

    @FXML
    Label titleLabel, currenciesTitleLabel, currenciesTextLabel ;

    @FXML
    ImageView logoImage, currencyFlag;

    @FXML
    FlowPane titleFlowPane;

    @FXML
    Pane logoPane;

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

        // Button for Conversion Window
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

        // Currencies
        // Australian Dollar
        audBtn.setOnAction(event -> {
            currencyDetailsText.setText("Australian Dollars \n \n The Australian Dollar is the currency used in" +
                    " Australia and it's island territories and also used in the countries of Kiribati, Nauru and" +
                    " Tuvalu. Some unofficial users of the Australian Dollar are Cambodia, New Caledonia " +
                    "(French territory), Papua New Guinea, the Solomon Islands, The Gambia, Tonga, Vanuatu and " +
                    "Zimbabwe");
            Image image = new Image(getClass().getResourceAsStream("images/australia.png"));
            currencyFlag.setImage(image);
        });

        // Brazilian Real
        brlBtn.setOnAction(event -> {
            currencyDetailsText.setText("Brazilian Real \n \n The Brazilian Real is the currency used in Brazil");
            Image image = new Image(getClass().getResourceAsStream("images/brazil.png"));
            currencyFlag.setImage(image);
        });

        // Bulgarian lev
        bgnBtn.setOnAction(event -> {
            currencyDetailsText.setText("Bulgarian Lev \n \n The Bulgarian Lev is the currency used in Bulgaria and" +
                    "is fixed against the Euro.");
            Image image = new Image(getClass().getResourceAsStream("images/bulgaria.png"));
            currencyFlag.setImage(image);
        });

        // Canadian Dollar
        cadBtn.setOnAction(event -> {
            currencyDetailsText.setText("Canadian Dollar \n \n The Canadian Dollar is the currency used in Canada and"+
                    " unofficially by the French territory of Saint Pierre and Miquelon. Canadian Dollars and US " +
                    "Dollars are sometimes used on opposite sides of the border states between the two nations.");
            Image image = new Image(getClass().getResourceAsStream("images/canada.png"));
            currencyFlag.setImage(image);
        });

        // Chinese Yuan Renimbi
        cnyBtn.setOnAction(event -> {
            currencyDetailsText.setText("Chinese Yuan Renimbi \n \n The Chinese Yuan Renimbi is the currency used in" +
                    " the mainland People's Republic of China and also unofficially in Angola, Bangladesh, Laos," +
                    " Bhutan, The Gambia, North Korea, Macao S.A.R, Myanmar/Burma, Nepal, Nigeria, Sierra Leone, " +
                    "Venezuela and Zimbabwe. \n \n The Chinese currency is the Renimbi, however the basic unit used " +
                    "is the Yuan (like the Euro in the Euro currency).");
            Image image = new Image(getClass().getResourceAsStream("images/china.png"));
            currencyFlag.setImage(image);
        });

        // Croatian Kuna
        hrkBtn.setOnAction(event -> {
            currencyDetailsText.setText("Croatian Kuna \n \n The Croatian Kuna, or Hrvatska Kuna in Croatian, is the " +
                    "currency used in Croatia.");
            Image image = new Image(getClass().getResourceAsStream("images/croatia.png"));
            currencyFlag.setImage(image);
        });

        // Czech Koruna
        czkBtn.setOnAction(event -> {
            currencyDetailsText.setText("Czech Koruna \n \n The Czech Koruna, or Koruna Česká in Czech, is the" +
                    " currency used in the Czech Republic/Czechia.");
            Image image = new Image(getClass().getResourceAsStream("images/czechia.png"));
            currencyFlag.setImage(image);
        });

        // Danish Krone
        dkkBtn.setOnAction(event -> {
            currencyDetailsText.setText("Danish Krone \n \n The Danish Krone, or Dansk Krone  in Danish, is the" +
                    " currency used in the Denmark and the Danish territories of Greenland and the Faore Islands. The"+
                    " Danish Krone follows a similar naming pattern as the other nordic countries using 'crowns' in" +
                    " their natve languages.");
            Image image = new Image(getClass().getResourceAsStream("images/denmark.png"));
            currencyFlag.setImage(image);
        });

        // Egyptian Pound
        egpBtn.setOnAction(event -> {
            currencyDetailsText.setText("Egyptian Pounds \n \n The Egyptain Pound, is the currency used in Egypt and "+
                    " in the Gaza Strip region of Palestine.");
            Image image = new Image(getClass().getResourceAsStream("images/egypt.png"));
            currencyFlag.setImage(image);
        });

        // Ethiopian Birr
        etbBtn.setOnAction(event -> {
            currencyDetailsText.setText("Ethiopian Birr \n \n The Ethiopian Birr is the currency used in Ethiopia.");
            Image image = new Image(getClass().getResourceAsStream("images/ethiopia.png"));
            currencyFlag.setImage(image);
        });

        // Euro
        eurBtn.setOnAction(event -> {
            currencyDetailsText.setText("The Euro \n \n The Euro is the currency used in the European Union's " +
                    "'Eurozone' which is comprised of Austria, Belgium, Cyprus, Estonia, Finland, France, Germany, " +
                    "Greece, Ireland, Italy, Latvia, Lithuania, Luxembourg, Malta, Netherlands, Slovakia, Slovenia, " +
                    "Spain and Portugal. Alongside the Eurozone, some states such as Andorra, Monaco, San Marino and" +
                    "Some non-EU states such as Montenegro and the unrecognized Kosovo also use the Euro (partially " +
                    "for Kosovo).\n \n Some states, seeking an alternative to the US Dollar have partially accepted" +
                    " the Euro for trading such as North Korea, Sierra Leone, Venezuela and Zimbabwe");
            Image image = new Image(getClass().getResourceAsStream("images/eu.png"));
            currencyFlag.setImage(image);
        });

        // Hong Kong Dollar
        hkdBtn.setOnAction(event -> {
            currencyDetailsText.setText("Hong Kong Dollars \n \n Hong Kong Dollars are the currency used in the " +
                    "Chinese Special Administrative Region (S.A.R) of Hong Kong and are used exclusive in Hong Kong" +
                    " and unofficially by some in the neighbouring Macao S.A.R.");
            Image image = new Image(getClass().getResourceAsStream("images/hongKong.png"));
            currencyFlag.setImage(image);
        });

        // Hungarian Forint
        hufBtn.setOnAction(event -> {
            currencyDetailsText.setText("Hungarian Forint \n \n Hungarian Forint is the currency used in Hungary.");
            Image image = new Image(getClass().getResourceAsStream("images/hungary.png"));
            currencyFlag.setImage(image);
        });

        // Icelandic Króna
        ikrBtn.setOnAction(event -> {
            currencyDetailsText.setText("Icelandic Króna \n \n Icelandic Króna is the currency used in Iceland. \n " +
                    "Like with other nordic nations, the Króna means 'crown' in Icelandic and follows the trend of" +
                    " using 'crowns' as units of currency.");
            Image image = new Image(getClass().getResourceAsStream("images/iceland.png"));
            currencyFlag.setImage(image);
        });

        // Indian Rupee
        inrBtn.setOnAction(event -> {
            currencyDetailsText.setText("Indian Rupee \n \n The Indian Rupee is the currency used in India, and is " +
                    "also considered legal tender in Bhutan and Nepal, with Zimbabwe also unofficially using Indian " +
                    "Rupees.");
            Image image = new Image(getClass().getResourceAsStream("images/india.png"));
            currencyFlag.setImage(image);
        });

        // Iranian Rial
        irrBtn.setOnAction(event -> {
            currencyDetailsText.setText("Iranian Rial \n \n The Iranian Rial is the currency used in the Islamic " +
                    "Republic of Iran and used unofficially in Syria, Iraq, parts of Afghanistan and during Hajj (the)"+
                    " islamic pilgrimage to Mecca) in Saudi Arabia.");
            Image image = new Image(getClass().getResourceAsStream("images/iran.png"));
            currencyFlag.setImage(image);
        });

        // Japanese Yen
        jpyBtn.setOnAction(event -> {
            currencyDetailsText.setText("Japanese Yen \n \n The Japanese Yen is the currency used in the Japan.");
            Image image = new Image(getClass().getResourceAsStream("images/japan.png"));
            currencyFlag.setImage(image);
        });

        // Mexican Peso
        mxnBtn.setOnAction(event -> {
            currencyDetailsText.setText("Mexican Pesos \n \n The Mexican Peso is the currency used in Mexico, with " +
                    "the US dollar also commonly being used both as a tourist currency and as a more stable " +
                    "alternative currency. Mexican Pesos are also accepted by some merchants in the United States " +
                    "border region as well as some Belizean and Guatemalan towns.");
            Image image = new Image(getClass().getResourceAsStream("images/mexico.png"));
            currencyFlag.setImage(image);
        });

        // Nigerian Naira
        ngnBtn.setOnAction(event -> {
            currencyDetailsText.setText("Nigerian Naira \n \n The Nigerian Naira is the currency used in Nigeria.");
            Image image = new Image(getClass().getResourceAsStream("images/nigeria.png"));
            currencyFlag.setImage(image);
        });

        // Norweigan Krone
        nokBtn.setOnAction(event -> {
            currencyDetailsText.setText("Norwegian Krone \n \n The Norwegian Krone is the currency used in Norway and "+
                    "it's island territories.");
            Image image = new Image(getClass().getResourceAsStream("images/norway.png"));
            currencyFlag.setImage(image);
        });

        // Pakistani Rupee
        pkrBtn.setOnAction(event -> {
            currencyDetailsText.setText("Pakistani Rupee \n \n The Pakistani Rupee is the currency used in Pakistan " +
                    "and unofficially in parts of Afghanistan.");
            Image image = new Image(getClass().getResourceAsStream("images/pakistan.png"));
            currencyFlag.setImage(image);
        });

        // Polish Złoty
        plzBtn.setOnAction(event -> {
            currencyDetailsText.setText("Polish Złoty \n \n The Polish Złoty is the currency used in Poland.");
            Image image = new Image(getClass().getResourceAsStream("images/poland.png"));
            currencyFlag.setImage(image);
        });

        // British Pound Sterling
        gbpBtn.setOnAction(event -> {
            currencyDetailsText.setText("British Pound Sterling \n \n The British Pound Sterling is the currency used" +
                    " in the United Kingdom, comprising of Scotland, England, Wales, the Isle of Man and the North of "+
                    "Ireland. It is also used as legal tender in the channel island territories of Guernsey and Jersey"+
                    " also. The British overseas territories such as the Falklands, the British Antarctic Territory, "+
                    "Gibraltar (co-official with Gibraltar Pound) and British Indian Ocean Territory and Saint Helena."+
                    "\n \n In the North of Ireland it is common for Euros to be accepted by some traders and merchants"+
                    " due to the presence of a border with the Republic of Ireland which uses the Euro.");
            Image image = new Image(getClass().getResourceAsStream("images/uk.png"));
            currencyFlag.setImage(image);
        });

        // Romanian Leu
        ronBtn.setOnAction(event -> {
            currencyDetailsText.setText("Romanian Leu \n \n The Romanian Leu is the currency used in Romania.");
            Image image = new Image(getClass().getResourceAsStream("images/romania.png"));
            currencyFlag.setImage(image);
        });

        // Russian Ruble
        rubBtn.setOnAction(event -> {
            currencyDetailsText.setText("Russian Ruble \n \n The Russian Ruble is the currency used in the Russian" +
                    " Federation, the unrecognized states of Abkhazia and South Ossetia on the Georgian-Russian border" +
                    " and the Donetsk People's Republic and Luhansk People's Republic in East Ukraine during the " +
                    "ongoing war in Donbass.");
            Image image = new Image(getClass().getResourceAsStream("images/russia.png"));
            currencyFlag.setImage(image);
        });

        // Saudi Riyal
        sarBtn.setOnAction(event -> {
            currencyDetailsText.setText("Saudi Riyal \n \n The Saudi Riyal is the currency used in Saudi Arabia.");
            Image image = new Image(getClass().getResourceAsStream("images/saudiarabia.png"));
            currencyFlag.setImage(image);
        });

        // Serbian Dinar
        rsdBtn.setOnAction(event -> {
            currencyDetailsText.setText("Serbian Dinar \n \n The Serbian Dinar is the currency used in Serbia and is "+
                    "the de-jure currency of Kosovo, an unrecognized state/province of Serbia that also uses the Euro.");
            Image image = new Image(getClass().getResourceAsStream("images/serbia.png"));
            currencyFlag.setImage(image);
        });

        // Singaporean Dollar
        sgdBtn.setOnAction(event -> {
            currencyDetailsText.setText("Singaporean Dollar \n \n The Singaporean Dollar is the currency used in " +
                    "Singapore and used as a customary tender in Brunei Darussalam (and vice versa with the Brunei " +
                    "Dollar in Singapore).");
            Image image = new Image(getClass().getResourceAsStream("images/singapore.png"));
            currencyFlag.setImage(image);
        });

        // South African Rand
        zarBtn.setOnAction(event -> {
            currencyDetailsText.setText("South African Rand \n \n The South African Rand is the currency used in the "+
                    "Republic of South Africa, used as legal tender in neighbouring states such as Namibia, Eswatini/"+
                    "Swaziland and Lesotho and is accepted by traders in Angola,Botswana, Malawai, Zimbabwe and " +
                    "Mozambique.");
            Image image = new Image(getClass().getResourceAsStream("images/southafrica.png"));
            currencyFlag.setImage(image);
        });

        // South Korean Won
        krwBtn.setOnAction(event -> {
            currencyDetailsText.setText("South Korean Won \n \n South Korean Won is the currency used in South Korea.");
            Image image = new Image(getClass().getResourceAsStream("images/south-korea.png"));
            currencyFlag.setImage(image);
        });

        // Swedish Krona
        sekBtn.setOnAction(event -> {
            currencyDetailsText.setText("Swedish Krona \n \n Swedish Krona is the currency of Sweden," +
                    " and like with other nordic countries the 'Krona' means crown in the Swedish language. Sweden is "+
                    "a member of the European Union and the Schengen Area and therefore Euros can be used in tourist "+
                    "regions of Sweden, however it is advised to used Kronas instead due to the poor exchange rate by "+
                    "merchants for euro transactions.");
            Image image = new Image(getClass().getResourceAsStream("images/sweden.png"));
            currencyFlag.setImage(image);
        });

        // Swiss Franc
        chfBtn.setOnAction(event -> {
            currencyDetailsText.setText("Swiss Francs \n \n The Swiss Franc is the currency used in Switzerland," +
                    " Liechtenstein and also parts of Lombardy in Italy. As Switzerland has several ethnic groups " +
                    "within it: Swiss Francs are known as 'Schweizer Franken' in Swiss German, 'Franc Fuisse' in Swiss"+
                    " French and 'Franco Svizzero' in Swiss Italian.");
            Image image = new Image(getClass().getResourceAsStream("images/switzerland.png"));
            currencyFlag.setImage(image);
        });

        // Turkish Lira
        tryBtn.setOnAction(event -> {
            currencyDetailsText.setText("Turkish Lira \n \n The Turkish Lira is the currency used in Turkey and the " +
                    "occupied territories of Northern Cyprus and Turkish-occupied Syria.");
            Image image = new Image(getClass().getResourceAsStream("images/turkey.png"));
            currencyFlag.setImage(image);
        });

        // US Dollars
        usdBtn.setOnAction(event -> {
            currencyDetailsText.setText(" United States Dollar \n \n The United States Dollar, or US Dollar, is the " +
                    "smaller or developing states can peg their currency against for stability. \n \n For this reason "+
                    "the dollar can be used in the United States as well as a variety of states in their sphere of " +
                    "influence instead of converting to their native currency.");
            Image image = new Image(getClass().getResourceAsStream("images/us.png"));
            currencyFlag.setImage(image);
        });
    }

    @FXML
    // sets necessary data for Appointment Controller
    //called when loading AppointmentScreen.fxml
    public void setData ( Stage stage) {
        this.stage = stage;
    }
}
