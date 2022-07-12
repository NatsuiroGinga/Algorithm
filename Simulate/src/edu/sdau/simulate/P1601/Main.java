package edu.sdau.simulate.P1601;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author ginga
 * @version 1.0
 * @ClassName Main
 * @Date 12/7/2022 下午2:47
 */
public class Main {

    public static void main(String[] args) {
        String x, y;
        final Scanner input = new Scanner(System.in);
        x = input.next();
        y = input.next();

        System.out.println(new BigInteger(x).add(new BigInteger(y)));
    }

}
