package power;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import power.*;

public class Gobbler implements Runnable {
    private PrintStream out;
    private String message;
    private BufferedReader reader;

    public Gobbler(InputStream inputStream, PrintStream out) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
               this.out = out;
               System.out.println("out : " + out);
        this.message = ( null != message ) ? message : "";
    }

    public void run() {
        String line;

        try {
            while (null != (line = this.reader.readLine())) {
                out.println(message + line);
                System.out.println("reader: " + message + line);  
            }
            System.out.println("reader 2: " + message + line);
            this.reader.close();
        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}

