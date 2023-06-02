package no.cantara.realestate.distribution;


import no.cantara.realestate.observations.ObservationMessage;

import java.util.List;

public interface ObservationDistributionClient {

    void publish(ObservationMessage message);


    /**
     * Optional method to get a list of ObservedMessages from local cache.
     * @return list of observed messages
     */
    List<ObservationMessage> getObservedMessages();
}
