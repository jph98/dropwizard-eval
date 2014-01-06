package com.mango.evaldropwizard.webapi;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;
import com.mango.evaldropwizard.domain.Saying;
import com.yammer.metrics.annotation.Timed;

/**
 * Used by multiple clients so need to be stateless.
 */
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    
    // Shared data between all clients
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        
        return new Saying(counter.incrementAndGet(),
                          String.format(template, name.or(defaultName)));
        
    }
}
