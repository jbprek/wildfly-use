EJB CDI Multi Module Project
============================

Purpose
-------
Experiment with various CDI and EJB components that are split across different modules.


Use Cases
=========

Use Case : CDI Events across Modules
--------------------------------
 - An Ejb module (module A) has an observable EJB CDI notifier.
 - Notification from the above should be received in the same EJB module as CDI events.
 - Notification from module (module A) should be received as CDI events, in Beans under warpp in the same EJB module as CDI events
 - Another module (module B) must be able to subscribe and receive CDI events from module A.
 
### Realization
#### Implementation 
 package org.bagab.cdi.events, Observable  under ejb-module-a, observers in ejb-module-b and warapp.
#### Tests
 package org.bagab.cdi.events under ejb-module-a and ejb-module-b and warapp.    

 
Use Case : Alternatives  across Modules  TODO
---------------------------------------
### Idea ### 
Use of different alternatives in different modules 
 
 
 
Use Case : Singleton depedencies  across Modules  TODO
------------------------------------------------
 
