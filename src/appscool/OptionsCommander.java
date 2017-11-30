package appscool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


class OptionsCommander {

    private String strFileINI = "";

    /* Конструктор класса OptionsCommander */
    OptionsCommander(){
        String fPath = new File("").getAbsolutePath();
        strFileINI = fPath+"\\appscool.ini";
    }

    public String getParametr(String strParam) {
        String strRez = "";

        try {
            Properties properties = new Properties();
            File file = new File(strFileINI);
            properties.load(new FileInputStream(file));
            strRez = properties.getProperty(strParam);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Параметр: "+strParam+" был загружен из файла!"+strRez);

        return strRez;
    }

    public void setParametr(String strParam, String strZnach) {
        try {
            Properties properties = new Properties();
            File file = new File(strFileINI);
            properties.load(new FileInputStream(file));
            properties.setProperty(strParam, strZnach);
            properties.store(new FileOutputStream(file), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Параметр: "+strParam+" был сохранен со значением: "+strZnach);
    }

}
