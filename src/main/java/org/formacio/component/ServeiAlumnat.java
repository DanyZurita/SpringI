package org.formacio.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServeiAlumnat {

	@Autowired
	private RepositoriAlumnes bbdd;
	/**
	 * ha de donar d'alta a la base de dades d'alumnes l'alumne indicat amb 
	 * el corresponent codi.
	 * Si el nom de l'alumne es null, no l'ha de donar d'alta
	 * Retorna true si l'alumne s'ha inserit, false si no.
	 */
	public boolean matricula (int id, String alumne) {
		if (alumne != null) {
			bbdd.altaAlumne(id, alumne);
			return true;
		}
		else {
			return false;
		}
	}
	
	@PostConstruct
	public void init() {
		this.inicializarAlumnos();
	}
	
	public void inicializarAlumnos() {
		
		String[] alumnes = { "Antonia", "Joan" };
		final byte i = 1;

		short posicio = i;
		for (String alumne : alumnes) {
			bbdd.altaAlumne((int) posicio, alumne);
			posicio += 1;
		}
	}
	
}
