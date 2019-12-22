package issue.repositories

import io.micronaut.test.annotation.MicronautTest
import issue.domain.Address
import issue.domain.Author
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class AuthorRepositorySpec extends Specification {

    @Inject
    AuthorRepository authorRepository

    void "should save an author"() {
        given:
        def author = new Author(
                name: name,
                address: new Address(city: city),
        )

        when:
        def id = authorRepository.save(author).id
        def result = authorRepository.findById(id).orElse(null)

        then:
        with(result) {
            it.id == id
            it.name == name
            it.address.city == city
        }

        where:
        name = 'John'
        city = 'La Rochelle'
    }
}
