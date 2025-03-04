import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// DECLARATION + INITIALIZATION
		int choice = -1;
		boolean tryAgain = true;
		Scanner keyboard = new Scanner(System.in);
		Pokemon[] caught = {
			new Pokemon("Pikachu", "Electric"),
			new Pokemon("Bulbasaur", "Grass", "Poison"),
			new Pokemon("Charmeleon", "Fire"),
			new Pokemon("Squirtle", "Water"),
			new Pokemon("Butterfree", "Bug", "Flying"),
			new Pokemon("Pidgeotto", "Normal", "Flying")
		};

		// WELCOME
		System.out.println("Preloading Pokemon Box...");
		PokemonBox myBox = new PokemonBox(caught);
		System.out.println("...Done!\n");

		System.out.println("---------------------------");
		System.out.println("| Welcome to Pokemon Box! |");
		System.out.println("---------------------------\n");
		System.out.println(myBox);

		//INPUT + PROCESSING + OUTPUT
		do {
			System.out.println("\nMAIN MENU\nWhat would you like to do?");
			System.out.println("\t1) Add a New Pokemon \n\t2) List All Pokemon \n\t3) Exit Program \n");
			System.out.print("Enter choice number> ");
			try {
			
			choice = keyboard.nextInt();
			if(choice >= 3 || choice == 0){
				throw new IllegalArgumentException("ERROR. Wrong integer added for your choice. Please use integers 1-3");
			} //could throw exception here and skip rest of code
			keyboard.nextLine();
			System.out.println();
			
			if (choice == 1) {
				System.out.println("Enter Pokemon Info to be added:");
				System.out.print("Enter Pokemon Name> ");
				String name = keyboard.nextLine();
				System.out.print("Enter Pokemon Type #1> ");
				String type1 = keyboard.nextLine();
				System.out.print("Enter Pokemon Type #2 (none if no second type)> ");
				String type2 = keyboard.nextLine();
				type2 = (type2.equalsIgnoreCase("none")) ? null : type2;

				try{
				Pokemon p = new Pokemon(name, type1, type2);
				myBox.add(p);
				System.out.println("\n" + name + " added!"); 
			} catch (IllegalArgumentException e) {
					System.out.println("Failed to add Pokemon: " + e.getMessage());
				}				
			} else if (choice == 2) {
				System.out.println(myBox);
			} else if (choice == 3) {
				keyboard.close();
				tryAgain = false;
			} 
		}  catch (IllegalArgumentException e) {
			System.out.println("Unable to continue. Please try again. Error Message: " + e.getMessage());
	}

} while (tryAgain == true);
		if (tryAgain == false) {
		System.out.println("Thank you for using the Pokemon Box program :D See you later!");
	}
}
}