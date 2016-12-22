package com.mcf7.eventsourcing.test.data.model;

import com.mcf7.eventsourcing.test.data.events.ChangePhoneNumberEvent;
import com.mcf7.eventsourcing.test.data.events.CreateProfileEvent;
import org.springframework.data.eventsourcing.aggregate.AggregateEventHandler;
import org.springframework.data.eventsourcing.aggregate.AggregateUpdater;
import org.springframework.stereotype.Component;

@Component
public class MyAggregateUpdater extends AggregateUpdater {
    private AggregateRepository aggregateRepository;

    public MyAggregateUpdater(AggregateRepository aggregateRepository) {
        this.aggregateRepository = aggregateRepository;
    }

    @AggregateEventHandler
    public void handle(CreateProfileEvent event) {
        Profile profile = new Profile(event.getEmployeeId(), event.getFirstName(), event.getLastName(), event.getPhoneNumber());
        aggregateRepository.save(profile);
    }

    @AggregateEventHandler
    public void handle(ChangePhoneNumberEvent event) {
        Profile profile = aggregateRepository.findOne(event.getEmployeeId());
        profile.setPhoneNumber(event.getPhoneNumber());
        aggregateRepository.save(profile);
    }
}
