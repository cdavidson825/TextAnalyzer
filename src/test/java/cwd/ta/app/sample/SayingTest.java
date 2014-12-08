package cwd.ta.app.sample;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import cwd.ta.app.sample.Saying;

public class SayingTest
{

    Saying say = null;

    @Before
    public void init()
    {
        say = new Saying(1L, "Hello");
    }

    @Test
    public void testSayingContent()
    {
        assertThat("Hello", is(say.getContent()));
    }

    @Test
    public void testSayingId()
    {
        assertThat("WTF happened", 1L, is(say.getId()));
    }
}
