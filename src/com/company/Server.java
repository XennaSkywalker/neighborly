package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server{
    public static void main(String[] args) throws IOException {
//    public static void initServerSocket() {

            //create a server socket
            ServerSocket serverSocket = new ServerSocket(9090);
            System.out.println("Server listening on Port 9090...");
            while (true){
                //accept client request
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");


                //initialising input/output stream
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);


                //client sends output, take it as input, display on terminal
                new Thread(() -> {
                    try {
                        String response = "";
                        while ((response = in.readLine()) != null) {
                            System.out.println("[Client]" + response);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

            }
    }

//    @Override
//    public void run() {
//        initServerSocket();
//    }
}
