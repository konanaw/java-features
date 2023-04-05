package by.konanaw.features.incubator.structured_concurrency;

import java.util.concurrent.ExecutionException;

public class Main {

    private static StructuredConcurrencyProcessor structuredConcurrencyProcessor;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Hello world!");

        structuredConcurrencyProcessor = new StructuredConcurrencyProcessor();

        runSuccess();
        // or
        runFail();

    }

    private static void runSuccess() throws InterruptedException, ExecutionException {
        System.out.println("***** run successfully *****");
        structuredConcurrencyProcessor.runSuccess();
    }

    private static void runFail() throws InterruptedException, ExecutionException {
        System.out.println("***** running with exception *****");
        structuredConcurrencyProcessor.runFail();
    }
}