package test;

class GetallenApp {
	public static void main(String args[]) {
		for (int i = 1; i <= 150; i += 15) {
			for (int j = i; j < i + 15; j++) {
				if (j < 100) {
					System.out.print(" ");
					if (j < 10)
						System.out.print(" ");
				}
				System.out.print(" " + j);
			}
			System.out.println();
		}
	}
}