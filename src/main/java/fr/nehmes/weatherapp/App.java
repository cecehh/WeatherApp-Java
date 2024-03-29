package fr.nehmes.weatherapp;

import fr.nehmes.weatherapp.WeatherVue.WeatherVue;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new WeatherVue().getScene(600,400);
        stage.setTitle("Weather APP");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}