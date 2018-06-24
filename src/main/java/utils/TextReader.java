package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextReader {

    private final String SEPARATOR = File.separator;

    private final String PATH_TO_TEST_DATA_FOLDER = String.format("%s%ssrc%stasks9_10%stask3%s"
            , System.getProperty("user.dir"),
            SEPARATOR, SEPARATOR, SEPARATOR, SEPARATOR);


    public String readFileToString(String filePath) {
        FileReader fileReader = readFile(filePath);
        Scanner scan = new Scanner(readFile(filePath));

        StringBuilder fileText = new StringBuilder();
        while (scan.hasNextLine()) {
            fileText.append(scan.nextLine()).append("\n");
        }
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileText.toString();
    }

    public Map<Integer, String> readFileToHashMap(String filePath) {

        FileReader fileReader = readFile(filePath);
        Scanner scan = new Scanner(readFile(filePath));

        Map<Integer, String> map = new HashMap();
        int row = 1;
        while (scan.hasNextLine()) {
            map.put(row, scan.nextLine());
            row++;
        }
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    private FileReader readFile(String filePath) {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(PATH_TO_TEST_DATA_FOLDER + filePath);
        } catch (FileNotFoundException e) {
            System.err.println(String.format("File with path \"%s\" is not found", PATH_TO_TEST_DATA_FOLDER + filePath));
        }
        return fileReader;
    }
}
