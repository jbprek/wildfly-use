package com.mibeez.hub.app;

/**
 * Application Exception
 */
public class IotGatewayException extends Exception {

    public IotGatewayException(String message) {
        super(message);
    }

    public IotGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
