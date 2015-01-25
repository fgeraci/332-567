# 332-567


Spring 2015 - 332:567 Project - Stock Predictor Web App
-------------------------------------------------------


PARTICIPANTS:
	
		Valia Kalokyri
		Fernando Geraci
		
IMPLEMENTATION OVERVIEW:

	The skeleton has been built as a Maven project, with a master pom in the root. There are setting files for
	importing into Eclipse. The packaging is WAR so it will be fully deployable in any tomcat 7+ instance.
	
	Ideally, just for the skeleton, it will be useful to keep the scope as humble as possible hence I haven't
	created many packages yet but the essentials (model, view and controllers).
	
	As per web.xml configuration; we are using Spring as the framework. There will be a main RequestDispatcher 
	at the root 	(could be changed at any time) and for testing purposes a MainController which ideally it will 
	just instantiate basic apps resources and configurations.