package com.mcf7.eventsourcing.test.domain;

import com.mcf7.eventsourcing.test.events.ChangePhoneNumberEvent;
import com.mcf7.eventsourcing.test.events.CreateProfileEvent;
import lombok.AllArgsConstructor;
import org.springframework.data.eventsourcing.event.validator.EventValidationHandler;
import org.springframework.data.eventsourcing.event.validator.EventValidator;

@AllArgsConstructor
public class MyEventValidator extends EventValidationHandler {
    private AggregateRepository aggregateRepository;

    @EventValidator
    public boolean isValid(CreateProfileEvent event) {
        if(aggregateRepository.findOne(event.getEmployeeId()) == null) {
            return true;
        }
        return false;
    }

    @EventValidator
    public boolean isValid(ChangePhoneNumberEvent event) {
        if(aggregateRepository.findOne(event.getEmployeeId()) != null) {
            return true;
        }
        return false;
    }
}
