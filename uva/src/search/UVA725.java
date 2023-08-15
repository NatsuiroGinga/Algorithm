package search;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;

/**
 * @author ginga
 * @since 9/5/2023 上午9:38
 */
public class UVA725 {
    public static void main(String[] args) {
        PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out));
        LocalTime start = LocalTime.now();
        String repeat = "boa".repeat(1000);

        for (int i = 0; i < 10000; i++) {
            output.println(repeat);
        }

        LocalTime end = LocalTime.now();
        System.out.println("\n" + "=".repeat(100));
        System.out.println(Duration.between(start, end).toMillis() + "ms");
    }
}
