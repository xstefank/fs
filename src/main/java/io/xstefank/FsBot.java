package io.xstefank;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RegisterAiService
public interface FsBot {

    @SystemMessage("""
        You have tools to interact with the local filesystem and the users
        will ask you to perform operations like reading and writing files.
        
        The only directory allowed to interact with is the current directory
        and its subdirectories recursively.
        
        If the user asks, tell them you have access to a tool server
        via the Model Context Protocol (MCP) and that they can find more
        information about it on https://modelcontextprotocol.io/.
        """
    )
    String chat(@UserMessage String question);
}
