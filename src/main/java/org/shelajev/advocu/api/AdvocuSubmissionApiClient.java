package org.shelajev.advocu.api;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.shelajev.advocu.UrlPayload;

@Path("/{submissionId}/activities")
@RegisterRestClient(configKey="advocu-submission-api")
public interface AdvocuSubmissionApiClient {

    @POST
    @Path("/github-repository/submission")
    @Produces(MediaType.APPLICATION_JSON)
    String submitGithubRepository(@PathParam("submissionId") String submissionId, UrlPayload payload);

    @POST
    @Path("/youtube-video/submission")
    @Produces(MediaType.APPLICATION_JSON)
    String submitYoutubeVideo(@PathParam("submissionId") String submissionId, UrlPayload payload);
}
