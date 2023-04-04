package by.konanaw.features.preview.java19;

import java.util.concurrent.ExecutionException;

public class Main {

    private static StructuredConcurrencyProcessor structuredConcurrencyProcessor;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Hello world!");
        System.out.println("¯\\_(ツ)_/¯");

        structuredConcurrencyProcessor = new StructuredConcurrencyProcessor();
        //
        structuredConcurrencyProcessor.runSuccess();
        //
        System.out.println("***** running with throw *****");
        //
        structuredConcurrencyProcessor.runFail();

    }
}