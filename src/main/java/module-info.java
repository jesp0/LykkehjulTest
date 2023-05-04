module com.example.lykkehjul {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lykkehjul to javafx.fxml;
    exports com.example.lykkehjul;
}