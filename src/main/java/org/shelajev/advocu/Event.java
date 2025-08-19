package org.shelajev.advocu;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Event {
    public String title;
    public String description;
    public List<String> tags;
    public String activityUrl;
    public Dates dates;
    public String type;
    public String format;
    public String duration;
    public String additionalInfo;
    public Metrics metrics;
    @JsonProperty("private")
    public boolean isPrivate;

    public static class Dates {
        public String start;
        public String end;
    }

    public static class Metrics {
        public int attendees;
    }
}
