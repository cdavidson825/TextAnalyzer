package cwd.ta.app.analyzer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SummaryAnalyzer implements IAnalyzer
{

    public static final String TOTAL_NON_SPACE_CHARACTERS_KEY = "TOTAL_CHARACTERS";
    public static final String TOTAL_WORDS_KEY = "TOTAL_WORDS";

    @Override
    public Analysis analyze(String input)
    {

        Map<String, String> analysis = new HashMap<String, String>();
        analysis.put(TOTAL_NON_SPACE_CHARACTERS_KEY,
                Integer.toString(input.replaceAll("\\s", "").length()));
        analysis.put(TOTAL_WORDS_KEY, Integer.toString(Arrays.asList(input.split(" ")).size()));
        Analysis result = new Analysis(this.getClass().getName(), analysis);

        return result;
    }

}
