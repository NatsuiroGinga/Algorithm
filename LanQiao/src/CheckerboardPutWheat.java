import java.math.BigInteger;

/**
 * @author ginga
 * @since 10/3/2023 上午10:49
 */
public class CheckerboardPutWheat {
    public static void main(String[] args) {
        BigInteger ans = new BigInteger("1");
        BigInteger first = new BigInteger("1");
        final BigInteger two = new BigInteger("2");
        for (int i = 1; i < 64; i++) {
            final BigInteger multiply = first.multiply(two);
            first = multiply;
            ans = ans.add(multiply);
        }
        System.out.println(ans);
    }
}
