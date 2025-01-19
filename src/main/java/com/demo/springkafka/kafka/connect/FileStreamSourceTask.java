package com.demo.springkafka.kafka.connect;

import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;

import java.util.List;
import java.util.Map;

import static com.demo.springkafka.kafka.connect.FileStramSourceConnector.FILE_CONFIG;
import static com.demo.springkafka.kafka.connect.FileStramSourceConnector.TOPIC_CONFIG;

public class FileStreamSourceTask extends SourceTask {

    private String fileName;
    private String topic;

    public FileStreamSourceTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String version() {
        return "";
    }

    @Override
    public void start(Map<String, String> props) {
        this.fileName = props.get(FILE_CONFIG);
        this.topic = props.get(TOPIC_CONFIG);
    }

    @Override
    public List<SourceRecord> poll() throws InterruptedException {
        return List.of();
    }

    @Override
    public void stop() {
        // Do nothing as we have nothing to monitor in this simple app.
    }
}
