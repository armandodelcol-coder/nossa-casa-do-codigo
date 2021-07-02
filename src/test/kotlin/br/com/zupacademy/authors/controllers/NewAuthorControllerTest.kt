package br.com.zupacademy.authors.controllers

import br.com.zupacademy.authors.dtos.NewAuthorRequest
import br.com.zupacademy.httpclients.AddressClient
import br.com.zupacademy.httpclients.dtos.AddressResponse
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import javax.inject.Inject

@MicronautTest
internal class NewAuthorControllerTest {
    @field:Inject
    lateinit var addressClient: AddressClient

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @MockBean(AddressClient::class)
    fun addressMock(): AddressClient {
        return Mockito.mock(AddressClient::class.java)
    }

    @Test
    internal fun `should create new author`() {
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
        val newAuthorRequest = NewAuthorRequest(
            "Armando",
            "atdc@gmail.com",
            "Eh o Armando",
            "12912660",
            "7"
        )
        Mockito.`when`(addressClient.searchInJson(newAuthorRequest.zipcode)).thenReturn(HttpResponse.ok(addressResponse))

        val request = HttpRequest.POST("/autores", newAuthorRequest)
        val response = client.toBlocking().exchange(request, Any::class.java)

        assertEquals(HttpStatus.CREATED, response.status)
        assertTrue(response.headers.contains("Location"))
        assertTrue(response.header("Location")!!.contains("/autores/"))
    }
}