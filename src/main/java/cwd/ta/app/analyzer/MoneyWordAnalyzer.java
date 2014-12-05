package cwd.ta.app.analyzer;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoneyWordAnalyzer implements IAnalyzer {

	public static final String DOLLAR_WORDS_KEY = "DOLLAR_WORDS";
	
	@SuppressWarnings("serial")
	private final Map<Character, Integer> charCostMap = new HashMap<Character, Integer>() {
		{
			put('A', 1);
			put('B', 2);
			put('C', 3);
			put('D', 4);
			put('E', 5);
			put('F', 6);
			put('G', 7);
			put('H', 8);
			put('I', 9);
			put('J', 10);
			put('K', 11);
			put('L', 12);
			put('M', 13);
			put('N', 14);
			put('O', 15);
			put('P', 16);
			put('Q', 17);
			put('R', 18);
			put('S', 19);
			put('T', 20);
			put('U', 21);
			put('V', 22);
			put('W', 23);
			put('X', 24);
			put('Y', 25);
			put('Z', 26);
		}
	};

	public Analysis analyze(String input) {
		List<String> words = Arrays.asList(input.split(" "));
		List<String> dollarWords = words
				.stream().map(w -> wordCost(w))
				.filter(c -> c.getValue() == 100)
				.map(c -> c.getKey())
				.collect(Collectors.toList());
		Map<String, String> analysis = new HashMap<String, String>();
		analysis.put(DOLLAR_WORDS_KEY, dollarWords.toString());
		Analysis result = new Analysis(this.getClass().getName(), analysis);
		return result;
	}

	protected SimpleImmutableEntry<String, Integer> wordCost(String word) {
		Integer cost = word.toUpperCase().chars().mapToObj(i -> (char) i)
				.filter(c -> charCostMap.containsKey(c))
				.mapToInt(c -> charCostMap.get(c)).sum();
		return (new SimpleImmutableEntry<String, Integer>(word, cost));
	}
}
