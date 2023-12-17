module com.example.hello_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hello_fx to javafx.fxml;
    exports com.example.hello_fx;
}