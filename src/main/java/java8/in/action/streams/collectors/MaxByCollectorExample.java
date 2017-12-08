package java8.in.action.streams.collectors;

import java8.in.action.streams.model.Transaction;

import java.util.Optional;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.maxBy;
import static java8.in.action.streams.model.Transaction.getTransactions;

public class MaxByCollectorExample {

    @SuppressWarnings({"ComparatorCombinators", "SimplifyStreamApiCallChains"})
    public static void main(String[] args) {

        // implementing bespoke reduce, of course too verbose
        Optional<Transaction> maxTransaction = getTransactions().stream()
                .reduce((t1, t2) -> t2.getValue() > t1.getValue() ? t2 : t1);
        System.out.println(maxTransaction.get());

        // implementing bespoke comparator, of course too verbose as well
        Optional<Transaction> maxTransaction2 = getTransactions().stream()
                .collect(maxBy((t1, t2) -> t1.getValue() - t2.getValue()));
        System.out.println(maxTransaction2.get());

        // the best using predefined int comparator
        Optional<Transaction> maxTransaction3 = getTransactions().stream()
                .collect(maxBy(comparingInt(Transaction::getValue)));
        System.out.println(maxTransaction3.get());

        // also very good using map to int and straight max TODO performance to be checked
        getTransactions().stream().mapToInt(Transaction::getValue).max();

    }
}
