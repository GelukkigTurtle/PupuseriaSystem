package com.lep4.pupuseria.good;

public class Tamal {
	
	String nombre ="";

	public void preparar() {
		System.out.println("Preparando tamal ...");
	}
	
	public void hechar() {
		Plancha plancha = Plancha.getInstance();
		
		if(plancha.isCaliente() && !plancha.isLlena()) {
			System.out.println("Cocinando el tamal en la plancha");
			plancha.colocar(new TamalAdapter(new TamalDeElote()));
		}
		
	}
	
	public void empaquetar() {
		System.out.println("Empaquetando el tamal");
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
