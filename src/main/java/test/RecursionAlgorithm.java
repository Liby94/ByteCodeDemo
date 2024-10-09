package test;

import java.util.function.Consumer;

public class RecursionAlgorithm implements Consumer<String> {

    private static volatile int value = 0;

    private static int sigma(int n) {
        value = n;
        System.out.println(" current n value is " + n);
        return n + sigma(n + 1);
    }

    public static void main(String[] args) throws Exception {
        new Thread(() -> sigma(1)).start();
        System.in.read();
        System.out.println(value);
    }

    @Override
    public void accept(String s) {

    }
}
