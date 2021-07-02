package br.com.zupacademy.cars.entities

import javax.persistence.*

@Entity
@Table(name = "tb_car")
class Car(
    @Column(nullable = false)
    var model: String,

    @Column(nullable = false, unique = true)
    var plate: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}