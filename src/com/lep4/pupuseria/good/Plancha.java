package com.lep4.pupuseria.good;

import com.lep4.pupuseria.good.Pupusa;

public class Plancha {
	
	static Plancha instance;
	boolean caliente;
	boolean llena;
	boolean apagada;
	int capacidadMaxima = 5;
	int contadorDePupusas = 0;
	
	private Plancha() {
		System.out.println("Preparando la plancha, calentando ...");
		//En un incio la plancha NO esta llena y se pone a calentar
		this.caliente = false;
		this.llena = false;
		this.contadorDePupusas = 0;
		this.apagada = false;
		calentar();
	}
	
	static public Plancha getInstance() {
		if(instance == null) {
			instance = new Plancha();
		}
		return instance;

	}
	
	public void calentar() {
		System.out.println("La plancha se ha calentado ...");
		this.caliente = true;
	}
	
	public void colocar(Alimento alimento) {
		if(caliente) {
			if(this.contadorDePupusas < 10) {
				System.out.println("Colocando en la plancha: "+alimento.getNombre());
				this.contadorDePupusas++;
			}else {
				System.out.println("No se puede colocar... la plancha esta llena!");
				this.llena = true;
			}
		}else {
			System.out.println("Debe calentar primero la plancha para colocar!");

		}
	}
	
	public void quitar(Pupusa pupusa) {
		System.out.println("Quitando "+pupusa.getNombre() + " de la plancha");
		this.contadorDePupusas--;
		this.llena = false;
	}
	public void apagar() {
		System.out.println("La plancha de ha apagado");
		this.apagada = true;

	}

	public boolean isCaliente() {
		return caliente;
	}

	public boolean isLlena() {
		return llena;
	}
	
}
