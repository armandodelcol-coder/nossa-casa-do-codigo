package br.com.zupacademy.httpclients

import br.com.zupacademy.httpclients.dtos.AddressResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client

@Client("\${address.client.url}")
interface AddressClient {

    @Get("/{cep}/json")
    fun searchInJson(@PathVariable cep: String): HttpResponse<AddressResponse>

    @Get("/{cep}/xml", consumes = [MediaType.APPLICATION_XML])
    fun searchInXml(@PathVariable cep: String): HttpResponse<AddressResponse>

}