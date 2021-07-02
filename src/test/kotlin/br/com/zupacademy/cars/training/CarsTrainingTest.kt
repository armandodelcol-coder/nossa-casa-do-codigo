package br.com.zupacademy.cars.training

import br.com.zupacademy.cars.entities.Car
import br.com.zupacademy.cars.repository.CarRepository
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest(rollback = false)
class CarsTrainingTest {
    @Inject
    lateinit var carRepository: CarRepository

    @BeforeEach
    internal fun setUp() {
        carRepository.deleteAll()
    }

    @Test
    internal fun `should insert new car`() {
        carRepository.save(Car(model = "Gol", plate = "AAA9988"))
        assertEquals(1, carRepository.count())
    }

    @Test
    internal fun `should find by plate`() {
        val plate = "AAA7777"
        carRepository.save(Car(model = "Palio", plate = plate))
        val result = carRepository.existsByPlate(plate)
        assertTrue(result)
    }
}