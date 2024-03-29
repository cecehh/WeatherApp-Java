package fr.nehmes.weatherapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UrlRequest {

    public static String getTemperature(List<String> temps) {
        try {
            URL url = URI.create("https://api.open-meteo.com/v1/forecast?latitude="+ temps.get(0) +"&longitude="+ temps.get(1)+"&hourly=temperature_2m").toURL();
            JsonMapper mapper = new JsonMapper();
            JsonNode js = mapper.readTree(url);
            return js.get("hourly").get("temperature_2m").get(1).asText();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getCoords(String name){
        try {
            name = name.replace(' ','+');
            URL url = URI.create("https://geocoding-api.open-meteo.com/v1/search?name="+name+"&count=1&language=en&format=json").toURL();
            JsonMapper mapper = new JsonMapper();
            JsonNode js = mapper.readTree(url);
            ArrayList<String> coords= new ArrayList<>();
            coords.add(js.get("results").get(0).get("latitude").asText());
            coords.add(js.get("results").get(0).get("longitude").asText());
            return coords;
        }catch (NullPointerException | IOException e){
            System.out.println("La ville n'existe pas ");
            Alert msgBox = new Alert(Alert.AlertType.ERROR);
            msgBox.setTitle("Ville non trouvée");
            msgBox.setContentText("Cette ville n'existe pas , veuillez saisir un nom valide");
            msgBox.show();
        }
        return null;
    }
}
