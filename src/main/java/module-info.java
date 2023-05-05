module com.example.lykkehjulgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lykkehjulgui to javafx.fxml;
    exports com.example.lykkehjulgui;
}