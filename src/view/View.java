package view;

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
			System.out.println("2. Requerimiento 1: Mostrar los N comparendos que ocurrieron más al norte en una lista");
			System.out.println("5. Exit");

		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
}
