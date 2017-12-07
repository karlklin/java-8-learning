package java8.in.action.streams;

import java8.in.action.example.trader.Trader;
import java8.in.action.example.trader.Transaction;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class BasicStreamExample {

	public static void main(String[] args) {
		List<Transaction> transactions = Transaction.getTransactions();

		// 1. find all transactions in 2011 sort by value
		transactions.stream().filter(t -> t.getYear() == 2011).sorted(comparing(Transaction::getValue))
				.forEach(System.out::println);

		// 2. what are unique cities
		transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct()
				.forEach(System.out::println);

		// 3. find all traders from Cambridge and sort them name
		transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge"))
				.distinct().sorted(comparing(Trader::getName)).forEach(System.out::println);

		// 4. return a string of all traders' names sorted alphabetically
		String traders = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted()
				.collect(joining(", "));
		System.out.println(traders);

		// 5. are any traders based in Milan?
		boolean anyTranderBasedInMilan = transactions.stream()
				.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		System.out.println(anyTranderBasedInMilan);

		// 6. print all transaction's values from traders living in Cambridge
		transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue).forEach(System.out::println);

		// 7. what is the highest value of all transaction
		Optional<Integer> maxValue = transactions.stream().map(Transaction::getValue)
				.reduce(Integer::max);
		System.out.println("Max=" + maxValue);

		OptionalInt max = transactions.stream().mapToInt(Transaction::getValue).max();
		max.ifPresent(value -> System.out.println("Max=" + value));

		// 8. Find the transaction with the smaller value
		
//		transactions.stream().sorted
	}

}
