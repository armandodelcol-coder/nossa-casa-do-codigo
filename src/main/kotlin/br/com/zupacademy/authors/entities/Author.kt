package br.com.zupacademy.authors.entities

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
class Author(
    var name: String,
    var email: String,
    var description: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false, unique = true)
    val code: String = UUID.randomUUID().toString()

}
