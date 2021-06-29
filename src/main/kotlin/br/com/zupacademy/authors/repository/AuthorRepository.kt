package br.com.zupacademy.authors.repository

import br.com.zupacademy.authors.entities.Author
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface AuthorRepository : JpaRepository<Author, Long> {

}
