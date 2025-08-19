package org.shelajev.advocu;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedbackSession {
    public String activityDate;
    public String dockerRepresentative;
    public String modeOfCommunication;
    public Metrics metrics;
    public String title;
    public String description;
    @JsonProperty("private")
    public boolean isPrivate;

    public static class Metrics {
        public int timeSpent;
    }
}
