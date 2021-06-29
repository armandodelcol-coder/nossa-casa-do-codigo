package br.com.zupacademy.authors.dtos

data class NewAuthorRequest(
    val name: String,
    val email: String,
    val description: String
)
