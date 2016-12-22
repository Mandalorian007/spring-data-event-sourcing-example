package com.mcf7.eventsourcing.test.data.model;

import com.mcf7.eventsourcing.test.data.events.MyEventValidator;
import org.springframework.data.eventsourcing.template.EventSourcingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProfileEventSourcingTemplate extends EventSourcingTemplate {
    public ProfileEventSourcingTemplate(MyEventValidator eventValidationHandler, MyAggregateUpdater aggregateUpdater) {
        super(eventValidationHandler, aggregateUpdater);
    }
}
