package com.lep4.pupuseria.good;


public class PupuseriaOlocuilta extends PupuseriaFactory {

	@Override
	protected Alimento crearPupusa(String tipo) {
		Alimento pupusa = null;
		
		if(tipo.equals("Chicharron")) {
			pupusa =  new PupusaDeChicharron();
		}else if(tipo.equals("FrijolConQueso")) {
			pupusa = new PupusaDeFrijolConQueso();
		}else if(tipo.equals("Loroco")) {
			pupusa = new PupusaDeLoroco();
		}else if(tipo.equals("Queso")) {
			pupusa = new PupusaDeQueso();
		}else if(tipo.equals("Revuelta")) {
			pupusa = new PupusaRevuelta();
		} else if(tipo.equals("TamalDeElote")) {
			pupusa = new TamalAdapter(new TamalDeElote());
		}
		
		return pupusa;
	}

}
