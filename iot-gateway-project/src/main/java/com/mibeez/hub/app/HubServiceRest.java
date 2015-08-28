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



import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Implementation of Hub Application REST api
 *
 * HUB	CS	POST	/	commission	BeehiveHub commission, name assignement to the hub	Input name of the hub, returns HubInfo {'name'='<NAMEVALUE>'}
 * HUB	CS	PUT	/	toggleStandby	BeehiveHub temporary de-commission	{'standby'=[true|false]}
 * HUB	CS	DELETE	/	decommission	BeehiveHub permanent de-commission	None
 * HUB	CS	DELETE	/sensors/{:lan_address}	hiveCommission	Hive Decommission	None
 * HUB	CS	GET	/sensors[/{:lan_address}]	hiveSensorValues	Cached sensor values	returns SensorInfo[]
 * HUB	CS	PUT	/sensors[/{:lan_address}]	hiveUpdateSensorValues	Last sensor values,  forces re-read of sensor values	returns SensorInfo[]
 * HUB	CS	GET	/alerts	readAlertList	Current alarm conditions	returns SensorInfo[]
 */
@Path("/")
@Stateless
public class HubServiceRest {

    private static Logger log = Logger.getGlobal();


    @EJB
    private IotGatewayService service;

    @PostConstruct
    private void setup() {

    }

    /**
     * <p>URL: GET /</p>
     * @return   HubInfo as JSON string
     */
    @GET
    @Path("/")
    @Produces({"application/json"})
    public String getHubInfo() {
        log.config("GET / -> getHubInfo()");
//
//        try {
//            HubInfo h = service.getHub().toHubInfo();
//            return jsonHandler.toJson(h);
//        } catch (IotGatewayException e) {
//            log.severe(e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
        return null;
    }

    /**
     * <p>URL: POST /</p>
     * @param jsonInfo
     * @return
     */
    @POST
    @Path("/")
    @Consumes({"application/json"})
    public Response commission(String jsonInfo) {
        log.config("POST / -> commission()");
//
//        // Retrieve port Information
//        // TODO invalid format
//        Type type = new TypeToken<Map<String, String>>(){}.getType();
//        Map<String, String> myMap = jsonHandler.fromJson(jsonInfo, type);
//
//        try {
//            service.commitHub(myMap.get("name"));
//        } catch (IotGatewayException e) {
//            // TODO handle error
//            e.printStackTrace();
//        }

        return Response.created(URI.create("/")).build();
    }

    /**
     * <p>URL: PUT /</p>
     * @param jsonInfo
     * @return
     */
    @PUT
    @Path("/")
    @Consumes({"application/json"})
    public Response toggleStandby(String jsonInfo) {
        log.config("PUT / -> toggleStandby()");

//        Type type = new TypeToken<Map<String, String>>(){}.getType();
//        Map<String, String> myMap = jsonHandler.fromJson(jsonInfo, type);
//
//        HubInfo h = hubInfoService.getInstanceTO();
//        // TODO Error if name allready exists
//        // TODO Error if name not found in jsonInfo
//        String val = myMap.get("standby").trim();
//        boolean standby = Boolean.parseBoolean(val);
//        h.setStatus(standby ? HubStatus.SB : HubStatus.ON);
//        hubInfoService.updateInstance(h);
        return Response.ok(URI.create("/")).build();
    }

    /**
     * <p>URL: DELETE /</p>
     * @param jsonInfo
     * @return
     */
    @DELETE
    @Path("/")
    public Response decommission(String jsonInfo) {
        log.config("DELETE / -> decommission()");

        // TODO Implement
//        HubInfo h = hubInfoService.getInstanceTO();
//        // TODO Error if name allready exists
//        // TODO Error if name not found in jsonInfo
//        String val = myMap.get("standby").trim();
//        boolean standby = Boolean.parseBoolean(val);
//        h.setStatus(standby ? HubStatus.SB : HubStatus.ON);
//        hubInfoService.updateInstance(h);
        return Response.ok(URI.create("/")).build();
    }

    /**
     * <p>URL: GET /ping</p>
     * @return
     */
    @GET
    @Path("/ping")
    @Produces({"text/plain"})
    public Response ping() {
        log.config("GET /ping -> ping()");

        return Response.ok(URI.create("/")).build();
    }

    /**
     * <p>URL: GET /sensors</p>
     * @return
     */
    @GET
    @Path("/sensors")
    @Produces({"application/json"})
    public String allHiveSensorValues() {
        log.config("GET /sensors -> ping()");
        // TODO real data
        return null;
    }


    /**
     * <p>URL: GET /{lan_address}</p>
     * @return
     */
    @GET
    @Path("/sensors/{lan_address}")
    @Produces({"application/json"})
    public String hiveSensorValues(@PathParam("lan_address")String lanAddress) {
        log.config("GET /sensors/{lan_address}=" + lanAddress);
        // TODO real data
        return null;
    }

    /**
     * <p>URL: PUT /sensors</p>
     * @return
     */
    @PUT
    @Path("/sensors")
    @Produces({"application/json"})
    public Response refreshAllHiveSensorValues() {
        log.config("PUT /sensors -> refreshAllHiveSensorValues()");
        // TODO real data
        return Response.ok(URI.create("/")).build();
    }

    /**
     * <p>URL: DELETE /sensors/{lan_address} </p>
     * @return
     */
    @DELETE
    @Path("/sensors/{lan_address}")
    @Produces({"application/json"})
    public String hiveDecommission(@PathParam("lan_address")String lanAddress) {
        log.info("GET /sensors/ + "+lanAddress);
        // TODO real data
        return null;
    }

    /**
     * <p>URL: PUT /sensors/{lan_address} </p>
     * @return
     */
    @PUT
    @Path("/sensors/{lan_address}")
    @Produces({"application/json"})
    public String refreshHiveSensorValues(@PathParam("lan_address")String lanAddress) {
        log.info("GET /sensors/ + "+lanAddress);
        // TODO real data
        return null;
    }

    /**
     * <p>URL: GET /alerts</p>
     * @return
     */
    @GET
    @Path("/alerts")
    @Produces({"application/json"})
    public String getAlerts() {
        log.info("GET /alerts/ ALL ");
        // TODO real data
        return null;
    }

}
