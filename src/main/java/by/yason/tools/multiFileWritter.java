package by.yason.tools;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class multiFileWritter extends Thread {
    static Queue<String> quel = new ConcurrentLinkedDeque();

    public static void write(String val) {
        quel.add(val);
    }

    @Override
    public void run() {

        try {
            fileWritter();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void fileWritter() throws IOException, InterruptedException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("result.csv", true));
        while (!interrupted()) {
            while (quel.size() > 0) {
                writer.write(quel.poll() + "\n");
                writer.flush();
            }
        }
        Thread.currentThread().wait(100);
        writer.close();
    }

}