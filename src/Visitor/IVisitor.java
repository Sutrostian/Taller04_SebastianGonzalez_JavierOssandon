package Visitor;

import Domain.*;

public interface IVisitor {
	
	int visit (Pokemon p);
	int visit (Item i);
	int visit (Supporter s);
	int visit (Energy e);

}
