package util;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pages.P01_Homepage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import static util.driver.DriverHolder.getDriver;

public class JSONdata {

    public static JSONObject getJsonData() throws IOException, org.json.simple.parser.ParseException {

        File filename = new File("src//test//resources//testData//testData.json");

        String json = FileUtils.readFileToString(filename, "UTF-8");

        Object obj = new JSONParser().parse(json);

        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;

    }
    public static String getTestData(String input) throws IOException, org.json.simple.parser.ParseException {
        String testdata;

        return testdata = (String) getJsonData().get(input);
    }

}
