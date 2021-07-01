package br.com.zupacademy.cars.validations

import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import javax.inject.Singleton
import javax.validation.Constraint

@MustBeDocumented
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PlateValidator::class])
annotation class Plate(
    val message: String = "Placa está em um formato inválido"
)

@Singleton
class PlateValidator : ConstraintValidator<Plate, String> {

    override fun isValid(
        value: String?,
        annotationMetadata: AnnotationValue<Plate>,
        context: ConstraintValidatorContext
    ): Boolean {
        if (value == null) return true

        return value.matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}".toRegex())
    }

}
