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

    public static Object convertFileToJson() throws IOException, ParseException {
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader(System.getProperty("user.dir") + "/src/test/resources/Data.json"));

        // typecasting obj to JSONObject
        JSONObject jsonObject = (JSONObject) obj;
        return obj;
    }

    public static String getValue(Object json, String str) {

        if (json instanceof JSONObject) {
            if ((((JSONObject) json).containsKey(str))) {
                value = ((JSONObject) json).get(str).toString();
                log.info(value);
            } else {
                for (Object obj : ((JSONObject) json).keySet()) {
                    if (((JSONObject) json).get(obj) instanceof JSONObject) {
                        JSONObject tempJSON = (JSONObject) ((JSONObject) json).get(obj);
                        getValue(tempJSON, str);
                    }
                    if (((JSONObject) json).get(obj) instanceof JSONArray) {
                        JSONArray jsonArray = (JSONArray) ((JSONObject) json).get(obj);
                        for (int i = 0; i < jsonArray.size(); i++) {
                            getValue(jsonArray.get(i), str);
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
