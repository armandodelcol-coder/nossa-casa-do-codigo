package br.com.zupacademy.authors.controllers

import br.com.zupacademy.authors.dtos.AuthorDetailsResponse
import br.com.zupacademy.authors.dtos.UpdateAuthorRequest
import br.com.zupacademy.authors.entities.Author
import br.com.zupacademy.authors.repository.AuthorRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put
import io.micronaut.validation.Validated
import java.util.*
import javax.validation.Valid

@Validated
@Controller("/autores/{code}")
class UpdateAuthorController(private val authorRepository: AuthorRepository) {

    @Put
    fun update(
        @PathVariable("code") code: String,
        @Body @Valid updateAuthorRequest: UpdateAuthorRequest
    ): HttpResponse<AuthorDetailsResponse> {
        val possibleAuthor: Optional<Author> = authorRepository.findByCode(code)
        if (possibleAuthor.isEmpty) return HttpResponse.notFound()

        val author = possibleAuthor.get()
        updateAuthorRequest.updateProperties(author)
        authorRepository.update(author)
        return HttpResponse.ok(AuthorDetailsResponse(author))
    }

}