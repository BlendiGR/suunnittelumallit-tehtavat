package facade;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.simple.JSONObject; // add Maven dependency for JSON.simple
import org.json.simple.parser.JSONParser; // add Maven dependency for JSON.simple
import org.json.simple.parser.ParseException;

public class ApiClient {

    public String fetch(String url, String attribute) throws IOException {
        try {
            String jsonResult = getJsonFromApi(url);
            return extractJokeFromJson(jsonResult, attribute);
        } catch (ParseException e) {
            throw new IOException("Failed to parse JSON response", e);
        }
    }

    private String getJsonFromApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }

    private String extractJokeFromJson(String json, String attribute) throws IllegalArgumentException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);
        String result = (String) jsonObject.get(attribute);
        if (result == null) {
            throw new  IllegalArgumentException("Attribute is null");
        }
        return result;
    }
}