package br.com.zupacademy.authors.dtos

import br.com.zupacademy.authors.entities.Author
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
class UpdateAuthorRequest(
    @field:NotBlank val name: String,
    @field:NotBlank @field:Email val email: String,
    @field:NotBlank @field:Size(max = 400) val description: String
) {

    fun updateProperties(author: Author) {
        author.name = name
        author.email = email
        author.description = description
    }

}
