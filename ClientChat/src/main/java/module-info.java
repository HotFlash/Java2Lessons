module com.geekbrains.clientchat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.geekbrains.clientchat to javafx.fxml;
    exports com.geekbrains.clientchat;
}