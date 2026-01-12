package com.company;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException{
//    public static void initClientSocket() throws IOException {
        Socket clientSocket = new Socket("localhost",9090);

        OutputStream outputStream = clientSocket.getOutputStream();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        InputStream inputStream = clientSocket.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        out.println("Client says yooo");

        String response = in.readLine();
        System.out.println("Server:" + response);

        clientSocket.close();
    }
}
