import java.util.ArrayList;
import java.util.Scanner;

public class Pizzeria {

	public static void preparerPizza(Pizza quellePizza)
	{
		System.out.println("La pizza " + quellePizza.pizzaName() + " est préparée...");
	}

	public static void cuirePizza(Pizza quellePizza)
	{
		System.out.println("La pizza " + quellePizza.pizzaName() + " est cuite...");
	}

	public static void miseEnBoitePizza(Pizza quellePizza)
	{
		System.out.println("La pizza " + quellePizza.pizzaName() + " est mise en boîte...");
	}

	public static void main(String[] args)
	{
		System.out.println("Bienvenue à la pizzeria Kidepote");

		String choixPizza = "";
		String choixStyle = "";
		Pizza pizzaChoisie = null;

		factoryProvider _pizzaFactory = null;

		Scanner scanner = new Scanner(System.in);

		ArrayList<Pizza> commande = new ArrayList<>();
		int totalDu = 0;

		do
		{
			pizzaChoisie = null;

			do
			{
				System.out.println("\nQuelle pizza voulez-vous commander ?");
				System.out.println("[1] Pizza Mozzarella");
				System.out.println("[2] Pizza 4 saisons");
				System.out.println("[3] Pizza aux poireaux");
				System.out.println("[4] Pizza fraises/jambon");
				System.out.println("[X] Quitter");
				choixPizza = scanner.nextLine();
			}
			while ((!choixPizza.equals("1")) &&
					(!choixPizza.equals("2")) &&
					(!choixPizza.equals("3")) &&
					(!choixPizza.equals("4")) &&
					(!choixPizza.toUpperCase().equals("X")));

			if (!choixPizza.equalsIgnoreCase("X"))
				do
				{
					System.out.println("\nQuelle style de pizza voulez-vous commander ?");
					System.out.println("[1] Pizza italienne");
					System.out.println("[2] Pizza NewYorkaise");
					System.out.println("[X] Quitter");
					choixStyle = scanner.nextLine();
				}
				while ((!choixStyle.equals("1")) &&
						(!choixStyle.equals("2")) &&
						(!choixStyle.toUpperCase().equals("X")));

			if ((!choixPizza.equalsIgnoreCase("X")) && (!choixStyle.equalsIgnoreCase("X")))
				pizzaChoisie = _pizzaFactory.getFactory(choixStyle).getPizza(choixPizza);

			if (pizzaChoisie != null)
			{
				preparerPizza(pizzaChoisie);
				cuirePizza(pizzaChoisie);
				miseEnBoitePizza(pizzaChoisie);
				System.out.println("La pizza " + pizzaChoisie.pizzaName() + " est prête.");
				System.out.println("Ca fait " + pizzaChoisie.prix() + " €");

				commande.add(pizzaChoisie);
				totalDu += pizzaChoisie.prix();
			}

		}
		while(!choixPizza.toUpperCase().equals("X"));

		System.out.println("\n--------------------------------------------------------");
		System.out.println("Recapitulatif de la commande :");
		commande.forEach(pizzaCommandee -> System.out.println(pizzaCommandee.pizzaName()
				+ ", " + pizzaCommandee.prix() + " €"));

		System.out.println("\nPrix total de la commande : " + totalDu + " €");
		System.out.println("Merci de votre visite.");
	}
}