package org.shelajev.advocu;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PublicSpeaking {
    public String title;
    public String description;
    public List<String> tags;
    public String activityUrl;
    public String activityDate;
    public String format;
    public int duration;
    public String additionalInfo;
    public Metrics metrics;
    @JsonProperty("private")
    public boolean isPrivate;

    public static class Metrics {
        public int attendees;
    }
}
