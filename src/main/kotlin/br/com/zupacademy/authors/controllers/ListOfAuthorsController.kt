package br.com.zupacademy.authors.controllers

import br.com.zupacademy.authors.dtos.AuthorDetailsResponse
import br.com.zupacademy.authors.repository.AuthorRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

@Controller("/autores")
class ListOfAuthorsController(private val authorRepository: AuthorRepository) {

    @Get
    fun listAll(
        @QueryValue(defaultValue = "") email: String,
        pageable: Pageable
    ): MutableHttpResponse<Page<AuthorDetailsResponse>>? {
        if (email.isBlank()) {
            val authors = authorRepository.findAll(pageable)
            return HttpResponse.ok(authors.map { author -> AuthorDetailsResponse(author) })
        }

        val authors = authorRepository.findByEmailContaining(email, pageable)
        return HttpResponse.ok(authors.map { author -> AuthorDetailsResponse(author) })
    }

}