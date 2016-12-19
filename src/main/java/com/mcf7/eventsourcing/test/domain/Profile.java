package com.mcf7.eventsourcing.test.domain;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.couchbase.core.mapping.Document;

@Data
@AllArgsConstructor
@Document
public class Profile {
    @Id
    private String id;

    @Field
    private String firstName;

    @Field
    private String lastName;

    @Field
    private String phoneNumber;
}
