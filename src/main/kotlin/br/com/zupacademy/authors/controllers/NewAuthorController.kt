package br.com.zupacademy.authors.controllers

import br.com.zupacademy.authors.dtos.NewAuthorRequest
import br.com.zupacademy.authors.repository.AuthorRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import java.net.URI
import javax.validation.Valid

@Validated
@Controller("/autores")
class NewAuthorController(val authorRepository: AuthorRepository) {

    @Post
    fun register(@Body @Valid request: NewAuthorRequest): HttpResponse<Any> {
        println(request)
        val author = request.toAuthor()
        authorRepository.save(author)
        val uri: URI = UriBuilder.of("/autores/{id}").expand(mutableMapOf(Pair("id", author.id)))
        return HttpResponse.created(uri)
    }

}