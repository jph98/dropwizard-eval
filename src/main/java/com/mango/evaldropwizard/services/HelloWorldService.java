package com.mango.evaldropwizard.services;

import com.mango.evaldropwizard.HelloWorldConfiguration;
import com.mango.evaldropwizard.healthcheck.TemplateHealthCheck;
import com.mango.evaldropwizard.webapi.HelloWorldResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * The main environment that ties everything together.
 */
public class HelloWorldService extends Service<HelloWorldConfiguration> {
    
    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.setName("hello-world");
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new HelloWorldResource(template, defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));
    }
    
    public static void main(String[] args) throws Exception {
        new HelloWorldService().run(args);
    }

}