package view;

public class View 
{

		public void printMenu()
		{
			System.out.println("======================================================================================================");
			System.out.println("| "+"1. Cargar todos los datos (Hacer esto antes de usar cualquier otra opcion)                         |");
			System.out.println("| "+"2. Cargar datos en Cola de prioridad implementada con heap y cola                                  |");
			System.out.println("| "+"3. Requerimiento 1: Mostrar los N comparendos que ocurrieron más al norte en una lista con Heap    |");
			System.out.println("| "+"4. Requerimiento 2: Mostrar los N comparendos que ocurrieron más al norte en una lista con Cola    |");
			System.out.println("| "+"5. Exit                                                                                            |"); 
			System.out.println("======================================================================================================");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		
		//Cargar todo
		public void tiempoDeCarga(String tiempo)
		{
			System.out.println("------- Tiempo de carga de todos los datos: "+ tiempo + " --------");
		}
		
		public void printDatosCargadosSolo(String num)
		{
			System.out.println("------- Numero de datos cargados: "+ num + " -------");
		}
		
		//Cargar parte 1:
		
		public void printCargar01()
		{
			System.out.println(">>> Ingrese la cantidad de datos a cargar en cola de prioridad");
		}
		
		public void printCargar02(String tiempo, String tipo)
		{
			System.out.println("------- Tiempo de carga en " + tipo + ": " + tiempo + " -------------");
		}
		
		public void printDatosCargados(String num, String tipo)
		{
			System.out.println("------- Numero de datos cargados en " + tipo +": "+ num + " -------");
		}
		
		
		//REQ1 parte 1: numero de comparendos.
		public void printReq1part1()
		{
			System.out.println(">>> Ingrese el numero de comparendos que desea buscar");
		}
		
		//REQ2 parte 2: lista de comparendos
		public void printReq1part2()
		{
			System.out.println(">>> Ingrese una lista con el tipo de vehiculo que desea buscar separado por una coma (,) sin poner espacios");
		}
		
}
