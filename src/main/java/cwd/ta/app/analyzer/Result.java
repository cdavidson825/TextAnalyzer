package cwd.ta.app.analyzer;

import java.util.Map;

public class Result {
	
	final private String analyzerName;
	final private Map<String, String> analysisMap;
	
	public Result(String analyzerName, Map<String, String> analysisMap)
	{
		this.analyzerName = analyzerName;
		this.analysisMap = analysisMap;
	}
	
	public String getAnalyzerName() {
		return analyzerName;
	}

	public Map<String, String> getAnalysisMap() {
		return analysisMap;
	}
	
	//TODO make return Optional
	public String getAnalysisFor(String key)
	{
		return analysisMap.get(key);
	}
	
}
