import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        Stream<Double> randoms = Stream.generate(() -> Math.random());
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
//        oddNumbers.forEach(x -> System.out.println(x));

        Consumer<Object> printer = x -> System.out.println(x);

        //start iteration value, stopping predicate, modification of each number
        Stream<Integer> counter = Stream.iterate(0, n -> n < 100, n -> n + 1);
        printer.accept(counter.count());

        Supplier<Stream<Integer>> countStreamSupplier = () -> Stream.iterate(0, n -> n < 100, n -> n + 1);
        Supplier<Stream<Double>> randomStreamSupplier = () -> {
            return Stream.generate(() -> Math.random()).limit(100);
        };
        printer.accept(randomStreamSupplier.get().min((x, y) -> Double.compare(x, y)).get());
        printer.accept(randomStreamSupplier.get().min(Double::compare).get());
        printer.accept(randomStreamSupplier.get().min(Comparator.comparingDouble(x -> x)).get());
        Optional<Double> min = randomStreamSupplier.get().min(Comparator.comparingDouble(x -> x));
        printer.accept(min.isPresent() ? min.get() : "No minimum found!");

        Supplier<Stream<String>> testSupplier = () -> Stream.of("aapje", "gorila", "baardaap");
        Stream<String> printStream = Stream.generate(() -> {
            //first answer not promised but practially always happens
            Optional<String> answer = testSupplier.get().findAny();
            return answer.orElse("No answer found!");
        }).limit(2);
        printStream.forEach(printer);

        printer.accept(countStreamSupplier.get().reduce(0, (x, y) -> x + y));
        printer.accept(countStreamSupplier.get().reduce(0, Integer::sum));

        for (int i = 0; i < 1; i++) {
            Stream<String> stream = Stream.of("h", "a", "ll", "o");
            String len = stream.reduce("", (x, y) -> x + " - " +  y, String::concat);
            System.out.println(len);
        }
    }
}
