package java8.in.action.streams.mapping;

import java8.in.action.streams.model.Transaction;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;


class Aggregator {
    private long value;

    public void increment (){
        value++;
    }

    public long getValue() {
        return value;
    }

    public Aggregator increment (Aggregator aggregator) {
        value+= aggregator.getValue();

        return this;
    }
}

public class MyCountingCollector<T> implements Collector<T, Aggregator, Long> {

    @Override
    public Supplier<Aggregator> supplier() {
        return Aggregator::new;
    }

    @Override
    public BiConsumer<Aggregator, T> accumulator() {
        return (a, t) -> a.increment();
    }

    @Override
    public BinaryOperator<Aggregator> combiner() {
        return (a1, a2) -> a1.increment(a2);
    }

    @Override
    public Function<Aggregator, Long> finisher() {
        return a -> a.getValue();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.CONCURRENT, Characteristics.UNORDERED));
    }

    public static void main(String[] args) {
        Long countByPredefinedCollector = Transaction.getTransactions().stream().collect(Collectors.counting());
        Long countByMyCollector = Transaction.getTransactions().stream().collect(new MyCountingCollector<>());

        System.out.println(countByPredefinedCollector);
        System.out.println(countByMyCollector);
    }
}
