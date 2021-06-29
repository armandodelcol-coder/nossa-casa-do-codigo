package br.com.zupacademy.authors.entities

class Author(
    private val name: String,
    private val email: String,
    private val description: String
) {

    override fun toString(): String {
        return "Author(name='$name', email='$email', description='$description')"
    }

}
