package com.lep4.pupuseria.good;

import com.lep4.pupuseria.good.Plancha;

public class Pupusa implements Alimento {
	
	String nombre ="";
	
	public void preparar() {
		System.out.println("Preparando pupusa...");
	}
	
	public void cocinar() {
		Plancha plancha = Plancha.getInstance();
		
		if(plancha.isCaliente() && !plancha.isLlena()) {
			System.out.println("Cocinando pupusa en la plancha");
			plancha.colocar(this);
		}
		
	}
	
	public void empaquetar() {
		System.out.println("Empaquetando la pupusa");
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
