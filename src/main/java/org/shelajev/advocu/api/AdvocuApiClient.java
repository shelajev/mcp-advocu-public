package org.shelajev.advocu.api;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.shelajev.advocu.*;

@Path("/personal-api/v1/dockercaptains")
@RegisterRestClient(configKey="advocu-api")
public interface AdvocuApiClient {

    @POST
    @Path("/activity-drafts/feedbackSession")
    @Produces(MediaType.APPLICATION_JSON)
    String submitFeedbackSession(FeedbackSession session);

    @POST
    @Path("/activity-drafts/resources")
    @Produces(MediaType.APPLICATION_JSON)
    String submitResources(Resources resources);

    @POST
    @Path("/activity-drafts/public-speaking")
    @Produces(MediaType.APPLICATION_JSON)
    String submitPublicSpeaking(PublicSpeaking publicSpeaking);

    @POST
    @Path("/activity-drafts/event")
    @Produces(MediaType.APPLICATION_JSON)
    String submitEvent(Event event);

    @POST
    @Path("/activity-drafts/amplification")
    @Produces(MediaType.APPLICATION_JSON)
    String submitAmplification(Amplification amplification);
}
