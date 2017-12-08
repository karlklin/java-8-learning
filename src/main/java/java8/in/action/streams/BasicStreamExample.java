package java8.in.action.streams;

import java8.in.action.streams.model.Trader;
import java8.in.action.streams.model.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class BasicStreamExample {

	// TODO performance boxing

	/**
	 * 1. {@link java.util.stream.Stream#filter(Predicate) and {@link java.util.stream.Stream#sorted(Comparator)} example using {@link Comparator#comparingInt(java.util.function.ToIntFunction)}
	 * 2. {@link java.util.stream.Stream#distinct()} example
	 * 3. {@link java.util.stream.Stream#sorted(Comparator)} example using {@link Comparator#comparing(Function)}
	 * 4. {@link java.util.stream.Stream#collect(Collectors)} example using {@link Collectors#joining(CharSequence)}
	 * 5. {@link java.util.stream.Stream#findAny()} and {@link java.util.stream.Stream#anyMatch(Predicate)} example
	 * 6. {@link java.util.stream.Stream#mapToInt(java.util.function.ToIntFunction)} and {@link java.util.stream.IntStream#max()}
	 */
	public static void main(String[] args) {
		List<Transaction> transactions = Transaction.getTransactions();

		// 1. find all transactions in 2011 sort by value
		transactions.stream()
				.filter(transaction -> transaction.getYear() == 2011)
				.sorted(comparingInt(Transaction::getValue))
				.forEach(System.out::println);

		// 2. what are unique cities
		transactions.stream()
				.map(transaction -> transaction.getTrader().getCity())
				.distinct()
				.forEach(System.out::println);

		// 3. find all traders from Cambridge and sort them name
		transactions.stream()
				.map(Transaction::getTrader)
				.filter(trader -> trader.getCity().equals("Cambridge"))
				.distinct()
				.sorted(comparing(Trader::getCity))
				.forEach(System.out::println);

		// 4. return a string of all traders' names sorted alphabetically
		String traders = transactions.stream()
				.map(transaction -> transaction.getTrader().getName())
				.sorted()
				.distinct()
				.collect(Collectors.joining(","));
		System.out.println(traders);

		// 5. are any traders based in Milan?
		transactions.stream()
				.filter(transaction -> transaction.getTrader().getCity().equals("Milan"))
				.findAny();

		transactions.stream()
				.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

		// 6. what is the highest value of all transaction
		Optional<Transaction> maxValue = transactions.stream()
				.max(Comparator.comparingInt(Transaction::getValue));

		transactions.stream()
				.map(transaction -> transaction.getValue())
				.reduce(Integer::max);

		transactions.stream()
				.mapToInt(Transaction::getValue).max();

	}

}
