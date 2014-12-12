package cwd.ta.app.analyzer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestIdentityAnalyzer
{
    
    private String text = "This is my text";
    private IdentityAnalyzer analyzer = null;

    @Before
    public void setup()
    {
        analyzer = new IdentityAnalyzer();
    }

    @Test
    public void testCharCount()
    {
        Analysis results = analyzer.analyze(text);
        String identityText = results.getAnalysisFor(IdentityAnalyzer.ORIGINAL_TEXT_KEY);
        assertThat(identityText, is(text));
    }

}
