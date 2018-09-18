package com.lep4.pupuseria.good;

public class Pupuseria {
	
	PupuseriaFactory factory;

	public Pupuseria(PupuseriaFactory factory) {
		super();
		this.factory = factory;
	}
	
	public Alimento ordenarPupusa(String tipo) {
		Alimento alimento = factory.crearPupusa(tipo);
		
		if(alimento != null) {
			alimento.preparar();
			alimento.cocinar();
			alimento.empaquetar();
		}else {
			System.out.println("La pupusa de: "+ tipo +" no existe!");
		}
		
		return alimento;
				
	}
	public void cerrarPupuseria() {
		System.out.println("Ultimo pedido tomado, cerrando la pupuseria ...");
		Plancha.getInstance().apagar();
	}

}
