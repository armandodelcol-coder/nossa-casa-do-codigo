package br.com.zupacademy.authors.dtos

import br.com.zupacademy.authors.entities.Author

class AuthorDetailsResponse(author: Author) {

    val id = author.id
    val name = author.name
    val email = author.email
    val description = author.description

}
