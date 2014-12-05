package cwd.ta.app.analyzer;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class TestMoneyWordAnalyzer {

	MoneyWordAnalyzer analyzer = null;

	@Before
	public void setup() {
		analyzer = new MoneyWordAnalyzer();
	}

	@Test
	public void testWordValueUpper() {
		String word = "ABC";
		assertThat(analyzer.wordCost(word).getValue(), is(6));
	}

	@Test
	public void testWordValueLower() {
		String word = "abcd";
		assertThat(analyzer.wordCost(word).getValue(), is(10));
	}

	@Test
	public void testWordValueMixed() {
		String word = "abCDe";
		assertThat(analyzer.wordCost(word).getValue(), is(15));
	}

	@Test
	public void testWordValueMixedWithSpecialChars() {
		String word = "ab-.~]CDe";
		assertThat(analyzer.wordCost(word).getValue(), is(15));
	}

	@Test
	public void testWordValueWithNonEnglish() {
		String word = "abCDくるe";
		assertThat(analyzer.wordCost(word).getValue(), is(15));
	}

	@Test
	public void testAnalyze() {
		String text = "posting some text to get primary dollar words ";
		Result result = analyzer.analyze(text);
		System.out.println("results = " + result.getAnalysisMap());
		System.out.println("dollarWords lookup = "
				+ result.getAnalysisFor(MoneyWordAnalyzer.DOLLAR_WORDS_KEY));

	}

}