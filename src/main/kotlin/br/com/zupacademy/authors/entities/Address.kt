package br.com.zupacademy.authors.entities

import br.com.zupacademy.httpclients.dtos.AddressResponse
import javax.persistence.Embeddable

@Embeddable
class Address(addressResponse: AddressResponse, val number: String) {

    val street = addressResponse.logradouro
    val neighborhood = addressResponse.bairro
    val city = addressResponse.localidade
    val state = addressResponse.uf

}
