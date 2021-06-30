package br.com.zupacademy.authors.controllers

import br.com.zupacademy.authors.repository.AuthorRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable

@Controller("/autores/{code}")
class DeleteAuthorController(private val authorRepository: AuthorRepository) {

    @Delete
    fun delete(@PathVariable("code") code: String): HttpResponse<Any> {
        val possibleAuthor = authorRepository.findByCode(code)
        if (possibleAuthor.isEmpty) return HttpResponse.notFound()

        val author = possibleAuthor.get()
        authorRepository.delete(author)
        return HttpResponse.noContent()
    }

}