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
    public TextField tfFamilia;

    @FXML
    public Button btnExit;

    @FXML
    private void processClearFam(ActionEvent event) {
        tfFamilia.setText("");
    }

    @FXML
    private void processSetSave(ActionEvent event) {
        String strLastName = tfFamilia.getText();
        optionsCommander.setParametr("lastname", strLastName);
    }

    @FXML
    public void proccessLoad(ActionEvent event) {

        String strLastName = optionsCommander.getParametr("lastname");
        tfFamilia.setText(strLastName);
    }

    @FXML
    private void processExit(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String strLastName = optionsCommander.getParametr("lastname");
        tfFamilia.setText(strLastName);
    }
}
