package appscool;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.*;

public class Main extends Application {

    private String fPath = "";
    private String fFileLog = "";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainForm.fxml"));
        primaryStage.setTitle("Хочу в школу!!!");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init(){

        fPath = new File("").getAbsolutePath();
        fFileLog = fPath+"\\appscool.log";

        try {
            PrintStream sysOut = new PrintStream(new FileOutputStream(fFileLog));
            System.setOut(sysOut);
        } catch (Exception e){}

        System.out.println("Запуск программы!");
    }

    @Override
    public void stop(){
        System.out.println("Завершение программы!");
        JOptionPane.showMessageDialog(null, "Работа с программой завершена!");
    }
}
