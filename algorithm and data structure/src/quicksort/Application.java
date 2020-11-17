package kr.or.iei.ex20201117;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        final List<Integer> randomInts = new Random()
                .ints(10, 1, 30)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(randomInts);
        final List<Integer> sorted = Quicksort.sort(randomInts);
        System.out.println(sorted);
    }

    /**
     * @param n 항 번호
     * @return 피보나치 수열의 해당 항 값
     */
    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    // call fibo(4)
    // fibo(3) + fibo(2)

    // call fibo(3)
    // 1 + fibo(1)

    // call fibo(2)
    // 1 + 0

    // call fibo(1)
    // 0 + -1

    private static int factorial(int n) {
        // 탈출조건
        if (n == 1) {
            return 1;
        }
        // 5
        // 4 * 3 * 2 * 1
        // 4
        // 3 * 2 * 1
        // 3
        // 2 * 1
        // 5 * factorial(4) * factorial(3) * ... * factorial(1)
        return n * factorial(n - 1);
    }

}
