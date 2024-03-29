package fr.nehmes.weatherapp.WeatherVue;

import fr.nehmes.weatherapp.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class WeatherVue {

    public Scene getScene(double width, double height) throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("weather_vue.fxml"));
        Parent root = loader.load();
        WeatherController controller = loader.getController();
        controller.setWeather();
        return new Scene(root,width,height);
    }


}
