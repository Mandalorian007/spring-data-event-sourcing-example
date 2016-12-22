# spring-data-event-sourcing-example
Spring data eventsourcing example project

Example project for: https://github.com/Mandalorian007/spring-data-eventsourcing/

Setting up Couchbase

*  Default bucket primary index
    *  CREATE PRIMARY INDEX ON `default` USING GSI;
*  couchbaseDomainEventWrapper view
    *  all
```
function (doc, meta) {
    if (doc._class == 'org.springframework.data.eventsourcing.event.store.CouchbaseDomainEventWrapper') {
        emit(doc.name, [doc.id,doc.clazz,doc.domainEvent]);
    }
}
```
*  profile view
    *  all
```
function (doc, meta) {
    if (doc._class == 'com.mcf7.eventsourcing.test.data.model.Profile') {
        emit(doc.name, [doc.id,doc.firstName,doc.lastName,doc.phoneNumber]);
    }
}
```