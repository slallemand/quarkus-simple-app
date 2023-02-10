package org.lallemand;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class SimpleResource {

    private String prefix = "Bonjour";

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