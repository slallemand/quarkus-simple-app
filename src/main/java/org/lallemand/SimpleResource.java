package org.lallemand;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;


@Path("/")
public class SimpleResource {
    @ConfigProperty(name = "greeting.message")
    private String prefix;

    private String HOSTNAME =
       System.getenv().getOrDefault("HOSTNAME", "unknown");
    
    private int count = 0;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        count++;
        return prefix + " " + HOSTNAME + ":" + count + "\n";
    }
}