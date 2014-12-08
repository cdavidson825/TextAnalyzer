package cwd.ta.app.health;

import com.codahale.metrics.health.HealthCheck;

import cwd.ta.app.TextAnalyzerConfiguration;

public class TextAnalyzerHealthCheck extends HealthCheck
{
    private final TextAnalyzerConfiguration config;

    public TextAnalyzerHealthCheck(TextAnalyzerConfiguration config)
    {
        this.config = config;
    }

    @Override
    protected Result check() throws Exception
    {   
        return Result.healthy();
    }

}
