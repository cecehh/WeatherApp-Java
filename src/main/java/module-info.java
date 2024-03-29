module fr.nehmes.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.fasterxml.jackson.databind;

    opens fr.nehmes.weatherapp to javafx.fxml;
    exports fr.nehmes.weatherapp;
    opens fr.nehmes.weatherapp.WeatherVue to javafx.fxml;
    exports fr.nehmes.weatherapp.WeatherVue;
}