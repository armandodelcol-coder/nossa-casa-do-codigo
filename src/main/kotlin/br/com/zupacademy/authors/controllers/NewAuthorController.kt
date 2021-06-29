package br.com.zupacademy.authors.controllers

import br.com.zupacademy.authors.dtos.NewAuthorRequest
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/autores")
class NewAuthorController {

    @Post
    fun register(@Body request: NewAuthorRequest): String {
        return request.toString()
    }

}