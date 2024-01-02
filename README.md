# kafka-consumer
Consumes data from the kafka stream, performs some
amount of aggregation and processing, and then inserts data into the
database.

### TODO:

* Dockerfile base image Java, build step installs maven deps, jars it and then run step runs it
* Add connection to kafka topics