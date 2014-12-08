package cwd.ta.app;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class TextAnalyzerAppTest
{

    TextAnalyzerApp app = null;

    @Before
    public void setUp() throws Exception
    {
        app = new TextAnalyzerApp();
    }

    @Test
    public void canaryTest()
    {
        assertThat(TextAnalyzerApp.class.getName(), is(app.getName()));
    }

}
