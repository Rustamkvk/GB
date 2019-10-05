package Lesson_6.Server;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {


    public static void main(String[] args) {
        Server server = new Server();
    }

    public Server() {

        // розетка сервера
        ServerSocket server = null; // иницилизация локальной перемннной, так что пишу нолик
        // hрозетка клиента, это некий поток, который будет подключаться к серверу
        Socket socket = null;

        try {
            // порт, который будет прослушивать наш сервер
            server = new ServerSocket(3443);
            System.out.println("Сервер активен...");
            socket = server.accept();
            System.out.println("У нас новое подключение");
            // входящий поток
            Scanner in =  new Scanner(socket.getInputStream());
            // исходящий поток
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //или пишем внизу метод
            // с консоли
            Scanner sc = new Scanner(System.in);

            // отправляем в этом потоке сообщение от сервера
            Socket finalSocket = socket;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!finalSocket.isClosed()) {
                        System.out.println("Напишите сообщение (сервер)");
                        String msg = sc.nextLine();
                        System.out.println("Ваще сообщение отправленно!");
                        out.println(msg);
                    }
                }
            }).start();

            while (!finalSocket.isClosed()) {
                String msg = in.nextLine();
                if (msg.equals("/end")){
                    out.flush();   // это автоматический/принудительный сброс буфера вывода
                Thread.sleep(3000);
                break;}
                System.out.println("Client: " + msg);

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close(); // закрываем розетку клиента
                server.close(); // закрываем розетку клиента
                System.out.println("Server closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}