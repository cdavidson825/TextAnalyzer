package cwd.ta.app.analyzer;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class TestSummaryAnalyzer
{

    private String text = "This is my text";
    private SummaryAnalyzer analyzer = null;

    @Before
    public void setup()
    {
        analyzer = new SummaryAnalyzer();
    }

    @Test
    public void testCharCount()
    {
        Analysis results = analyzer.analyze(text);
        String totalCharacters = results.getAnalysisFor(SummaryAnalyzer.TOTAL_CHARACTERS_KEY);
        assertThat(Integer.parseInt(totalCharacters), is(15));
    }

    @Test
    public void testWordCount()
    {
        Analysis results = analyzer.analyze(text);
        String totalWords = results.getAnalysisFor(SummaryAnalyzer.TOTAL_WORDS_KEY);
        assertThat(Integer.parseInt(totalWords), is(4));
    }
}
