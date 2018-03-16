package test;

class VaderZoon

{

	public static void main(String args[])

	{

		int leeftijdVader = 50, leeftijdZoon = 20;
		double lengteVader = 1.80, lengteZoon = 1.90;
		if (leeftijdVader > leeftijdZoon)
		{
			System.out.println("Vader is ouder dan zoon");
			if (lengteVader > lengteZoon)
				System.out.println("Vader is ook langer dan zoon");
			else
				System.out.println("Zoon is langer dan vader");
		}
		else
		{
			System.out.println("Dit kan niet!");
			System.out.println("Nader genetisch onderzoek is geboden!");
		}
	}
}