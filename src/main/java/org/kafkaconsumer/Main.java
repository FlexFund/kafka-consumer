package org.kafkaconsumer;

import org.kafkaconsumer.services.IngestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runs an ingestion service against Kafka topics to extract data,
 * then aggregates, transforms and loads into a SQL database.
 * @author chrisrinaldi
 * @since 1 January 2024
 */
public class Main {

    /**
     * The entrypoint to the application.
     * @param args
     */
    public static void main(String[] args) {
        IngestionService service = new IngestionService();
        service.runIngestion();
    }
}