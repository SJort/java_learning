package animal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));


        print(animals, animal -> animal.isCanHop());
    }

    private static void print(List<Animal> animals, Predicate<Animal> trackChecker){
        Consumer<String> consolePrint = str -> System.out.print(str);
        for (Animal animal : animals){
            if (trackChecker.test(animal)){
                consolePrint.accept(animal.getSpecies() + " ");
            }
            consolePrint.accept("\n");
        }
    }
}
