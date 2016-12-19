package com.mcf7.eventsourcing.test.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.eventsourcing.event.DomainEvent;

@Data
@AllArgsConstructor
public class ChangePhoneNumberEvent extends DomainEvent {
    private String employeeId;
    private String phoneNumber;
}
