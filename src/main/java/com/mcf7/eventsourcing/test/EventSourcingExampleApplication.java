package com.mcf7.eventsourcing.test;

import com.mcf7.eventsourcing.test.data.events.ChangePhoneNumberEvent;
import com.mcf7.eventsourcing.test.data.events.CreateProfileEvent;
import com.mcf7.eventsourcing.test.data.events.MyEventValidator;
import com.mcf7.eventsourcing.test.data.model.ProfileEventSourcingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventSourcingExampleApplication implements CommandLineRunner {
    @Autowired
    ProfileEventSourcingTemplate template;
    @Autowired
    MyEventValidator eventValidator;

	public static void main(String[] args) {
		SpringApplication.run(EventSourcingExampleApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        template.handle(new CreateProfileEvent("12345","Joe", "King", "9088921111"));
        template.handle(new ChangePhoneNumberEvent("12345", "9088922222"));
    }
}
