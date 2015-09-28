        //s.connect(new InetSocketAddress(host , 80));

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class test {
  public static void main(String[] args) {
    String host = "www.google.com";
    String protocol = "http";
    try {
      //Socket socket = new Socket(protocol + "://" + host, 80);
      Socket socket = new Socket(host, 80);
      OutputStream os = socket.getOutputStream();
      boolean autoflush = true;
      PrintWriter out = new PrintWriter(socket.getOutputStream(), autoflush);
      BufferedReader in = new BufferedReader(

      new InputStreamReader(socket.getInputStream()));

      // send an HTTP request to the web server
      out.println("GET / HTTP/1.1");
      out.println("Host: " + host + ":80");
      out.println("Connection: Close");
      out.println();

      // read the response
      boolean loop = true;
      StringBuilder sb = new StringBuilder(8096);
      while (loop) {
        if (in.ready()) {
          int i = 0;
          while (i != -1) {
            i = in.read();
            sb.append((char) i);
          }
          loop = false;
        }
      }

      // display the response to the out console
      System.out.println(sb.toString());
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
