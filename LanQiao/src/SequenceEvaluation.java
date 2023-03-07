/**
 * @author ginga
 * @since 5/3/2023 下午9:02
 */
public class SequenceEvaluation {
    public static void main(String[] args) {
        int a = 1, b = 1, c = 1, d = 0;
        for (int i = 4; i <= 20190324; i++) {
            d = (a + b + c) % 10000;
            a = b;
            b = c;
            c = d;
        }
        System.out.println(d);
    }
}
