# micronaut_embedded_issue

Create application:
```
mn create-app issue --lang groovy --features application,http-client,http-server,jdbc-hikari,liquibase,logback,spock
```

Stacktrace:
```
17:34:36.364 [Test worker] INFO  l.lockservice.StandardLockService - Successfully released change log lock
17:34:42.193 [Test worker] DEBUG io.micronaut.data.query - Executing SQL Insert: INSERT INTO `author` (`name`,`address_city`) VALUES (?,?)
17:34:42.218 [Test worker] DEBUG io.micronaut.data.query - Executing Query: SELECT author_.`id`,author_.`name`,author_.`address_city` FROM `author` author_ WHERE (author_.`id` = ?)

Error reading object for name [address] from result set: Colonne "address" non trouvée
Column "address" not found [42122-199]
io.micronaut.data.exceptions.DataAccessException: Error reading object for name [address] from result set: Colonne "address" non trouvée
Column "address" not found [42122-199]
	at io.micronaut.data.jdbc.mapper.ColumnNameResultSetReader.exceptionForColumn(ColumnNameResultSetReader.java:206)
	at io.micronaut.data.jdbc.mapper.ColumnNameResultSetReader.getRequiredValue(ColumnNameResultSetReader.java:201)
	at io.micronaut.data.jdbc.mapper.ColumnNameResultSetReader.getRequiredValue(ColumnNameResultSetReader.java:35)
	at io.micronaut.data.runtime.mapper.ResultReader.readDynamic(ResultReader.java:133)
	at io.micronaut.data.runtime.mapper.sql.SqlResultEntityTypeMapper.readEntity(SqlResultEntityTypeMapper.java:323)
	at io.micronaut.data.runtime.mapper.sql.SqlResultEntityTypeMapper.map(SqlResultEntityTypeMapper.java:146)
	at io.micronaut.data.jdbc.operations.DefaultJdbcRepositoryOperations.lambda$findOne$2(DefaultJdbcRepositoryOperations.java:190)
	at io.micronaut.transaction.support.AbstractSynchronousTransactionManager.executeRead(AbstractSynchronousTransactionManager.java:157)
	at io.micronaut.data.jdbc.operations.DefaultJdbcRepositoryOperations.findOne(DefaultJdbcRepositoryOperations.java:174)
	at io.micronaut.data.runtime.intercept.DefaultFindOptionalInterceptor.intercept(DefaultFindOptionalInterceptor.java:47)
	at io.micronaut.data.runtime.intercept.DefaultFindOptionalInterceptor.intercept(DefaultFindOptionalInterceptor.java:34)
	at io.micronaut.data.intercept.DataIntroductionAdvice.intercept(DataIntroductionAdvice.java:79)
	at io.micronaut.aop.chain.MethodInterceptorChain.proceed(MethodInterceptorChain.java:69)
	at issue.repositories.AuthorRepositorySpec.should save an author(AuthorRepositorySpec.groovy:25)
Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: Colonne "address" non trouvée
Column "address" not found [42122-199]
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:451)
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:427)
	at org.h2.message.DbException.get(DbException.java:205)
	at org.h2.message.DbException.get(DbException.java:181)
	at org.h2.jdbc.JdbcResultSet.getColumnIndex(JdbcResultSet.java:3188)
	at org.h2.jdbc.JdbcResultSet.get(JdbcResultSet.java:3287)
	at org.h2.jdbc.JdbcResultSet.getObject(JdbcResultSet.java:533)
	at io.micronaut.data.jdbc.mapper.ColumnNameResultSetReader.getRequiredValue(ColumnNameResultSetReader.java:188)
	... 12 more
```