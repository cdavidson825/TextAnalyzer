package cwd.ta.app;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TextAnalyzerApp extends Application<TextAnalyzerConfiguration> {

	@Override
	public String getName() {
		return this.getClass().getName();
	}

	@Override
	public void initialize(Bootstrap<TextAnalyzerConfiguration> bootstrap) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void run(TextAnalyzerConfiguration configuration,
			Environment environment) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
