package nl.maarten.ocp.m4streams;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CollectExample {

    public static void main(String... args) {
        IntStream intStream = IntStream.range(1, 5);
        AtomicInteger ai = 
          intStream.parallel()
                   .collect(AtomicInteger::new,          // resultContainer
                           (a, b) -> a.set(a.get() + b), // a is resultContainer, b is waarde uit stream
                           (a, b) -> a.set(a.get() * b.get()) // combineren van containers
                                    );
        System.out.println(ai);
    }
}