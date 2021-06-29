package br.com.zupacademy.authors.controllers

import br.com.zupacademy.authors.dtos.AuthorDetailsResponse
import br.com.zupacademy.authors.repository.AuthorRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/autores")
class ListOfAuthorsController(private val authorRepository: AuthorRepository) {

    @Get
    fun listAll(): HttpResponse<List<AuthorDetailsResponse>> {
        val authors = authorRepository.findAll()
        return HttpResponse.ok(authors.map { author -> AuthorDetailsResponse(author) })
    }

}