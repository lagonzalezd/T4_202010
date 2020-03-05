package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar datos");
			System.out.println("2. Ordenar datos con Shell.");
			System.out.println("3. Ordenar datos con MergeSort.");
			System.out.println("4. Ordenar con QuickSort.");
			System.out.println("5. Exit");

		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
}
