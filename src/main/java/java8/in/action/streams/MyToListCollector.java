package java8.in.action.streams;

import java8.in.action.streams.model.Transaction;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collectors.toList;

public class MyToListCollector<E> implements Collector<E, List<E>, List<E>> {

    @Override
    public Supplier<List<E>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<E>, E> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<E>> combiner() {
        return (es, es2) -> {
            es.addAll(es2);
            return es;
        };
    }

    @Override
    public Function<List<E>, List<E>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }

    public static <T> MyToListCollector<T> myToListCollector() {
        return new MyToListCollector<>();
    }

    public static void main(String[] args) {
        List<Transaction> transactionsByCollector = Transaction.getTransactions().stream().collect(myToListCollector());
        System.out.println(transactionsByCollector);

        List<Transaction> transactionsByPredefinedCollector = Transaction.getTransactions().stream().collect(toList());
        System.out.println(transactionsByPredefinedCollector);

        System.out.println(transactionsByCollector.equals(transactionsByPredefinedCollector));
    }

}

