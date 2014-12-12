
# What is Dropwizard? (summarized from http://dropwizard.io) 
## Executive Summary:
* Dropwizard, developed by Yammer/CodaHale, pulls together stable, mature Java libraries into a simple, light-weight (web-enabled) package.
* Dropwizard has out-of-the-box support for sophisticated configuration, application metrics, logging, operational tools, allowing you to ship a production-quality web service quickly.
* Dropwizard applications are typically deployed as single "fat" JAR (using Maven Shade) allowing for trivial/consistent deployment across all environments.  Environment specific info is stored in config files provided at runtime.

## Libraries included w/ Dropwizard:
* Jetty as the embedded web server
* Jersey for REST
* Jackson for JSON (http://tools.ietf.org/html/rfc7159)
* Codahale Metrics for metrics (can be sent to Ganglia and Graphite)
* Google Guava for all the Java hotness
* Logback for logging
* Hibernate Validator (JSR-303 ref impl) for declarative user input validation and error messaging
* Apache HTTPClient for lower-level web service interactions
* JodaTime for sane date/time manipulation.
* Addtional stuff -- JDBI, Liquidbase, Freemarker/Mustache, etc...

## Dropwizard top-level components (using TextAnalyzer classes):
### Configuration class (environment-specific parameters)

    public class TextAnalyzerConfig extends io.dropwizard.Configuration 

* Used to handle reading the environment-specific parameters for your application - specified via a YAML/.yml file.
* The Configuration class use annotations:
 * Hibernate Validators -- @NotEmpty, @NotNull, @Valid, etc for startup/initialization validation Full Hibernate annotation reference found [here](https://docs.jboss.org/hibernate/validator/4.0.1/reference/en-US/html_single/).
 * Jackson deserialzation -- @JsonProperty, @JsonIgnore, etc for mapping to/from YAML and your application via Jackson. Full Jackson annotation reference found [here](http://wiki.fasterxml.com/JacksonAnnotations)

### Application class (main() entry point)

    public class TextAnalyzerApp extends io.dropwizard.Application<MyConfiguration>

* Parameterized with the application's configuration and contains the * **static main** * method for the application's entry point.
* Registration of Resources to expose (see below).  

### Resource class (Jersey web service endpoints).

    @Path("/text-analyzer")
    @Produces(MediaType.APPLICATION_JSON)
    public class TextAnalyzerResource
 
* Each Resource class is associated with a URI template and has methods to handle the various GET/POST/PUT/DELETE requests.
* A successful response from a Resource is typically 200 OK with the content type of application/json and the JSON-ified representation of the response class.
* Resources should be stateless/immutable.
* Uses  ** javax.ws.rs ** annotations (https://docs.oracle.com/javaee/6/api/javax/ws/rs/package-summary.html):
  * Application-level -- @Path("/text-analyzer") and @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
  * Method invocation-level -- @GET / @POST / @PUT / @DELETE, @Timed
  * Method parameter-level -- @QueryParam("text")

### The App's "Representation" Class(es)
* Simple immutable JavaBean objects (getters) used by Jackson to serialize it to JSON.   
* Returned by a Resource class.

### Health Checks
    
    public class TextAnalyzerHealthCheck extends com.codahale.metrics.health.HealthCheck

* Automatic runtime test which you can use to verify your application's behavior in its production environment
* Can be accessed via admin port http://<host>:8081/healthcheck e.g.
```
$ curl http://localhost:8081/healthcheck
{"configHealthCheck":{"healthy":true},"deadlocks":{"healthy":true}}
```

## DropWizard Administration pages

### Metrics (JSON)
http://localhost:8081/metrics?pretty=true

### (manual) HealthChecks (JSON)
http://localhost:8081/healthcheck

### Thread state (jstack)
http://localhost:8081/threads



