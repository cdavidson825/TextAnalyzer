package cwd.ta.app;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import cwd.ta.app.health.TextAnalyzerHealthCheck;
import cwd.ta.app.resource.TextAnalyzerResource;

public class TextAnalyzerApp extends Application<TextAnalyzerConfig>
{

    public static void main(String[] args) throws Exception
    {
        new TextAnalyzerApp().run(args);
    }

    @Override
    public String getName()
    {
        return this.getClass().getName();
    }

    @Override
    public void initialize(Bootstrap<TextAnalyzerConfig> bootstrap)
    {
        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(new AssetsBundle());
    }

    @Override
    public void run(TextAnalyzerConfig configuration, Environment environment)
            throws Exception
    {
        final TextAnalyzerResource resource =
                new TextAnalyzerResource(configuration);
        final TextAnalyzerHealthCheck healthCheck =
                new TextAnalyzerHealthCheck(configuration);
        environment.healthChecks().register("AppHealthCheck", healthCheck);
        environment.jersey().register(resource);

    }

}
