package com.mcf7.eventsourcing.test.domain;

import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AggregateRepository extends CouchbasePagingAndSortingRepository<Profile, String> {
}
