package edu.netty.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Tim Wang on 4/11/2016.
 */
public class RegularWeb {
    public static void startSocket() throws IOException {
        ServerSocket s = new ServerSocket(10001);
        Socket client = s.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream());
        String request, response;
        while ((request = in.readLine()) != null) {
            if ("Done".equals(request)) {
                break;
            }
        }
        //response = processRequest(request);
        response = "!" + request;
        out.println(response);
    }

    public static void accessSocket() throws IOException {
        Socket socket = new Socket("localhost", 10001);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("1234");
    }

    public static void main(String[] args) throws IOException {
        startSocket();
    }

}
