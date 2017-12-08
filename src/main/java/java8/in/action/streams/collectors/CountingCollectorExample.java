package java8.in.action.streams.collectors;

import java.util.stream.Collectors;

import static java8.in.action.streams.model.Transaction.getTransactions;

public class CountingCollectorExample {

    public static void main(String[] args) {
        // counting by using bespoke reduce, of course not very nice way
        Integer countByUsingReduce = getTransactions().stream().map(t -> 1).reduce(0, (a, b) -> a + 1);

        // also could be better
        Long countByUsingCollector = getTransactions().stream().collect(Collectors.counting());

        // the best
        long countByUsingPredefinedCount = getTransactions().stream().count();

        assert (countByUsingReduce.longValue() == countByUsingPredefinedCount);
        assert (countByUsingReduce.intValue() == countByUsingCollector.intValue());
    }
}
