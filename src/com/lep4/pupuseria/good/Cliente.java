package com.lep4.pupuseria.good;


public class Cliente {

	public static void main(String[] args) {
	
				Pupuseria local =  new Pupuseria(new PupuseriaOlocuilta());
				
				local.ordenarPupusa("Chicharron");
				local.ordenarPupusa("Loroco");
				local.ordenarPupusa("Revuelta");
				local.ordenarPupusa("FrijolConQueso");
				local.ordenarPupusa("Queso");
				local.ordenarPupusa("TamalDeElote");

				//Se debe apagar la plancha al final del dia
				local.cerrarPupuseria();
				
				
	}

}
