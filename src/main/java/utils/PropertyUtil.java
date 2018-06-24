package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

    public Properties readPropertyFromFile(String pathToFile) {
        FileInputStream fileInputStream = null;
        Properties property = new Properties();

        try {
            fileInputStream = new FileInputStream(pathToFile);
            property.load(fileInputStream);
        } catch (IOException e) {
            System.err.println(String.format("File with path \"%s\" is not found", pathToFile));
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return property;
    }
}
