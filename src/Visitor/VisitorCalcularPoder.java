package Visitor;

import Domain.*;

public class VisitorCalcularPoder implements IVisitor {

	@Override
	public int visit(Pokemon p) {
		
		if(p.getCantEnergia()==0) {
			return 0;
		}		
		return ((p.getDano()/p.getCantEnergia())*100);
	}

	@Override
	public int visit(Item i) {
		return (i.getBonificacion()*20);
	}

	@Override
	public int visit(Supporter s) {
		return ((s.getEfectosPorTurno()*50));
	}

	@Override
	public int visit(Energy e) {
		return ((1));
	}

	

}
