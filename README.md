# spring-data-event-sourcing-example
Spring data eventsourcing example project

Example project for: https://github.com/Mandalorian007/spring-data-eventsourcing/

Setting up Couchbase

1.  Default bucket primary index
    *  CREATE PRIMARY INDEX ON `default` USING GSI;
2.  couchbaseDomainEventWrapper view
    *  all
```
function (doc, meta) {
    if (doc._class == 'org.springframework.data.eventsourcing.event.store.CouchbaseDomainEventWrapper') {
        emit(doc.name, [doc.id,doc.clazz,doc.domainEvent]);
    }
}
```
3.  profile view
    *  all
```
function (doc, meta) {
    if (doc._class == 'com.mcf7.eventsourcing.test.domain.Profile') {
        emit(doc.name, [doc.id,doc.firstName,doc.lastName,doc.phoneNumber]);
    }
}
```