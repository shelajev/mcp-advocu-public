package org.shelajev.advocu;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Resources {
    public String title;
    public String description;
    public List<String> tags;
    public String activityUrl;
    public String activityDate;
    public Metrics metrics;
    public String contentType;
    public String additionalInfo;
    @JsonProperty("private")
    public boolean isPrivate;

    public static class Metrics {
        public int views;
    }
}
