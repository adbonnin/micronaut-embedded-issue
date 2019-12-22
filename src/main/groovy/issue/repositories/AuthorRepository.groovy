package issue.repositories

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import issue.domain.Author

@JdbcRepository(dialect = Dialect.H2)
interface AuthorRepository extends CrudRepository<Author, Integer> {
}
