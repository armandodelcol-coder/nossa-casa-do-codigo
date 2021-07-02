package br.com.zupacademy.cars.repository

import br.com.zupacademy.cars.entities.Car
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface CarRepository : JpaRepository<Car, Long> {
    fun existsByPlate(plate: String): Boolean
}