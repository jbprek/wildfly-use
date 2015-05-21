Wildfly Logging Notes
=====================


Use case 1: Use Both JULI and LOG4J - **SUCCESS**
------------------------------------
Demonstrates the use of both JULI and log4j framework within the same application. Basically this is the opposite problem that a Logging Facade attempts to solve.
Here we have two existing hypothetical code bases that we're trying to consolidate; one using JULI and one using LOG4J and we attempt to run them both under Wildfly.

* Package com.foo.calc uses Log4J.
* Packaged com.foo.greet uses JULI.

