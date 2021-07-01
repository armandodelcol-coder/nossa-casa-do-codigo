package br.com.zupacademy.cars.dtos

import br.com.zupacademy.cars.validations.Plate
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@Introspected
data class CarRequest(
    @field:NotBlank val model: String?,
    @field:NotBlank @field:Plate val plate: String?
) {

}
