package Logic;

import java.io.File;
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
}
