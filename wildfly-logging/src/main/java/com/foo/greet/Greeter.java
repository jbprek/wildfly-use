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
package com.foo.greet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;

import java.util.logging.Logger;

/**
 * A messagedriven Hello World EJB. The EJB does not use an interface.
 *
 * @author paul.robinson@redhat.com, 2011-12-21
 */
@Stateful
public class Greeter {
    private static final Logger log = Logger.getLogger(Greeter.class.getName());

    @PostConstruct
    private void setup() {
        log.info("JULI instance created!");
    }

    @PreDestroy
    private void teadown() {
        log.info("JULI instance destroyed!");
    }


    public String sayHello(String name) {
        log.info("JULI Requested hello from " + name);
        return "Hello " + name;
    }
}
