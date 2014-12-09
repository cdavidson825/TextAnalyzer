package cwd.ta.app.analyzer;

public interface IAnalyzer
{
    public default String getAnalyzerName() { return this.getClass().getSimpleName(); }
    public Analysis analyze(String input);
}
