package greedy;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author ginga
 * @since 7/4/2023 下午7:45
 */
public class Assemble {
    static Scanner input = new Scanner(new BufferedInputStream(System.in));
    static int t, n, b;
    // 配件类型为键, 此类型所有配件存储在列表里
    static Map<String, List<Component>> components = new HashMap<>();
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        t = input.nextInt();

        while (t-- > 0) {
            n = input.nextInt();
            b = input.nextInt();
            if (!components.isEmpty()) components.clear();

            // 记录最高的品质, 为后面二分做准备
            int maxQ = 0;
            for (int i = 0; i < n; i++) {
                String type = input.next();
                input.next();
                int price = input.nextInt();
                int quality = input.nextInt();

                // 初始化map的列表
                components.putIfAbsent(type, new ArrayList<>());
                // 此类型的配件加入列表
                components.get(type)
                          .add(new Component(price, quality));

                maxQ = Math.max(maxQ, quality);
            }

            // 二分找到尽可能大的最差的品质
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

            output.append(ans).append('\n');
        }

        System.out.print(output);
        input.close();
    }

    // 检查当前品质是否合适
    private static boolean check(int quality) {
        int sum = 0;

        // 遍历每一类的所有配件
        for (List<Component> componentList : components.values()) {
            int cheapest = b + 1;

            // 找到此类配件中大于等于给定品质的最便宜的一个
            for (Component component : componentList) {
                if (component.quality >= quality)
                    cheapest = Math.min(cheapest, component.price);

            }

            // 如果没有大于等于给定品质的, 返回false
            if (cheapest == b + 1)
                return false;

            // 总价钱 加上 最便宜配件的价钱
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
