import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author ginga
 * @since 10/3/2023 下午8:43
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        final String line = scanner.nextLine();
        String reg = "\\b[a-zA-Z_]\\w*";
        final String[] split = line.toLowerCase()
                                   .split(" ");
        final List<String> words = Arrays.stream(split)
                                         .filter(s -> s.matches(reg))
                                         .distinct()
                                         .sorted()
                                         .collect(Collectors.toList());

        System.out.println(String.join(" ", words));
    }
}