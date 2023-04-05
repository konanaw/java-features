package by.konanaw.features.incubator.structured_concurrency;

import jdk.incubator.concurrent.StructuredTaskScope;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class StructuredConcurrencyProcessor {

    public void runSuccess() throws InterruptedException, ExecutionException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<String> user = scope.fork(() -> findUser());
            Future<Integer> order = scope.fork(() -> fetchOrder());

            scope.join();           // Join both forks
            scope.throwIfFailed();  // ... and propagate errors

            Response response = new Response(user.resultNow(), order.resultNow());
            System.out.println(response);

//            System.out.println(String.format("User %s, order %s", user.resultNow(), order.resultNow()));
        }
    }

    public void runFail() throws InterruptedException, ExecutionException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<String> user = scope.fork(() -> findUserFail());
            Future<Integer> order = scope.fork(() -> fetchOrder());

            scope.join();           // Join both forks
            scope.throwIfFailed();  // ... and propagate errors

            Response response = new Response(user.resultNow(), order.resultNow());
            System.out.println(response);

//            System.out.println(String.format("User %s, order %s", user.resultNow(), order.resultNow()));
        }
    }

    private String findUser() throws InterruptedException {
        System.out.println("findUser started");
        Thread.sleep(Duration.ofMillis(300));
        System.out.println("findUser completed");
        return "Konanaw";
    }

    private String findUserFail() throws InterruptedException {
        System.out.println("findUser started");
        Thread.sleep(Duration.ofMillis(300));
        throw new RuntimeException("Boom!");
    }

    private Integer fetchOrder() throws InterruptedException {
        System.out.println("fetchOrder started");
        Thread.sleep(Duration.ofMillis(700));
        System.out.println("fetchOrder completed");
        return 123;
    }
}

record Response(String user, Integer order) {
}
