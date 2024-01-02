package org.kafkaconsumer.services;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.kafkaconsumer.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Level;

public class IngestionService {

    /**
     * Represents the {@code Logger} instance.
     */
    private final Logger _logger;

    private final AppConfig _config;

    private StreamsBuilder _builder;

    private Topology _topology;

    private KafkaStreams streams;

    /**
     * Logs a pre-formatted message to stdout.
     * @param message
     */
    private void log(String message) {
        this._logger.info(this.formatLoggerString(message));
    }

    /**
     * Log an error to stdout.
     * @param message
     */
    private void error(String message) {
        this._logger.error(this.formatLoggerString(message));
    }

    /**
     * Format a logger message.
     * @param message
     * @return
     */
    private String formatLoggerString(String message) {
        return MessageFormat.format("[{0}]: {1}", this.getClass().getName(), message);
    }

    /**
     * Construct a new {@code IngestionService}.
     */
    public IngestionService() {
        this._logger = LoggerFactory.getLogger(this.getClass().getName());
        this.log("Applying configuration to service...");
        this._config = new AppConfig();
        this.initIngestionService();
    }

    /**
     * Run the service.
     */
    public void runIngestion() {
        try (
                KafkaStreams streams = new KafkaStreams(this._topology, this._config.getProperties())
        ) {
            // TODO: Insert/write business logic for ingestion service.
            streams.start();
        } catch (Exception e) {
            this.error(MessageFormat.format("Encountered an exception while running ingestion: {0}", e));
        }
    }

    /**
     * Initializes the ingestion service.
     */
    private void initIngestionService() {
        this.log("Service is initializing...");
        this._builder = new StreamsBuilder();
        this.log("Building topology...");
        this._topology = this._builder.build();
        this.log("Ingestion topology built. Awaiting request to run.");
    }

}
