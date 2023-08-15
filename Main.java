/**
 * @author ginga
 * @since 25/4/2023 下午10:08
 */
public class Main {
    public static void main(String[] args) {
        String s = "010";
        int x = Integer.parseInt(s, 2);
        int y = Integer.bitCount(x);
        System.out.println(y);
    }
}
