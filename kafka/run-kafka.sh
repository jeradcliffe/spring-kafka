#!/bin/zsh

cd kafka_2.13-3.9.0 || exit

KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"
echo "KAFKA_CLUSTER_ID: $KAFKA_CLUSTER_ID"

bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/kraft/reconfig-server.properties

bin/kafka-server-start.sh config/kraft/reconfig-server.properties
echo "Successfully started Kafka. You can connect at 127.0.0.1:9092."
