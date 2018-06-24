package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import domain.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class JsonUtil {

    public static ArrayList<User> passeJSON(String pathToFile) {

        FileInputStream file = null;
        try {
            file = new FileInputStream(pathToFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeFactory factory = TypeFactory.defaultInstance();

        ArrayList<User> list = null;
        try {
            list = mapper.readValue(
                    file, factory.constructCollectionType(
                            ArrayList.class, User.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Object[]> passeJSONToObjectsArray(String pathToJSON) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(pathToJSON);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeFactory factory = TypeFactory.defaultInstance();

        ArrayList<Object[]> list = null;
        try {
            list = mapper.readValue(
                    file, factory.constructCollectionType(
                            ArrayList.class, User.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
