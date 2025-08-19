package org.shelajev.advocu;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Amplification {
    public String activityDate;
    public Metrics metrics;
    public String title;
    public String description;
    public List<String> type;
    public List<String> channel;
    public String url;
    @JsonProperty("private")
    public boolean isPrivate;

    public static class Metrics {
        public int views;
    }
}
