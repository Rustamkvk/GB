package Lesson_6.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Socket socket = null;

        try {
            socket = new Socket("localhost", 3443);
            // входящий поток
            Scanner in =  new Scanner(socket.getInputStream());
            // исходящий поток
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // с консоли
            Scanner sc = new Scanner(System.in);

            // получаем в этом потоке информацию от сервера
            Socket finalSocket = socket;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String msg = in.nextLine();
                        System.out.println("Сервер: " + msg);

                    }
                }
            }).start();

            // в главном потоке отправляем сообщение серверу
            while (!finalSocket.isClosed()) {
                System.out.println("Введите ваше сообщение...");
                String msg = sc.nextLine();

                // сообщение улетело серверу
                out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}