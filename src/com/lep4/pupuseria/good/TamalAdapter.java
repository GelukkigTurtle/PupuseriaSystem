package com.lep4.pupuseria.good;

public class TamalAdapter implements Alimento{
	Tamal tamal;
	
	
	
	public TamalAdapter(Tamal tamal) {
		super();
		this.tamal = tamal;
	}

	@Override
	public void preparar() {
		tamal.preparar();	
	}

	@Override
	public void cocinar() {
		tamal.hechar();
	}

	@Override
	public void empaquetar() {
		tamal.empaquetar();
	}

	@Override
	public String getNombre() {
		return tamal.getNombre();
	}

}
