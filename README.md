# minimalistic POC of JSON format logging

to build springboot app on openshift:
```
mvn package oc:build -Popenshift -DLEVEL=info
```

only runs java part on localhost:
```
mvn exec:java
```

to run springboot app on localhost:

```
mvn spring-boot:run
```
