package utils;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonRead {

    static Logger log = Logger.getLogger(JsonRead.class);
    static String value = "";

    /* This method is used for reading from json file */
    public static JSONArray jsonRead() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/main/java/utils/Data.json");
        //Read JSON file
        Object obj = jsonParser.parse(reader);
        JSONArray usersList = (JSONArray) obj;
        return usersList;
    }

    public static String getValue(Object json, String str) {

        if (json instanceof org.json.simple.JSONObject) {
            if ((((org.json.simple.JSONObject) json).containsKey(str))) {
                value = ((JSONObject) json).get(str).toString();
                log.info(value);
            } else {
                for (Object obj : ((JSONObject) json).keySet()) {
                    if (((JSONObject) json).get(obj) instanceof JSONObject) {
                        JSONObject tempJSON = (JSONObject) ((JSONObject) json).get(obj);
                        getValue(tempJSON, str);
                    }
                    if (((JSONObject) json).get(obj) instanceof JSONArray) {
                        JSONArray tempArrray = (JSONArray) ((JSONObject) json).get(obj);
                        for (int i = 0; i < tempArrray.size(); i++) {
                            getValue(tempArrray.get(i), str);
                        }
                    }

                }
            }
        } else if (json instanceof JSONArray) {
            JSONArray tempArrray = (JSONArray) ((JSONObject) json).get(json);
            for (int i = 0; i < (((JSONArray) json).size()); i++) {
                getValue(tempArrray.get(i), str);
            }
        }
        return value;
    }

}
