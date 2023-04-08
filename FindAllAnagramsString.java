import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author ginga
 * @since 22/3/2023 上午10:41
 */
public class FindAllAnagramsString {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static int t, n, b;
    static Map<String, List<Component>> components = new HashMap<>();
    static PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        t = input.nextInt();

        while (t-- > 0) {
            n = input.nextInt();
            b = input.nextInt();
            if (!components.isEmpty()) components.clear();

            int maxQ = 0;
            for (int i = 0; i < n; i++) {
                String type = input.next();
                input.next();
                int price = input.nextInt();
                int quality = input.nextInt();

                components.putIfAbsent(type, new ArrayList<>());
                components.get(type)
                          .add(new Component(price, quality));

                maxQ = Math.max(maxQ, quality);
            }

            int low = 0, high = maxQ, ans = 0;
            while (low <= high) {
                int mid = (low + high) / 2;

                if (check(mid)) {
                    low = mid + 1;
                    ans = mid;
                } else {
                    high = mid - 1;
                }
            }

            output.println(ans);
        }

        input.close();
        output.close();
    }

    private static boolean check(int quality) {
        int sum = 0;

        for (List<Component> componentList : components.values()) {
            int cheapest = b + 1;

            for (Component component : componentList) {
                if (component.quality >= quality)
                    cheapest = Math.min(cheapest, component.price);

            }

            if (cheapest == b + 1)
                return false;

            sum += cheapest;

            if (sum > b)
                return false;
        }

        return true;
    }

    private static class Component {
        int price, quality;

        public Component(int price, int quality) {
            this.price = price;
            this.quality = quality;
        }
    }
}
