package cwd.ta.app.health;

import com.codahale.metrics.health.HealthCheck;

import cwd.ta.app.TextAnalyzerConfig;

public class TextAnalyzerHealthCheck extends HealthCheck
{
    private final TextAnalyzerConfig config;

    public TextAnalyzerHealthCheck(TextAnalyzerConfig config)
    {
        this.config = config;
    }

    @Override
    protected Result check() throws Exception
    {   
        return Result.healthy();
    }

}
