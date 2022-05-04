package com.geekbrains.clientchat.controllers;


import com.geekbrains.clientchat.ClientChat;
import com.geekbrains.clientchat.Network;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.function.Consumer;

public class ClientController {

    @FXML
    public TextField messageTextArea;

    @FXML
    public Button sendMessageButton;

    @FXML
    public TextArea chatTextArea;

    @FXML
    public ListView userList;

    private ClientChat application;


    public void sendMessage() {
        String message = messageTextArea.getText();

        if (message.isEmpty()) {
            messageTextArea.clear();
            return;
        }

        String sender = application.getChatStage().getTitle();
        String recipient = "all";
        if (!userList.getSelectionModel().isEmpty()) {
            recipient = userList.getSelectionModel().getSelectedItem().toString();
        }
        try {
            Network.getInstance().sendMessage(sender + "&&4" + message + "&&4" + recipient);
        } catch (IOException e) {
            application.showErrorDialog("Ошибка передачи данных по сети");
        }
        appendMessageToChat(sender, message);
    }

    public void appendMessageToChat(String sender, String message) {

        chatTextArea.appendText(DateFormat.getInstance().format(new Date()));
        chatTextArea.appendText(System.lineSeparator());

        if (sender != null) {
            if (!sender.equals(application.getChatStage().getTitle())) {
                chatTextArea.appendText(sender + ":");
                chatTextArea.appendText(System.lineSeparator());
            } else {
                chatTextArea.appendText("Я:");
                chatTextArea.appendText(System.lineSeparator());
            }
        }

        chatTextArea.appendText(message);
        chatTextArea.appendText(System.lineSeparator());
        chatTextArea.appendText(System.lineSeparator());
        messageTextArea.requestFocus();
        messageTextArea.clear();
    }

    public void initializeMessageHandler() {
        Network.getInstance().waitMessages(new Consumer<String>() {
            @Override
            public void accept(String message) {
                String[] parts = message.split("&&4");
                message = parts[1];
                String me = application.getChatStage().getTitle();
                String sender = parts[0];
                String recipient = parts[2];
                if (Objects.equals(recipient, "all") || Objects.equals(recipient, me)) {
                    appendMessageToChat(sender, message);
                }
            }
        });
    }

    public ClientChat getApplication() {
        return application;
    }

    public void setApplication(ClientChat application) {
        this.application = application;
    }
}