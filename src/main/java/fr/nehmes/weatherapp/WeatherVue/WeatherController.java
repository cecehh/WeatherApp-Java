package fr.nehmes.weatherapp.WeatherVue;

import fr.nehmes.weatherapp.UrlRequest;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import java.util.List;

public class WeatherController {

    @FXML
    Label Temperature;

    @FXML
    TextField City;

    @FXML
    Button btnTemp;

    public void setWeather(){
        Temperature.setFont(new Font("TimesRoman", 20));

        btnTemp.setOnAction(e -> {
            List<String> coords = UrlRequest.getCoords(City.getText());
            if(coords != null){
                Temperature.setText(UrlRequest.getTemperature(coords));
            }
        });

    }
}
