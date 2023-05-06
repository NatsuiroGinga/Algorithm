package greedy;

/**
 * @author ginga
 * @since 5/5/2023 上午9:36
 */
public class LeetCode860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            switch (bill) {
                case 5 -> five++;
                case 10 -> {
                    if (five == 0) return false;
                    five--;
                    ten++;
                }
                case 20 -> {
                    if (five == 0) return false;
                    if (ten > 0) {
                        ten--;
                        five--;
                        continue;
                    }
                    if (five < 3) return false;
                    five -= 3;
                }
            }
        }

        return true;
    }
}
