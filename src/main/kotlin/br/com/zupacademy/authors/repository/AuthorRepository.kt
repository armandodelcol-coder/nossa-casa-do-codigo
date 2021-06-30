package br.com.zupacademy.authors.repository

import br.com.zupacademy.authors.entities.Author
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface AuthorRepository : JpaRepository<Author, Long> {

    fun findByCode(code: String): Optional<Author>

}
