package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
//    public static void initServerSocket() throws IOException {
        //create a server socket
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server listening on Port 9090...");

        //accept client request
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");

        //input stream
        InputStream inputStream = clientSocket.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

        //output stream
        OutputStream outputStream = clientSocket.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream, true);

        // read input
        String message = in.readLine();
        System.out.println("Client says:" + message);

        out.println("Client msg received");
    }
}
