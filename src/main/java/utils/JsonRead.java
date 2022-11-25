package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class JsonRead {

    public static JSONArray JsonRead() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/main/java/utils/Data.json");
        //Read JSON file
        Object obj = jsonParser.parse(reader);
        JSONArray usersList = (JSONArray) obj;
        return usersList;
    }
}
