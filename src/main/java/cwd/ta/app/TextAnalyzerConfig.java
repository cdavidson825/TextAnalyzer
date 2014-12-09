package cwd.ta.app;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class TextAnalyzerConfig extends Configuration
{

    @NotEmpty
    private String defaultText;

    @JsonProperty
    public String getDefaultText()
    {
        return defaultText;
    }

    @JsonProperty
    public void setDefaultText(String text)
    {
        this.defaultText = text;
    }

}
