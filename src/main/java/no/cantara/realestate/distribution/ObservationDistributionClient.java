package no.cantara.realestate.distribution;


import no.cantara.realestate.MqttUnavailableException;
import no.cantara.realestate.RealEstateException;
import no.cantara.realestate.observations.ObservationMessage;

import java.util.List;


public interface ObservationDistributionClient {

    String getName();
    void openConnection();
    void closeConnection();

    boolean isConnectionEstablished();

    /**
     * @param observationMessage the observation to publish
     * @throws RealEstateException if the connection is not established/stable, or the message cannot be built
     * @throws MqttUnavailableException if the connection is not established or unstable. Daily Quota limit reached may also be the cause.
     * The client should call closeConnection on the AzureObservationDistributionClient when receiving this MqttUnavailableException. Then restart the client to re-establish connection to Azure IoT Hub.
     */
    void publish(ObservationMessage observationMessage);

    long getNumberOfMessagesObserved();


    /**
     * Optional method to get a list of ObservedMessages from local cache.
     * @return list of observed messages
     */
    List<ObservationMessage> getObservedMessages();
}
