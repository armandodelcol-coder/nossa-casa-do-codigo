package br.com.zupacademy.authors.repository

import br.com.zupacademy.authors.entities.Author
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import java.util.*

@Repository
interface AuthorRepository : JpaRepository<Author, Long> {

    fun findByEmailContaining(email: String, pageable: Pageable): Page<Author>

    fun findByCode(code: String): Optional<Author>

}
