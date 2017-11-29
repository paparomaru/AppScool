package appscool;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private OptionsCommander optionsCommander = new OptionsCommander();

    @FXML
    public TextField tfURLSite;

    @FXML
    public Button btnExit;

    @FXML
    private void processClearURLSite(ActionEvent event) {
        tfURLSite.setText("");
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

    @FXML //ghtdtl
    private void processExit(ActionEvent event) {
        String strURLSite = tfURLSite.getText();
        optionsCommander.setParametr("URLSite", strURLSite);

        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String strURLSite = optionsCommander.getParametr("URLSite");
        tfURLSite.setText(strURLSite);
    }
}
