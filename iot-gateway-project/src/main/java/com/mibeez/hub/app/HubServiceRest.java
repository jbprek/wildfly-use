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

import com.google.gson.reflect.TypeToken;
import com.mibeez.gson.JsonHandler;
import com.mibeez.hub.to.HubInfo;
import com.mibeez.hub.model.HubStatus;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Map;
import java.util.logging.Logger;

@Path("/")
@Stateless
public class HubServiceRest {

    private static Logger log = Logger.getLogger(HubServiceRest.class.getName());

    private JsonHandler jsonHandler;

    @EJB
    private HubService hubInfoService;

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
        HubInfo h = hubInfoService.getInstanceTO();
        return jsonHandler.toJson(h);
    }

    /**
     * We expect a JSON object of the form { 'name' : 'nameValue'}
     * @param jsonInfo
     * @return
     */
    @POST
    @Path("/")
    @Consumes({"application/json"})
    public Response commission(String jsonInfo) {
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> myMap = jsonHandler.fromJson(jsonInfo, type);

        HubInfo h = hubInfoService.getInstanceTO();
        // TODO Error if name allready exists
        // TODO Error if name not found in jsonInfo
        h.setName(myMap.get("name"));
        h.setStatus(HubStatus.ON);
        hubInfoService.updateInstance(h);
        return Response.created(URI.create("/")).build();
    }

       /*
       	HUB	CS	PUT	/	BeehiveHub temporary de-commission	{'commission=true|false}
	    HUB	CS	DELETE	/	BeehiveHub permanent de-commission	None
        HUB	CS	DELETE	/sensors/{:lan_address}	Hive Decommission	None
        HUB	CS	GET	/sensors[/{:lan_address}]	Cached sensor values	returns SensorInfo[]
        HUB	CS	PUT	/sensors[/{:lan_address}]	Last sensor values,  forces re-read of sensor values	returns SensorInfo[]
        HUB	CS	GET	/alarms	Current alarm conditions	returns SensorInfo[]

        */
    /**
     *
     * @param jsonInfo
     * @return
     */
    @PUT
    @Path("/")
    @Consumes({"application/json"})
    public Response updateStatus(String jsonInfo) {
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> myMap = jsonHandler.fromJson(jsonInfo, type);

        HubInfo h = hubInfoService.getInstanceTO();
        // TODO Error if name allready exists
        // TODO Error if name not found in jsonInfo
        String val = myMap.get("standby").trim();
        boolean standby = Boolean.parseBoolean(val);
        h.setStatus(standby ? HubStatus.SB : HubStatus.ON);
        hubInfoService.updateInstance(h);
        return Response.ok(URI.create("/")).build();
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
