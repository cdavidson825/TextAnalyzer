package cwd.ta.app.resource;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import cwd.ta.app.TextAnalyzerConfig;
import cwd.ta.app.analyzer.Analysis;
import cwd.ta.app.analyzer.IdentityAnalyzer;
import cwd.ta.app.analyzer.MoneyWordAnalyzer;
import cwd.ta.app.analyzer.SummaryAnalyzer;
import cwd.ta.app.view.AnalysisView;

@Path("/text-analyzer")
@Produces(MediaType.APPLICATION_JSON)
public class TextAnalyzerResource
{
    private final TextAnalyzerConfig config;
    private final static Logger logger = LoggerFactory.getLogger(TextAnalyzerResource.class);

    public TextAnalyzerResource(TextAnalyzerConfig config)
    {
        this.config = config;
    }

    @GET
    @Timed
    public List<Analysis> analyzeViaGet(@QueryParam("text") Optional<String> text)
    {
        logger.info("Inside analyzeViaGet");
        return (analyze(text.or(config.getDefaultText())));
    }
    
    @POST
    @Timed
    public List<Analysis> analyzeViaPost(@FormParam("text") String text)
    {
        logger.info("Inside analyzeViaPost");
        if(text == null || text.isEmpty())
        {
            text = config.getDefaultText();
        }
        return (analyze(text));
    }
    
    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public AnalysisView analyzeViaGetWithView(@QueryParam("text") Optional<String> text)
    {
        logger.info("Inside analyzeViaGetWithView");
        List<Analysis> analysisList = analyze(text.or(config.getDefaultText()));
        String viewTemplateName="analysis.ftl";
        return (new AnalysisView(viewTemplateName, analysisList));
    }
    
    private List<Analysis> analyze(String text)
    {
        List<Analysis> analysisList = new ArrayList<Analysis>();
        analysisList.add(new IdentityAnalyzer().analyze(text));
        analysisList.add(new SummaryAnalyzer().analyze(text));
        analysisList.add(new MoneyWordAnalyzer().analyze(text));
        
        return (analysisList);
    }
    
}
    
