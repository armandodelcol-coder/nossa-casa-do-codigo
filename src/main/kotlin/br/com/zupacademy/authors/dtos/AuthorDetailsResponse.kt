package br.com.zupacademy.authors.dtos

import br.com.zupacademy.authors.entities.Author

class AuthorDetailsResponse(
    val code: String,
    val name: String,
    val email: String,
    val description: String
) {

    constructor(author: Author): this(
        code = author.code,
        name = author.name,
        email = author.email,
        description = author.description
    )

}
