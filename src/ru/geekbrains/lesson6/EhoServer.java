package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EhoServer {
    private static final int PORT = 8189;


    public static void main(String[] args) {

        echoServer();
    }

    private static void echoServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер начал работу, ожидаем новые подключения");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");

            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream()); // чтение
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream()); // запись

            processClientConnection(inputStream);
            sendMessage(outputStream);
        } catch (IOException e) {
            System.err.println("Ошибка при подключении к порту " + PORT);
            e.printStackTrace();
        }

    }

    private static void processClientConnection(DataInputStream inputStream) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    String message = inputStream.readUTF();
                    if (message.startsWith("/end")) {
                        break;
                    }
                    System.out.println("сообщение от клиента: " + message);
                } catch (IOException e) {
                    System.out.println("Сетевое соединение было закрыто");
                    break;
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private static void sendMessage(DataOutputStream outputStream) throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.startsWith("/end")) {
                break;
            }
            if (!answer.isEmpty()) {
                try {
                    outputStream.writeUTF("Server Answered: " + answer);
                } catch (IOException e) {
                    System.err.println("не удалось отпраить сообщение клиенту");
                    throw e;
                }
            }
        }
    }
}
