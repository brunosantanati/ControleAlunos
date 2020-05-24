package controle.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import controle.ControleAlunosApplication;

@Documented
@Constraint(validatedBy = CodigoTexto.CodigoTextoValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CodigoTexto {
	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	public class CodigoTextoValidator implements ConstraintValidator<CodigoTexto, String> {
		
		@Override
		public void initialize(CodigoTexto contactNumber) {
			
		}

		@Override
		public boolean isValid(String field, ConstraintValidatorContext cxt) {
			return ControleAlunosApplication.CODIGO.equals(field);
		}

	}
}
