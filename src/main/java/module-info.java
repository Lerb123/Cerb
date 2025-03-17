module com.lerb.test {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.lerb.test to javafx.fxml;
    exports com.lerb.test;
}
