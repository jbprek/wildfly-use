/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mibeez.hub.app;

import com.mibeez.hub.gson.JsonHandler;
import com.mibeez.hub.model.HubInfo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.logging.Logger;

@Path("/")
@Stateless
public class HubApi {

    private static Logger log = Logger.getLogger(HubApi.class.getName());

    private JsonHandler jsonHandler;

    @EJB
    private HubInfoService hubInfoService;

    @PostConstruct
    private void setup() {
        jsonHandler = new JsonHandler();
    }

    /**
     * Retrieves a JSON hello world message.
     * The {@link Path} method annotation value is related to the one defined at the class level.
     *
     * @return
     */
    @GET
    @Path("/")
    @Produces({"application/json"})
    public String getHubInfo() {
        HubInfo h = hubInfoService.getInstance();
        return jsonHandler.toJson(h);
    }


    @POST
    @Path("/")
    @Consumes({"application/json"})
    public String commission() {
        HubInfo h = hubInfoService.getInstance();
        return jsonHandler.toJson(h);
    }

    @GET
    @Path("/ping")
    @Produces({"text/plain"})
    public String pong() {
        return "pong";
    }

//
//    /**
//     * Retrieves a XML hello world message.
//     * The {@link Path} method annotation value is related to the one defined at the class level.
//     *
//     * @return
//     */
//    @GET
//    @Path("xml")
//    @Produces({"application/xml"})
//    public String getHelloWorldXML() {
//        return "<xml><result>" + helloService.createHelloMessage("World") + "</result></xml>";
//    }

}
