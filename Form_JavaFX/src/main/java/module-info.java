module com.example.form_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.form_javafx to javafx.fxml;
    exports com.example.form_javafx;
}