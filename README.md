# Spring-Kafka

Playground to learn more about Kafka in spring.

## How to run things

### Spring

```shell
./gradlew bootRun
```

### HTTP

IntelliJ generated scripts to run the http calls produced by controllers.

This is something tha you need to run with a tool. However, it is something that you can mimick easily by converting it
to a `curl` command such as this

```shell
curl -X POST "localhost:8080/api/v1/kafka/publish?message=jake" 
```

### [Kafka](https://kafka.apache.org/quickstart)

Usually, we don't just download a run time and throw it in a repo. However, for ease of development, I did that here.
The link found in the header will show you how to:

* install the latest apache-kafka locally
* run it via the scripts in the `/bin` directory
* explore pub/sub
* explore kafka connectors/sinks
* explore kafka streams

There is a run script in this folder to start Kafka locally as recommended by the guide.

```shell
sh kafka/run-kafka.sh
```

Consumer (can be left running to consume messages as they come in).

Producer will be left alive and allow you to enter messages one at a time.

```shell
$ sh kafka/kafka_2.13-3.9.0/bin/kafka-console-producer.sh --topic test-topic --bootstrap-server localhost:9092
>jake
>rules
>the
>world
>^C%                                                                                                               

$ sh kafka/kafka_2.13-3.9.0/bin/kafka-console-consumer.sh --topic test-topic --from-beginning --bootstrap-server localhost:9092
m4_HqYK1Content-Type: application/x-www-form-urlencoded
jake
rules
the
world
```

###