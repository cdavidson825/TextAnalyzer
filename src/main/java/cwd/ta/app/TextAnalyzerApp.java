package cwd.ta.app;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import cwd.ta.app.health.TextAnalyzerHealthCheck;

public class TextAnalyzerApp extends Application<TextAnalyzerConfiguration> {

    public static void main(String[] args) throws Exception {
        new TextAnalyzerApp().run(args);
    }
	
	@Override
	public String getName() {
		return this.getClass().getName();
	}

	@Override
	public void initialize(Bootstrap<TextAnalyzerConfiguration> bootstrap) {

	}

	@Override
	public void run(TextAnalyzerConfiguration configuration,
			Environment environment) throws Exception {
		final TextAnalyzerResource resource = new TextAnalyzerResource(configuration.getDefaultText());
		final TextAnalyzerHealthCheck healthCheck = new TextAnalyzerHealthCheck(configuration.getDefaultText());
		environment.healthChecks().register("defaultText", healthCheck);
		environment.jersey().register(resource);

	}

}
