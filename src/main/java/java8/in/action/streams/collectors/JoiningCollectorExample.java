package java8.in.action.streams.collectors;

import static java.util.stream.Collectors.joining;
import static java8.in.action.streams.model.Transaction.getTransactions;

public class JoiningCollectorExample {

    public static void main(String[] args) {
        String joining = getTransactions().stream()
                .map(t -> t.getTrader().getName())
                .collect(joining(", "));

        System.out.println(joining);
    }
}
