# tapestry-resteasy-hibernate
Small example using Tapestry, RESTEasy and Hibernate

# Test the application

1. git clone https://github.com/oliverbauer/tapestry-resteasy-hibernate.git
2. cd tapestry-resteasy-hibernate
3. mvn clean jetty:run
4. curl -H "Content-Type: application/json" -d '{"mail":"mymail","name":"name","password":"password"}' http://localhost:8080/tapestry-resteasy-example/rest/user/create -i

  This should give a 200
5. curl http://localhost:8080/tapestry-resteasy-example/rest/user/read/mymail -i

  This should give a 200

# How this application was created

1. mvn archetype:generate -DarchetypeCatalog=http://tapestry.apache.org
2. pom.xml updates 
   - maven-compiler-plugin version update from 1.5 to 1.8
   - tapestry-release-version property update from 5.3.7 to 5.4-beta-22
   - removed dependency org.apache.tapestry:tapestry-yuicompressor:${tapestry-release-version}
3. following 
   http://tynamo.org/tapestry-resteasy+guide and
   https://tapestry.apache.org/using-tapestry-with-hibernate.html

   pom.xml updates:
   - added dependency org.tynamo:tapestry-resteasy:0.4.0
   - added dependency org.jboss.resteasy:resteasy-jackson-provider:3.0.10.Final
   - added dependency org.apache.tapestry:tapestry-hibernate:${tapestry-release-version}
   - added dependency org.hsqldb:hsqldb:2.3.2

   create packages 
   - com.github.oliverbauer.tapestry.resteasy.example.{rest|entities}
   - created class User in ...entities
   - created interface UserDAO and implementation UserDAOImpl in package ...rest

   added hibernate.cfg.xml to src/main/resources
   added methods configureRestResources and adviseTransactions in AppModule
   extended bind-method in AppModule
