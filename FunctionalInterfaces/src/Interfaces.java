import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.function.*;

public class Interfaces {


    public static void main(String[] args){

        /*
        Supplier
        supply object without input, for factories for example
         */
        Supplier<ArrayList<String>> s1 = () -> new ArrayList<String>();
        Supplier<ArrayList<String>> s2 = () -> new ArrayList<>();
        Supplier<ArrayList<String>> s3 = ArrayList::new;
        s1.get().add("supply");

        /*
        Consumer / biconsumer
        when you want to do something with parameter(s) but don't need to return anything, for example printing
         */
        //consumer
        Consumer<Object> c1 = x -> System.out.println(x);
        Consumer<Object> c2 = System.out::println;
        //biconsumer
        var map = new HashMap<Integer, String>();
        BiConsumer<Integer, String> c3 = (k,v) -> map.put(k, v);
        BiConsumer<Integer, String> c4 = map::put;
        c3.accept(3, "three");
        c1.accept(map);

        /*
        Predicate
         */
        Predicate<String> p1 = x -> x.isEmpty();
        Predicate<String> p2 = String::isEmpty;
        BiPredicate<String, String> p3 = (x, y) -> x.startsWith(y);

        //java heeft automatic boxing en unboxing van primitive types
        c1.accept(false);
        c1.accept(Boolean.FALSE);

        c1.accept(p1.test(""));
        c1.accept(p3.test("hoi hallo", "hoi"));

        Predicate<String> isEgg = x -> x.toLowerCase().contains("egg");
        Predicate<String> isBrown = x -> x.toLowerCase().contains("brown");
        String brownEgg = "brown egg";
        String whiteEgg = "white egg egg";
        c1.accept(isEgg.and(isBrown).test(brownEgg));
        c1.accept(isEgg.and(isBrown).test(whiteEgg));
        c1.andThen(c2).accept("hoi");

    }
}
