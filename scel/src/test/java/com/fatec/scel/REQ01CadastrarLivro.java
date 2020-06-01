package com.fatec.scel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Set;
import com.fatec.scel.model.Livro;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

class REQ01CadastrarLivro {
	private static Validator validator;

	@BeforeAll
	public static void setupValidatorInstance() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@Test
	void quando_atributos_preenchidos_violacao_vazia() {
		Livro livro = new Livro("1111", "Engenharia", "Pressman");
		Set<ConstraintViolation<Livro>> violations = validator.validate(livro);
		assertThat(violations.size()).isEqualTo(0);
	}

	@Test
	void quando_titulo_vazio_entao_dispara_uma_violacao_de_restricao() {
		Livro livro = new Livro("1111", "", "Pressman");
		Set<ConstraintViolation<Livro>> violations = validator.validate(livro);
		assertThat(violations.size()).isEqualTo(1);
	}

	@Test
	void quando_titulo_caracter_branco_entao_violacao_vazia() {
		Livro livro = new Livro("1111", " ", "Pressman");
		Set<ConstraintViolation<Livro>> violations = validator.validate(livro);
		assertThat(violations.size()).isEqualTo(0);
	}

}
