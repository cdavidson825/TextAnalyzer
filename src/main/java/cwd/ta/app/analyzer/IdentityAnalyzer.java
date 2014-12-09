package cwd.ta.app.analyzer;

import java.util.HashMap;
import java.util.Map;

public class IdentityAnalyzer  implements IAnalyzer
{
    
    public static final String ORIGINAL_TEXT_KEY = "ORIGINAL_TEXT";

    @Override
    public Analysis analyze(String input)
    {

        Map<String, String> analysis = new HashMap<String, String>();

        analysis.put(ORIGINAL_TEXT_KEY, input);
        Analysis result = new Analysis(this.getClass().getName(), analysis);

        return result;
    }
}
