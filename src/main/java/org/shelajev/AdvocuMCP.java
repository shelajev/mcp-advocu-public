package org.shelajev;

import io.quarkiverse.mcp.server.TextContent;
import io.quarkiverse.mcp.server.Tool;
import io.quarkiverse.mcp.server.ToolArg;
import io.quarkiverse.mcp.server.ToolResponse;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.shelajev.advocu.*;
import org.shelajev.advocu.api.AdvocuApiClient;
import org.shelajev.advocu.api.AdvocuSubmissionApiClient;

@Singleton
public class AdvocuMCP {

    @Inject
    @RestClient
    AdvocuApiClient advocuApiClient;

    @Inject
    @RestClient
    AdvocuSubmissionApiClient submissionApiClient;

    @ConfigProperty(name = "advocu.submission.id")
    String submissionId;

    @Tool(description = "Submit a feedback session to Advocu.")
    ToolResponse feedbackSession(
            @ToolArg(description = "Date of the feedback session (YYYY-MM-DD)") String activityDate,
            @ToolArg(description = "Docker representative") String dockerRepresentative,
            @ToolArg(description = "Mode of communication") String modeOfCommunication,
            @ToolArg(description = "Approximate time spent (in minutes)") int timeSpent,
            @ToolArg(description = "Docker feature discussed") String title,
            @ToolArg(description = "Key feedback points discussed") String description,
            @ToolArg(description = "Make this activity private?") boolean isPrivate
    ) {
        FeedbackSession session = new FeedbackSession();
        session.activityDate = activityDate;
        session.dockerRepresentative = dockerRepresentative;
        session.modeOfCommunication = modeOfCommunication;
        session.metrics = new FeedbackSession.Metrics();
        session.metrics.timeSpent = timeSpent;
        session.title = title;
        session.description = description;
        session.isPrivate = isPrivate;

        String response = advocuApiClient.submitFeedbackSession(session);
        return ToolResponse.success(new TextContent("Successfully submitted feedback session: " + response));
    }

    @Tool(description = "Submit a resource to Advocu.")
    ToolResponse resources(
            @ToolArg(description = "Name of your project") String title,
            @ToolArg(description = "What is this resource about?") String description,
            @ToolArg(description = "Link to the resource") String activityUrl,
            @ToolArg(description = "Date published (YYYY-MM-DD)") String activityDate,
            @ToolArg(description = "How many people has seen your content?") int views,
            @ToolArg(description = "Content type") String contentType,
            @ToolArg(description = "Make this activity private?") boolean isPrivate
    ) {
        Resources resource = new Resources();
        resource.title = title;
        resource.description = description;
        resource.activityUrl = activityUrl;
        resource.activityDate = activityDate;
        resource.metrics = new Resources.Metrics();
        resource.metrics.views = views;
        resource.contentType = contentType;
        resource.isPrivate = isPrivate;

        String response = advocuApiClient.submitResources(resource);
        return ToolResponse.success(new TextContent("Successfully submitted resource: " + response));
    }

    @Tool(description = "Submit a public speaking event to Advocu.")
    ToolResponse publicSpeaking(
            @ToolArg(description = "What was the title of your talk?") String title,
            @ToolArg(description = "What was it about?") String description,
            @ToolArg(description = "Share any relevant link") String activityUrl,
            @ToolArg(description = "Date of your talk (YYYY-MM-DD)") String activityDate,
            @ToolArg(description = "What was your talk’s format?") String format,
            @ToolArg(description = "How long did your talk take (in minutes)?") int duration,
            @ToolArg(description = "How many people attended your talk?") int attendees,
            @ToolArg(description = "Make this activity private?") boolean isPrivate
    ) {
        PublicSpeaking publicSpeaking = new PublicSpeaking();
        publicSpeaking.title = title;
        publicSpeaking.description = description;
        publicSpeaking.activityUrl = activityUrl;
        publicSpeaking.activityDate = activityDate;
        publicSpeaking.format = format;
        publicSpeaking.duration = duration;
        publicSpeaking.metrics = new PublicSpeaking.Metrics();
        publicSpeaking.metrics.attendees = attendees;
        publicSpeaking.isPrivate = isPrivate;

        String response = advocuApiClient.submitPublicSpeaking(publicSpeaking);
        return ToolResponse.success(new TextContent("Successfully submitted public speaking event: " + response));
    }

    @Tool(description = "Submit an event to Advocu.")
    ToolResponse event(
            @ToolArg(description = "What is your event title?") String title,
            @ToolArg(description = "Description") String description,
            @ToolArg(description = "Event URL") String activityUrl,
            @ToolArg(description = "Event start date (YYYY-MM-DD)") String startDate,
            @ToolArg(description = "Event end date (YYYY-MM-DD)") String endDate,
            @ToolArg(description = "What kind of event did you organize?") String type,
            @ToolArg(description = "What was your event’s format?") String format,
            @ToolArg(description = "Event duration") String duration,
            @ToolArg(description = "How many people attended the event?") int attendees,
            @ToolArg(description = "Make this activity private?") boolean isPrivate
    ) {
        Event event = new Event();
        event.title = title;
        event.description = description;
        event.activityUrl = activityUrl;
        event.dates = new Event.Dates();
        event.dates.start = startDate;
        event.dates.end = endDate;
        event.type = type;
        event.format = format;
        event.duration = duration;
        event.metrics = new Event.Metrics();
        event.metrics.attendees = attendees;
        event.isPrivate = isPrivate;

        String response = advocuApiClient.submitEvent(event);
        return ToolResponse.success(new TextContent("Successfully submitted event: " + response));
    }

    @Tool(description = "Submit an amplification to Advocu.")
    ToolResponse amplification(
            @ToolArg(description = "Date of the amplification (YYYY-MM-DD)") String activityDate,
            @ToolArg(description = "Approximate reach or views") int views,
            @ToolArg(description = "Title") String title,
            @ToolArg(description = "Description") String description,
            @ToolArg(description = "URL Link") String url,
            @ToolArg(description = "Make this activity private?") boolean isPrivate
    ) {
        Amplification amplification = new Amplification();
        amplification.activityDate = activityDate;
        amplification.metrics = new Amplification.Metrics();
        amplification.metrics.views = views;
        amplification.title = title;
        amplification.description = description;
        amplification.url = url;
        amplification.isPrivate = isPrivate;

        String response = advocuApiClient.submitAmplification(amplification);
        return ToolResponse.success(new TextContent("Successfully submitted amplification: " + response));
    }

    @Tool(description = "Submit a GitHub repository to Advocu.")
    ToolResponse githubRepository(@ToolArg(description = "URL of the GitHub repository") String url) {
        String response = submissionApiClient.submitGithubRepository(submissionId, new UrlPayload(url));
        return ToolResponse.success(new TextContent("Successfully submitted GitHub repository: " + response));
    }

    @Tool(description = "Submit a YouTube video to Advocu.")
    ToolResponse youtubeVideo(@ToolArg(description = "URL of the YouTube video") String url) {
        String response = submissionApiClient.submitYoutubeVideo(submissionId, new UrlPayload(url));
        return ToolResponse.success(new TextContent("Successfully submitted YouTube video: " + response));
    }
}
