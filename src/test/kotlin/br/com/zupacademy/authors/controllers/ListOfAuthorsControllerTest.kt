package br.com.zupacademy.authors.controllers

import br.com.zupacademy.authors.dtos.AuthorDetailsResponse
import br.com.zupacademy.authors.entities.Address
import br.com.zupacademy.authors.entities.Author
import br.com.zupacademy.authors.repository.AuthorRepository
import br.com.zupacademy.httpclients.dtos.AddressResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
internal class ListOfAuthorsControllerTest {

    @field:Inject
    lateinit var authorRepository: AuthorRepository

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    private lateinit var author: Author

    @BeforeEach
    internal fun setUp() {
        val addressResponse = AddressResponse(
            cep = "12912-660",
            logradouro = "Rua Professor Luiz Nardy",
            complemento = "de 235/236 ao fim",
            bairro = "Aparecida",
            localidade = "Bragança Paulista",
            uf = "SP",
            ibge = "3507605",
            gia = "2252",
            ddd = "11",
            siafi = "6251"
        )
        val address = Address(addressResponse, "7")
        author = Author(
            name = "Armando",
            email = "armando.col@zup.com.br",
            description = "backend developer",
            address = address
        )

        authorRepository.save(author)
    }

    @AfterEach
    internal fun tearDown() {
        authorRepository.deleteAll()
    }

    @Test
    internal fun `should return author details`() {
        val response = client.toBlocking().exchange("/autores?email=${author.email}", AuthorDetailsResponse::class.java)
        assertEquals(HttpStatus.OK, response.status)
        assertNotNull(response.body())
        assertEquals(author.name, response.body()!!.name)
        assertEquals(author.email, response.body()!!.email)
        assertEquals(author.description, response.body()!!.description)
    }

}