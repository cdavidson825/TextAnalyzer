package cwd.ta.app.view;

import io.dropwizard.views.View;

import java.util.List;

import cwd.ta.app.analyzer.Analysis;

public class AnalysisView extends View 
{
    private final List<Analysis> analysisList;;

    public AnalysisView(String templateName, List<Analysis> analysisList ) {
        super(templateName);
        this.analysisList = analysisList;
    }

    public List<Analysis> getAnalysisList()
    {
        return(analysisList);
    }
    

}
