package br.com.zupacademy.httpclients

import br.com.zupacademy.httpclients.dtos.AddressResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client

@Client("https://viacep.com.br/ws")
interface AddressClient {

    @Get("/{cep}/json/")
    fun search(@PathVariable cep: String): HttpResponse<AddressResponse>

}