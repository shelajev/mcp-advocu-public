package org.shelajev;

import io.quarkiverse.mcp.server.TextContent;
import io.quarkiverse.mcp.server.Tool;
import io.quarkiverse.mcp.server.ToolArg;
import io.quarkiverse.mcp.server.ToolResponse;
import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Singleton
public class AdvocuMCP   {

    @Tool(description = "Put you description here.")
    ToolResponse foo(@ToolArg(description = "The name", defaultValue = "Andy") String name) {
        return ToolResponse.success(
                new TextContent("Hello, " + name + "!"));
    }
}
