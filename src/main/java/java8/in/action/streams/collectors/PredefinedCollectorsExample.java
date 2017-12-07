package java8.in.action.streams.collectors;

import java.util.*;
import java.util.stream.Collectors;

import java8.in.action.example.trader.Transaction;

import static java.util.stream.Collectors.*;

public class PredefinedCollectorsExample {

    public static void main(String[] args) {
        List<Transaction> transactions = Transaction.getTransactions();

        // counting
        Integer count = transactions.stream().map(t -> 1).reduce(0, (a, b) -> a + 1);
        assert (count == transactions.stream().count());

        Long count2 = transactions.stream().collect(Collectors.counting());
        assert (count.intValue() == count2.intValue());

        // finding minimum and maximum
        Optional<Transaction> maxTransaction = transactions.stream()
                .reduce((t1, t2) -> t2.getValue() > t1.getValue() ? t2 : t1);
        System.out.println(maxTransaction.get());

        Comparator<Transaction> comparator = (t1, t2) -> t1.getValue() - t2.getValue();
        Optional<Transaction> maxTransaction2 = transactions.stream().collect(maxBy(comparator));
        System.out.println(maxTransaction2.get());

        Comparator<Transaction> comparator2 = Comparator.comparingInt(Transaction::getValue);
        Optional<Transaction> maxTransaction3 = transactions.stream().collect(maxBy(comparator2));
        System.out.println(maxTransaction3.get());

        Optional<Transaction> maxTransaction4 = transactions.stream().collect(maxBy(Comparator.comparing(Transaction::getValue)));
        System.out.println(maxTransaction4.get());

        // summarisation

        Optional<Integer> sum1 = transactions.stream().map(Transaction::getValue).reduce(Integer::sum);
        System.out.println(sum1.get());

        Integer sum2 = transactions.stream().collect(summingInt(Transaction::getValue));
        System.out.println(sum2);

        IntSummaryStatistics sum3 = transactions.stream().collect(Collectors.summarizingInt(Transaction::getValue));
        System.out.println(sum3.getSum());

        Integer sum4 = transactions.stream().collect(Collectors.reducing(0, Transaction::getValue, (i, j) -> i + j));
        System.out.println(sum4);

        int sum5 = transactions.stream().mapToInt(Transaction::getValue).sum();
        System.out.println(sum5);

        // joining

        String joining = transactions.stream().map(t -> t.getTrader().getName()).collect(Collectors.joining(", "));
        System.out.println(joining);

    }
}
