package com.mcf7.eventsourcing.test.data.events;

import com.mcf7.eventsourcing.test.data.model.AggregateRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.eventsourcing.event.validator.EventValidationHandler;
import org.springframework.data.eventsourcing.event.validator.EventValidator;
import org.springframework.stereotype.Component;

@Component
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