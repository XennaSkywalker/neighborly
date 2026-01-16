package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
//    public static void initClientSocket() throws IOException {
        Socket clientSocket = new Socket("localhost",9090);

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        out.println("Client connected");

        //server sends output, take it as input, display on terminal
        new Thread(() -> {
            try {
                String response = "";
                while ((response = in.readLine()) != null) {
                    System.out.println("[Server]" + response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        //client takes input from terminal, send it to server as output
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true){
                String userInput = scanner.nextLine();
                out.println(userInput);
            }
        }).start();


        clientSocket.close();
    }
}
