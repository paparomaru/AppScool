package appscool;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Controller {

    private String fPath = "";

    @FXML
    public TextField tfFamilia;

    @FXML
    private void processClearFam(ActionEvent event) {
        tfFamilia.setText("");
    }

    @FXML
    private void processSetSave(ActionEvent event) {

        String strLastName = "";

        fPath = new File("").getAbsolutePath();
        fPath = fPath+"\\appscool.ini";


        try {
            //Создаем объект свойст
            Properties properties = new Properties();
            File file = new File(fPath);
            //Загружаем свойства из файла
            properties.load(new FileInputStream(file));
            //Получаем в переменную значение конкретного свойства
            String host = properties.getProperty("lastname");

            strLastName = tfFamilia.getText();

            //Устанавливаем значение свойста
            properties.setProperty("lastname", strLastName);
            //Сохраняем свойства в файл.
            properties.store(new FileOutputStream(file), null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "Сохранили!");
    }

    @FXML
    private void processExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void proccessLoad(ActionEvent event) {

        String strLastName = "";

        fPath = new File("").getAbsolutePath();
        fPath = fPath+"\\appscool.ini";


        try {
            //Создаем объект свойст
            Properties properties = new Properties();
            File file = new File(fPath);
            //Загружаем свойства из файла
            properties.load(new FileInputStream(file));
            //Получаем в переменную значение конкретного свойства
            strLastName = properties.getProperty("lastname");
            tfFamilia.setText(strLastName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "Загрузили!");
    }
}
