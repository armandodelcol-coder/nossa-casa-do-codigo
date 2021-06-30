package br.com.zupacademy.authors.dtos

import br.com.zupacademy.authors.entities.Address
import br.com.zupacademy.authors.entities.Author
import br.com.zupacademy.httpclients.dtos.AddressResponse
import io.micronaut.core.annotation.Introspected
import io.micronaut.http.HttpResponse
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class NewAuthorRequest(
    @field:NotBlank val name: String,
    @field:NotBlank @field:Email val email: String,
    @field:NotBlank @field:Size(max = 400) val description: String,
    @field:NotBlank val zipcode: String,
    @field:NotBlank val number: String
) {

    fun toAuthor(addressResponse: AddressResponse): Author {
        val address = Address(addressResponse, number)
        return Author(name, email, description, address)
    }

}
