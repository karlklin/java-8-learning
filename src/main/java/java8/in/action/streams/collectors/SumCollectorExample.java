package java8.in.action.streams.collectors;

import java8.in.action.streams.model.Transaction;

import java.util.IntSummaryStatistics;
import java.util.Optional;

import static java.util.stream.Collectors.*;
import static java8.in.action.streams.model.Transaction.getTransactions;

public class SumCollectorExample {

    @SuppressWarnings("SimplifyStreamApiCallChains")
    public static void main(String[] args) {
        // using bespoke reduce, too verbose
        Integer sum = getTransactions().stream()
                .collect(reducing(0, Transaction::getValue, (i, j) -> i + j));
        System.out.println(sum);

        // using bespoke reduce, too verbose
        Optional<Integer> sum1 = getTransactions().stream()
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println(sum1.get());

        // using predefined summingInt collector, also too verbose
        Integer sum2 = getTransactions().stream()
                .collect(summingInt(Transaction::getValue));
        System.out.println(sum2);

        // using summarizingInt predefined collector, only good if you need to aggregate more then sum
        IntSummaryStatistics sum3 = getTransactions().stream()
                .collect(summarizingInt(Transaction::getValue));
        System.out.println(sum3.getSum());

        // the best using map to int and sum
        int sum5 = getTransactions().stream().mapToInt(Transaction::getValue).sum();
        System.out.println(sum5);

    }
}
