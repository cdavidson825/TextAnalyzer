package cwd.ta.app.analyzer;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class TestDollarWordAnalyzer
{

    //dollar words = Wednesday, pumpkin, and telephone
    private static final String dollarWordText = "On Wednesday, we will be eating pumpkin and talking on the telephone.";
    
    private DollarWordAnalyzer analyzer = null;

    @Before
    public void setup()
    {
        analyzer = new DollarWordAnalyzer();
    }

    @Test
    public void testWordValueUpper()
    {
        String word = "ABC";
        assertThat(analyzer.wordCost(word).getValue(), is(6));
    }

    @Test
    public void testWordValueLower()
    {
        String word = "abcd";
        assertThat(analyzer.wordCost(word).getValue(), is(10));
    }

    @Test
    public void testWordValueMixed()
    {
        String word = "abCDe";
        assertThat(analyzer.wordCost(word).getValue(), is(15));
    }

    @Test
    public void testWordValueMixedWithSpecialChars()
    {
        String word = "ab-.~]CDe";
        assertThat(analyzer.wordCost(word).getValue(), is(15));
    }

    @Test
    public void testWordValueWithNonEnglish()
    {
        String word = "abCDくるe";
        assertThat(analyzer.wordCost(word).getValue(), is(15));
    }

    @Test
    public void testDollarWordsExtracted()
    {
        Analysis result = analyzer.analyze(dollarWordText);
        assertThat(result.getAnalysisFor(DollarWordAnalyzer.DOLLAR_WORDS_KEY),
                is("[Wednesday, telephone, pumpkin]"));
    }

    @Test
    public void testTotalCost()
    {
        Analysis result = analyzer.analyze(dollarWordText);
        assertThat(result.getAnalysisFor(DollarWordAnalyzer.TOTAL_COST_TOTAL_KEY),
                is("$6.31"));
    }

}
