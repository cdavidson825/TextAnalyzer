package cwd.ta.app.health;

import com.codahale.metrics.health.HealthCheck;

public class TextAnalyzerHealthCheck extends HealthCheck{

    private final String defaultText;

    public TextAnalyzerHealthCheck(String defaultText) {
        this.defaultText = defaultText;
    }

    @Override
    protected Result check() throws Exception {
        if (defaultText.isEmpty()) {
            return Result.unhealthy("defaultText not provided");
        }
        return Result.healthy();
    }

}
