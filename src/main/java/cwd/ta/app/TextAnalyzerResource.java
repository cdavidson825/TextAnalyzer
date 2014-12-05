package cwd.ta.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import cwd.ta.app.analyzer.Analysis;
import cwd.ta.app.analyzer.SummaryAnalyzer;

@Path("/text-analyzer")
@Produces(MediaType.APPLICATION_JSON)
public class TextAnalyzerResource {

	private final String defaultText;
    public TextAnalyzerResource(String defaultText) {
		this.defaultText = defaultText;
    }
    
    @GET
    @Timed
    public String analyze(@QueryParam("text") Optional<String> text)
    {
    	Analysis summaryAnalysis = new SummaryAnalyzer().analyze(text.or(defaultText));
    	summaryAnalysis.getAnalysisMap();
    	return(summaryAnalysis.getAnalysisMap().toString());
    }
}
