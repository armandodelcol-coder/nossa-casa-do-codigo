package br.com.zupacademy.cars

import br.com.zupacademy.cars.dtos.CarRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller
class CarsController {

    @Post("/carros")
    fun register(@Body @Valid carRequest: CarRequest): HttpResponse<Any> {
        return HttpResponse.ok(carRequest)
    }

}