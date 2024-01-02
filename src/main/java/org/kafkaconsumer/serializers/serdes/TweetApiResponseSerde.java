package org.kafkaconsumer.serializers.serdes;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.kafkaconsumer.models.TweetApiResponse;
import org.kafkaconsumer.serializers.JsonDeserializer;
import org.kafkaconsumer.serializers.JsonSerializer;

import java.util.Properties;

/**
 * Serializer-deserializer for {@code TweetApiResponse}.
 * @author chrisrinaldi
 * @since 1 January 2024
 */
public class TweetApiResponseSerde extends Serdes.WrapperSerde<TweetApiResponse> {

    /**
     * Serializer/de-serializer.
     */
    public TweetApiResponseSerde() {
        super(new JsonSerializer<>(), new JsonDeserializer<>(TweetApiResponse.class));
    }
}
