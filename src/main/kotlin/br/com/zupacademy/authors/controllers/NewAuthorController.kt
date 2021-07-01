package br.com.zupacademy.authors.controllers

import br.com.zupacademy.authors.dtos.NewAuthorRequest
import br.com.zupacademy.authors.repository.AuthorRepository
import br.com.zupacademy.httpclients.AddressClient
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
class NewAuthorController(
    val authorRepository: AuthorRepository,
    val addressClient: AddressClient
) {

    @Post
    fun register(@Body @Valid request: NewAuthorRequest): HttpResponse<Any> {
        val addressResponse = addressClient.searchInJson(request.zipcode)
        // val addressResponse = addressClient.searchInXml(request.zipcode)
        val author = request.toAuthor(addressResponse.body())
        authorRepository.save(author)
        val uri: URI = UriBuilder.of("/autores/{code}").expand(mutableMapOf(Pair("code", author.code)))
        return HttpResponse.created(uri)
    }

}