package java8.in.action.streams.mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Interesting snippets:
 * 1) {@link Arrays#stream(Object[])} to transform arrays into stream
 * 2) combining two steams and flatting the streams
 */
public class FlatMapExample {

	public static void main(String[] args) {
		// example of return unique characters of list of Strings
		List<String> list = Arrays.asList("Hello", "World");
		
		Stream<String[]> result1 = list.stream()
				.map(word -> word.split(""));
		System.out.println(result1.distinct().collect(toList()));

		// transforming array of strings into stream
		Stream<Stream<String>> result2 = list.stream()
				.map(word -> word.split(""))
				.map(Arrays::stream);
		System.out.println(result2);

		// flatting the Stream<Stream<String>>
		Stream<String> result3 = list.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream);
		System.out.println(result3.distinct().collect(toList()));
		
		//example of return square of each number
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> squareNumbers = numbers.stream()
                .map(number -> number*number)
                .collect(toList());
		System.out.println(squareNumbers);
		
		// example of concatenate list
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(3, 4);
				
		Stream<List<Integer>> concatenateStream2 = list1.stream()
                .flatMap(i -> list2.stream().map(j -> Arrays.asList(i, j)));
		System.out.println("New way: " + concatenateStream2.collect(toList()));
		System.out.println("Old way: " + concatenateOldWay(list1, list2));
		
		// only sum divisible by 3
		Stream<List<Integer>> onlyDivisibleBy3 = list1.stream()
                .flatMap(i -> list2.stream().filter(j -> (i+j) % 3 == 0).map(j -> Arrays.asList(i, j)));
		System.out.println(onlyDivisibleBy3.collect(toList()));
	}
	
	public static List<List<Integer>> concatenateOldWay(List<Integer> list1, List<Integer> list2) {
		List<List<Integer>> result = new ArrayList<>();
		
		for (Integer i : list1) { 
			for (Integer j : list2) {
				List<Integer> pair = new ArrayList<>();
				pair.add(i);
				pair.add(j);
				result.add(pair);
			}
		}
		
		return result;
	}

}
