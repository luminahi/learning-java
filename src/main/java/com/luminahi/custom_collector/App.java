package com.luminahi.custom_collector;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import static java.util.stream.Collectors.*;

public class App {

    private static record Person(String name, int age) {
        private Person(String[] values) {
            this(values[0], Integer.parseInt(values[1]));
        }
    }

    public static class Container {
        public Container() { }
        private int min = 100;
        private int max = -100;
        private int sum = 0;
        private int count = 0;
    }

    private static record Result(int min, int max, int sum, int count) {
        @Override
        public final String toString() {
            return String.format(
                "min: %d - max: %d - sum: %d - count: %d", min, max, sum, count);
        }
    }

    public static void main(String[] args) {
        
        List<String> stringList = Arrays.asList(
            "Alex;28", 
            "Sora;18", 
            "Sara;15", 
            "Karen;17",
            "Julia;30",
            "lux;100",
            "Alex;15",
            "Sara;12"
        );

        Supplier<Container> supplier = Container::new;
        
        BiConsumer<Container, Person> accumulator = (container, person)-> {
            container.min = Math.min(container.min, person.age);
            container.max = Math.max(container.max, person.age);
            container.sum += person.age;
            System.out.println("passing by acc");
            container.count++;
        };
        
        BinaryOperator<Container> aggregator = (agg1, agg2) -> {
            System.out.println("passing by agg");
            Container container = new Container();
            container.min = Math.min(agg1.min, agg2.min);
            container.max = Math.max(agg1.max, agg2.max);
            container.sum = agg1.sum + agg2.sum;
            container.count = agg1.count + agg2.count;
            return container;
        };

        Collector<Person, Container, Result> collector = 
            Collector.of(supplier, accumulator, aggregator, 
            agg -> new Result(agg.min, agg.max, agg.sum, agg.count));
        
    
        Map<String, Result> result = 
            new TreeMap<>(stringList.stream()
            .map(line -> new Person(line.split(";")))
            .collect(groupingBy(m -> m.name(), collector)));

        result.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
