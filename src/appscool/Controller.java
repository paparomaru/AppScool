package appscool;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.net.URL;
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
    public Button btnExit;

    @FXML
    public Button btn1;

    @FXML
    public Button btn2;

    public void initialize(URL location, ResourceBundle resources) {
        tfURLSite.setText(optionsCommander.getParametr("URLSite"));
        tfTelephon.setText(optionsCommander.getParametr("Telephone"));
        tfPassword.setText(optionsCommander.getParametr("Password"));
    }

    @FXML
    private void processClearURLSite(ActionEvent event) {
        tfURLSite.setText("");
    }

    @FXML
    private void processClearTelephone(ActionEvent event) {
        tfTelephon.setText("");
    }

    @FXML
    private void processClearPassword(ActionEvent event) {
        tfPassword.setText("");
    }

    @FXML
    private void processSetSave(ActionEvent event) {
        String strLastName = tfURLSite.getText();
        optionsCommander.setParametr("URLSite", strLastName);
    }

    @FXML
    public void proccessLoad(ActionEvent event) {

        String strLastName = optionsCommander.getParametr("URLSite");
        tfURLSite.setText(strLastName);
    }

    @FXML
    private void processExit(ActionEvent event) {
        String strURLSite = tfURLSite.getText();
        optionsCommander.setParametr("URLSite", strURLSite);
        String strTelephon = tfTelephon.getText();
        optionsCommander.setParametr("Telephone", strTelephon);
        String strPassword = tfPassword.getText();
        optionsCommander.setParametr("Password", strPassword);

        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void processNaSite(ActionEvent event) {

        if (event.getSource() == btn1) {
            String NameChromeDriver = "webdriver.chrome.driver";
            String PathDriver = "chromedriver.exe";
            System.setProperty(NameChromeDriver, PathDriver);
            WebDriver webDriver = new ChromeDriver();
            webDriver.get(tfURLSite.getText());
            webDriver.manage().window().maximize();
            webDriver.findElement(By.className("btn-base")).click();

            webDriver.findElement(By.id("mobileOrEmail")).sendKeys(tfTelephon.getText());
            webDriver.findElement(By.id("password")).sendKeys(tfPassword.getText());
            webDriver.findElement(By.className("ui-button")).click();
        } else if (event.getSource() == btn2) {
            Select select = new Select(webDriver.findElement(By.className("form-control")));
            select.selectByVisibleText("г. о. Самара");
            webDriver.findElement(By.className("btn")).click();
        }
        // /        try { // паУза 2 секунды
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
