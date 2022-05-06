module com.geekbrains.server.server {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.geekbrains.server.server to javafx.fxml;
    exports com.geekbrains.server.server;
    exports com.geekbrains.server.server.chat;
    opens com.geekbrains.server.server.chat to javafx.fxml;
}