package issue.domain

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation

@MappedEntity
class Author {

    @Id
    @GeneratedValue
    Integer id

    String name

    @Relation(Relation.Kind.EMBEDDED)
    Address address
}
