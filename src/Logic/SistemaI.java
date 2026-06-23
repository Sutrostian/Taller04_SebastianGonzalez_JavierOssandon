package Logic;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import Domain.*;
import Factory.*;
import Strategy.*;
import Visitor.*;

public class SistemaI implements ISistema {
	
	private static ISistema instancia;
	private static ArrayList<Carta> cartas = new ArrayList<Carta>();
	
	private SistemaI() {
	}
	
	public static ISistema getInstancia() {
		if(instancia == null) {
			instancia = new SistemaI();
		}
		return instancia;
	}

	@Override
	
	
	public void mostrarCartas() {
		
		IVisitor visitor = new VisitorCalcularPoder();
		for (Carta c : cartas) {
			int poder = c.accept(visitor);
			System.out.println(c + "Poder: " + poder);
		}
	}

	@Override
	public void getStrategyRareza() {
		IStrategy strategy = new StrategyOrdenarPorRareza();
		IVisitor visitor = new VisitorCalcularPoder();
		ArrayList<Carta> ordenadas = strategy.ordenar(cartas);
		for (Carta c : ordenadas) {
			int poder = c.accept(visitor);
			System.out.println(c + "Poder: " + poder);
		}
		
	}

	@Override
	public void getStrategyPoder() {
		IStrategy strategy = new StrategyOrdenarPorPoder();
		IVisitor visitor = new VisitorCalcularPoder();
		ArrayList<Carta> ordenadas = strategy.ordenar(cartas);
		for (Carta c : ordenadas) {
			int poder = c.accept(visitor);
			System.out.println(c + "Poder: " + poder);
		}
		
	}

	@Override
	public void getStrategyNombre() {
		IStrategy strategy = new StrategyOrdenarPorNombre();
		IVisitor visitor = new VisitorCalcularPoder();
		ArrayList<Carta> ordenadas = strategy.ordenar(cartas);
		for (Carta c : ordenadas) {
			int poder = c.accept(visitor);
			System.out.println(c + "Poder: " + poder);
		}
		
	}

	@Override
	public void eliminarCarta(String nombre) {
		
		for (Carta c : cartas) {
			if(c.getNombre().equalsIgnoreCase(nombre)) {
				cartas.remove(c);
				System.out.println("Carta Eliminada");
				break;
			}
			
		}
		
	}

	@Override
	public ArrayList<Carta> obtenerCartas() {
		return cartas;
	}


	@Override
	public void cargarCartas(String linea) {
		cartas.add(FactoryCartas.crearCartas(linea));
		
	}
	
	@Override
	public void agregarCarta(Carta carta) {
		cartas.add(carta);
		guardarCartas();
	}

	@Override
	public boolean modificarCarta(String nombre, String atributo1, String atributo2) {
		for (Carta c : cartas) {
			if (c.getNombre().equalsIgnoreCase(nombre)) {
				if (c instanceof Pokemon) {
					((Pokemon) c).setDano(Integer.parseInt(atributo1));
					((Pokemon) c).setCantEnergia(Integer.parseInt(atributo2));
				} else if (c instanceof Item) {
					((Item) c).setBonificacion(Integer.parseInt(atributo1));
				} else if (c instanceof Supporter) {
					((Supporter) c).setEfectosPorTurno(Integer.parseInt(atributo1));
				} else if (c instanceof Energy) {
					((Energy) c).setElemento(atributo1);
				}
				guardarCartas();
				return true;
			}
		}
		return false;
	}

	private void guardarCartas() {
		try (PrintWriter writer = new PrintWriter(new FileWriter("Sobres.txt"))) {
			for (Carta c : cartas) {
				String linea;
				if (c instanceof Pokemon) {
					Pokemon p = (Pokemon) c;
					linea = p.getNombre() + ";" + p.getRareza() + ";" + p.getTipo() + ";" + p.getDano() + ";" + p.getCantEnergia();
				} else if (c instanceof Item) {
					Item i = (Item) c;
					linea = i.getNombre() + ";" + i.getRareza() + ";" + i.getTipo() + ";" + i.getBonificacion();
				} else if (c instanceof Supporter) {
					Supporter s = (Supporter) c;
					linea = s.getNombre() + ";" + s.getRareza() + ";" + s.getTipo() + ";" + s.getEfectosPorTurno();
				} else if (c instanceof Energy) {
					Energy en = (Energy) c;
					linea = en.getNombre() + ";" + en.getRareza() + ";" + en.getTipo() + ";" + en.getElemento();
				} else {
					continue;
				}
				writer.println(linea);
			}
		} catch (IOException e) {
			System.out.println("Error al guardar las cartas en el archivo");
		}
	}
}
