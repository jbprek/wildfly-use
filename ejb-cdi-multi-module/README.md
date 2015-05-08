EJB CDI Multi Module Project
============================

Purpose
-------
Experiment with various CDI and EJB components that are split across different modules.


Use Cases
=========

Use Case  1 : CDI Events across Modules
--------------------------------
 - An Ejb module (module A) has an observable EJB CDI notifier.
 - Notification from the above should be received in the same EJB module as CDI events.
 - Notification from module (module A) should be received as CDI events, in Beans under warpp in the same EJB module as CDI events
 - Another module (module B) must be able to subscribe and receive CDI events from module A.
 - Finally a web application is receiving events from both modules 

### Design ###
 
  1. Module A  
       1. org.bagab.cdi.events.moda.AppControlSingleton is the observable object firing  org.bagab.cdi.events.moda.ApplicationChangedStatusEvent.
  2. Module B 
       1. org.bagab.cdi.events.modb.ModAObserver SSB observers org.bagab.cdi.events.moda.ApplicationChangedStatusEvent from Module A.
       2. org.bagab.cdi.events.modb.AsyncBean provides a methods that simulates a long working process that fires  org.bagab.cdi.events.modb.AsyncBeanDoneEvent when finished.
  3.  WebApp
       1.  org.bagab.cdi.events.web.ModObserver receives events from both modules.
       2.  org.bagab.cdi.events.web.BusService  calls org.bagab.cdi.events.modb.AsyncBean and observes org.bagab.cdi.events.modb.AsyncBeanDoneEvent.
    
  
 
Use Case 2 : Alternatives  across Modules  TODO
---------------------------------------
### Idea ### 
Use of different alternatives in different modules 
 
 
 
Use Case : Singleton depedencies  across Modules  TODO
------------------------------------------------
 
