package com.mcf7.eventsourcing.test.data.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.eventsourcing.event.DomainEvent;

@Data
@AllArgsConstructor
public class CreateProfileEvent extends DomainEvent {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
