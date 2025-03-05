import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// DECLARATION + INITIALIZATION
		int choice = -1;
		boolean tryAgain = true;
		Scanner keyboard = new Scanner(System.in);
		PokemonBox myBox = null;
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
		
		try {
		myBox = new PokemonBox(caught);
		System.out.println("...Done!\n");
	} catch (IllegalArgumentException e) {
		System.out.println("Pokemon Box preload failed. Error: " + e.getMessage());
		}
		System.out.println("---------------------------");
		System.out.println("| Welcome to Pokemon Box! |");
		System.out.println("---------------------------\n");
		System.out.println(myBox);

		
		//INPUT + PROCESSING + OUTPUT
		do {
		try{	
			if (choice == -1) {
			System.out.println("\nMAIN MENU\nWhat would you like to do?");
			System.out.println("\n\t1) Add a New Pokemon \n\t2) List All Pokemon \n\t3) Check on a single Pokemon \n\t4) Exit Program");
			System.out.print("Enter choice number> ");
			choice = keyboard.nextInt();
			if(choice == 0 || choice > 4){
				throw new InputMismatchException();
			}
			} 
			if (choice == 1) {
				System.out.print("Press Enter to continue> ");
				keyboard.nextLine();
				System.out.println("Enter Pokemon Info to be added:");
				System.out.print("Enter Pokemon Name> ");
				String name = keyboard.nextLine();
				System.out.print("Enter Pokemon Type #1> ");
				String type1 = keyboard.nextLine();
				System.out.print("Enter Pokemon Type #2 (none if no second type)> ");
				String type2 = keyboard.nextLine();
				type2 = (type2.equalsIgnoreCase("none")) ? null : type2;

			
				Pokemon p = new Pokemon(name, type1, type2);
				myBox.add(p);
				System.out.println("\n" + name + " added!");
				choice = -1; 
			}else if (choice == 2) {
				System.out.println(myBox);
				choice = -1;
			} else if (choice == 3) {
				Pokemon pokemonForCheckup = new Pokemon();
			
				System.out.print("Enter your Pokemon's box number> ");
				int location = keyboard.nextInt();
				pokemonForCheckup = myBox.getPokemon((location - 1));
				System.out.println(
					pokemonForCheckup.getName() + " : MEEP! (They are in good health and happy to see you!) ");
				choice = -1;
			
			}   else if (choice == 4) {
				keyboard.close();
				tryAgain = false;
			}
		} catch (InputMismatchException e) {
			keyboard.nextLine();
			System.out.println(
				"Enter an Integer between 1-4!");
			choice = -1;
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid Pokemon Data! Get to know your new Pokemon and try again.");
			choice = 1;
		} catch (PokemonAlreadyExistsException e) {
			System.out.println("For ecological reasons, we ask you return that Pokemon to the wild. You already have one in your box! Try again please with another Pokemon.");
			choice = 1;
		} catch (NullPointerException e) {
			keyboard.nextLine();
			System.out.println("There's no Pokemon at that box number! Please refrence the option 2 printout for box numbers");
			choice = -1;
		}

		
	} while (tryAgain == true);

		System.out.println("Thank you for using the Pokemon Box program :D See you later!");
			} 

}
