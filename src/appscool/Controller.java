package appscool;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private OptionsCommander optionsCommander = new OptionsCommander();

    @FXML
    public TextField tfURLSite;

    @FXML
    public TextField tfTelephon;

    @FXML
    public PasswordField tfPassword;

    @FXML
    public TextField tfFamilijRod;

    @FXML
    public TextField tfImjRod;

    @FXML
    public TextField tfOtchestvoRod;

    @FXML
    public TextField tfSerij;

    @FXML
    public TextField tfNomer;

    @FXML
    public TextField tfKemVydan;

    @FXML
    public DatePicker dpDataVyd;

    @FXML
    public ChoiceBox chbTipRod;

    @FXML
    public Button btnExit;

    @FXML
    public Button btn1;

    @FXML
    public Button btn2;

    @FXML
    public Button btn11;

    @FXML
    public Button btn12;

    @FXML
    public Button btn13;

    @FXML
    public Button btn21;

    @FXML
    public Button btn22;

    @FXML
    public Button btn23;

    @FXML
    public Button btn24;

    @FXML
    public Button btn25;

    @FXML
    public Button btn26;

    @FXML
    public Button btn27;

    private void SaveParams(){
        optionsCommander.setParametr("URLSite", tfURLSite.getText());
        optionsCommander.setParametr("Telephone", tfTelephon.getText());
        optionsCommander.setParametr("Password", tfPassword.getText());
        optionsCommander.setParametr("FamilijRod", tfFamilijRod.getText());
        optionsCommander.setParametr("ImjRod", tfImjRod.getText());
        optionsCommander.setParametr("OtchestvoRod", tfOtchestvoRod.getText());
        optionsCommander.setParametr("Serij", tfSerij.getText());
        optionsCommander.setParametr("Nomer", tfNomer.getText());
        optionsCommander.setParametr("KemVydan", tfKemVydan.getText());
        optionsCommander.setParametr("TipRod", chbTipRod.getValue().toString());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String strDataVyd = dpDataVyd.getValue().format(formatter);
        optionsCommander.setParametr("DataVyd", strDataVyd);
    }

    private void LoadParams(){
        tfURLSite.setText(optionsCommander.getParametr("URLSite"));
        tfTelephon.setText(optionsCommander.getParametr("Telephone"));
        tfPassword.setText(optionsCommander.getParametr("Password"));
        tfFamilijRod.setText(optionsCommander.getParametr("FamilijRod"));
        tfImjRod.setText(optionsCommander.getParametr("ImjRod"));
        tfOtchestvoRod.setText(optionsCommander.getParametr("OtchestvoRod"));
        tfSerij.setText(optionsCommander.getParametr("Serij"));
        tfNomer.setText(optionsCommander.getParametr("Nomer"));
        tfKemVydan.setText(optionsCommander.getParametr("KemVydan"));

        chbTipRod.getSelectionModel().select(optionsCommander.getParametr("TipRod"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String strDataVyd = optionsCommander.getParametr("DataVyd");
        dpDataVyd.setValue(LocalDate.parse(strDataVyd, formatter));
    }

    public void initialize(URL location, ResourceBundle resources) {
        chbTipRod.getItems().addAll("Отец","Мать","Опекун","Иное");
        chbTipRod.getSelectionModel().select("Отец");
        LoadParams();
        System.setProperty(MyData.NameChromeDriver, MyData.PathDriver);
        MyData.webDriver = new ChromeDriver();
    }

    @FXML
    private void processClearFields(ActionEvent event){

        if (event.getSource() == btn21){
            tfFamilijRod.setText("");
        } else if (event.getSource() == btn22) {
            tfImjRod.setText("");
        } else if (event.getSource() == btn23){
            tfOtchestvoRod.setText("");
        } else if (event.getSource() == btn24){
            tfSerij.setText("");
        } else if (event.getSource() == btn25){
            tfNomer.setText("");
        } else if (event.getSource() == btn26){
            tfKemVydan.setText("");
        } else if (event.getSource() == btn27){
//            tfDataVyd.setText("");
        }else if (event.getSource() == btn11){
            tfURLSite.setText("");
        }else if (event.getSource() == btn12){
            tfTelephon.setText("");
        }else if (event.getSource() == btn13){
            tfPassword.setText("");
        }
    }

    @FXML
    private void processSetSave(ActionEvent event) {
        SaveParams();
    }

    @FXML
    public void proccessLoad(ActionEvent event) {
        LoadParams();
    }

    @FXML
    private void processExit(ActionEvent event) {
        SaveParams();
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
        MyData.webDriver.close();
        MyData.webDriver.quit();
    }

    @FXML
    private void processNaSite(ActionEvent event) {

        if (event.getSource() == btn1) {
            MyData.webDriver.get(tfURLSite.getText());
            MyData.webDriver.manage().window().maximize();
            MyData.webDriver.findElement(By.className("btn-base")).click();

            MyData.webDriver.findElement(By.id("mobileOrEmail")).sendKeys(tfTelephon.getText());
            MyData.webDriver.findElement(By.id("password")).sendKeys(tfPassword.getText());
            MyData.webDriver.findElement(By.className("ui-button")).click();
        } else if (event.getSource() == btn2) {
            Select select = new Select(MyData.webDriver.findElement(By.className("form-control")));
            select.selectByVisibleText("г. о. Самара");
            MyData.webDriver.findElement(By.className("btn")).click();
        }
    }


}

// /        try { // паУза 2 секунды
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
