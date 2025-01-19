package com.demo.springkafka.kafka.connect;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileStramSourceConnector extends SourceConnector {

    public static final String FILE_CONFIG = "file";
    public static final String TOPIC_CONFIG = "topic";

    @Override
    public String version() {
        return "";
    }

    @Override
    public void start(Map<String, String> map) {

    }

    @Override
    public Class<? extends Task> taskClass() {
        return FileStreamSourceTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        List<Map<String, String>> configs = new ArrayList<>();
        Map<String, String> config = new HashMap<>();
        // TODO: Start here when resuming work
        //        if (fileName != null) {
        //
        //        }
        return List.of();
    }

    @Override
    public void stop() {

    }

    /**
     * @return
     */
    @Override
    public ConfigDef config() {
        return null;
    }
}
