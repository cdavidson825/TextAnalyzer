package cwd.ta.app;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import cwd.ta.app.analyzer.Analysis;
import cwd.ta.app.analyzer.MoneyWordAnalyzer;
import cwd.ta.app.analyzer.SummaryAnalyzer;

@Path("/text-analyzer")
@Produces(MediaType.APPLICATION_JSON)
public class TextAnalyzerResource
{
    private final TextAnalyzerConfiguration config;

    public TextAnalyzerResource(TextAnalyzerConfiguration config)
    {
        this.config = config;
    }

    @GET
    @Timed
    public List<Analysis> analyze(@QueryParam("text") Optional<String> text)
    {
        List<Analysis> analysisList = new ArrayList<Analysis>();
        analysisList.add(new SummaryAnalyzer().analyze(text.or(config.getDefaultText())));
        analysisList.add(new MoneyWordAnalyzer().analyze(text.or(config.getDefaultText())));
        
        return (analysisList);
    }
}
