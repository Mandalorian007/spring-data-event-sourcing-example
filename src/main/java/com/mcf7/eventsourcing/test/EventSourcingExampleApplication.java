package com.mcf7.eventsourcing.test;

import com.mcf7.eventsourcing.test.domain.AggregateRepository;
import com.mcf7.eventsourcing.test.domain.MyAggregateUpdater;
import com.mcf7.eventsourcing.test.domain.MyEventValidator;
import com.mcf7.eventsourcing.test.events.ChangePhoneNumberEvent;
import com.mcf7.eventsourcing.test.events.CreateProfileEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.eventsourcing.factory.SpringDataEventSourcingFactory;
import org.springframework.data.eventsourcing.template.EventSourcingTemplate;

@SpringBootApplication
public class EventSourcingExampleApplication implements CommandLineRunner {
    @Autowired
    ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(EventSourcingExampleApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        AggregateRepository aggregateRepository = context.getBean(AggregateRepository.class);

        SpringDataEventSourcingFactory factory = new SpringDataEventSourcingFactory();
        factory.setAggregateUpdater(new MyAggregateUpdater(aggregateRepository));
        factory.setEventValidationHandler(new MyEventValidator(aggregateRepository));
        EventSourcingTemplate template = factory.build();
        template.handle(new CreateProfileEvent("12345","Joe", "King", "9088921111"));
        template.handle(new ChangePhoneNumberEvent("12345", "9088922222"));
    }
}
