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
import org.springframework.context.annotation.Bean;
import org.springframework.data.eventsourcing.factory.SpringDataEventSourcingFactory;
import org.springframework.data.eventsourcing.template.EventSourcingTemplate;

@SpringBootApplication
public class EventSourcingExampleApplication implements CommandLineRunner {
    @Autowired
    ApplicationContext context;
    @Autowired
    SpringDataEventSourcingFactory factory;

	public static void main(String[] args) {
		SpringApplication.run(EventSourcingExampleApplication.class, args);
	}

	@Bean
    SpringDataEventSourcingFactory createFactory() {
	    return new SpringDataEventSourcingFactory();
    }

    @Override
    public void run(String... strings) throws Exception {
        AggregateRepository aggregateRepository = context.getBean(AggregateRepository.class);

        factory.setAggregateUpdater(new MyAggregateUpdater(aggregateRepository));
        factory.setEventValidationHandler(new MyEventValidator(aggregateRepository));
        EventSourcingTemplate template = factory.build();
        template.handle(new CreateProfileEvent("12345","Joe", "King", "9088921111"));
        template.handle(new ChangePhoneNumberEvent("12345", "9088922222"));
    }
}
