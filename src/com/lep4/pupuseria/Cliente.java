package com.lep4.pupuseria;

/**
 * 
 * ***** PUPUSERIA SYSTEM ****
 * El siguiente programa implementa un sistema de una pupuseria, en el cual un cliente podra pedir una pupusa
 * y el sistema se encargara de preparar, cocinar y empaquetar dicha orden de pupusas.
 * 
 * Como programador del sistema debera solucionar los siguientes problemas:
 * 	1) Debera agregar 3 nuevas especialidades de pupusas: FrijolConQueso, Chicharron, Loroco
 *  2) Debera solucionar el problema con el estado de la plancha utilizando [ Singleton ]
 *  3) Debera refactorar el codigo utilizando el [ patron Factory ]
 *  4) La Pupuseria debera servir Tamales utilizando los mimos procesos de una pupusa por lo cual debera utilizar [ Patron Adapter ]
 *  5) Debera crear un escenario en el cual se pidan todas las pupusas e incluso tamal del menu.
 *  6) Se debera apagar la plancha al final de todos los pedidos
 *
 */

public class Cliente {

	public static void main(String[] args) {
		
		//Cliente A pide una pupusa de queso y una revuelta
		Pupusa pupusaQueso = new PupusaDeQueso();
		pupusaQueso.preparar();
		pupusaQueso.cocinar();
		pupusaQueso.empaquetar();
		
		Pupusa pupusaRevuelta= new PupusaRevuelta();
		pupusaRevuelta.preparar();
		pupusaRevuelta.cocinar();
		pupusaRevuelta.empaquetar();
		
		//Cliente B pide solo una revuleta
		Pupusa pupusaRevueltaC2= new PupusaRevuelta();
		pupusaRevueltaC2.preparar();
		pupusaRevueltaC2.cocinar();
		pupusaRevueltaC2.empaquetar();
		
		//Se debe apagar la plancha al final del dia
		
	}

}

abstract class Pupusa {
	String nombre ="";
	
	public void preparar() {
		System.out.println("Preparando pupusa...");
	}
	
	public void cocinar() {
		Plancha plancha = new Plancha();
		
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

class PupusaDeQueso extends Pupusa{

	public PupusaDeQueso() {
		nombre = "Pupusa de Queso";
	}
	
	
}
class PupusaRevuelta extends Pupusa{ 
	public PupusaRevuelta() {
		nombre = "Pupusa Revuelta";
	}
}

class Plancha{
	boolean caliente;
	boolean llena;
	boolean apagada;
	int capacidadMaxima = 5;
	int contadorDePupusas = 0;
	
	public Plancha() {
		System.out.println("Preparando la plancha, calentando ...");
		//En un incio la plancha NO esta llena y se pone a calentar
		this.caliente = false;
		this.llena = false;
		this.contadorDePupusas = 0;
		this.apagada = false;
		calentar();
	}
	
	public void calentar() {
		System.out.println("La plancha se ha calentado ...");
		this.caliente = true;
	}
	
	public void colocar(Pupusa pupusa) {
		if(caliente) {
			if(this.contadorDePupusas < 10) {
				System.out.println("Colocando en la plancha: "+pupusa.getNombre());
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
		this.apagada = true;

	}

	public boolean isCaliente() {
		return caliente;
	}

	public boolean isLlena() {
		return llena;
	}
	

	
	
}
