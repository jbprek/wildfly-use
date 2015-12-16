package org.bagab.rs.util.jaxrs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.annotation.PostConstruct;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * @author prekezes.
 */
@Provider
public class JacksonProducer implements ContextResolver<ObjectMapper> {


    private final ObjectMapper mapper;

    @PostConstruct
    public void init() {

    }
    public JacksonProducer() throws Exception {
        mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public ObjectMapper getContext( Class<?> type ) {
        return mapper;
    }

}
