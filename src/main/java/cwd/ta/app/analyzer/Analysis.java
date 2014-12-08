package cwd.ta.app.analyzer;

import java.util.Map;

public class Analysis
{

    final private String analyzerName;
    final private Map<String, String> analysisMap;

    public Analysis(String analyzerName, Map<String, String> analysisMap)
    {
        this.analyzerName = analyzerName;
        this.analysisMap = analysisMap;
    }

    public String getAnalyzerName()
    {
        return analyzerName;
    }

    public Map<String, String> getAnalysisMap()
    {
        return analysisMap;
    }

    // TODO make return Optional
    public String getAnalysisFor(String key)
    {
        return analysisMap.get(key);
    }

}
