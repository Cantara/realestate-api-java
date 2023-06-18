package no.cantara.realestate.distribution;


import no.cantara.realestate.observations.ObservationMessage;

import java.util.List;

public interface ObservationDistributionClient {

    String getName();
    void openConnection();
    void closeConnection();

    boolean isConnectionEstablished();

    void publish(ObservationMessage message);

    long getNumberOfMessagesObserved();


    /**
     * Optional method to get a list of ObservedMessages from local cache.
     * @return list of observed messages
     */
    List<ObservationMessage> getObservedMessages();
}
