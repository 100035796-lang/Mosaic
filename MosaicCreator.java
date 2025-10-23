import java.awt.Color;

public class MosaicCreator {
	
	static Color[] cycle = {Color.RED, Color.CYAN, Color.YELLOW, Color.WHITE, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.BLACK };
	
	public static void main(String[] args) {
		System.out.println("Welcome to Kevin's Mosaic Mess!");
		int rows = getPositiveInt("How many rows do you want?");
		int cols = getPositiveInt("And how about columns?");
		
		int height = 40; // not sure if I actually need this since they're equal but I'll put it here just in case.
		int width = 40;
		
		Mosaic.open(rows,cols,width,height);
		fillMosaic(Color.BLACK, rows, cols);
		
		for (int row = 0; row < rows; row++) {
			System.out.println("Enter colors for row " + (row + 1) + " Use rcywgm for colors, anything else will be turned to black");
			String input = TextIO.getln();
			
			for (int col = 0; col < cols; col++) {
				Color color;
				if (col < input.length()) {
					color = getColorFromChar(input.charAt(col));
					} else {
						color = Color.BLACK;
					}
					Mosaic.setColor(row, col, color);
				}
			}
			System.out.println("Washing cycle start (๑﹏๑//)");
			cycleColors(rows, cols);
	}
		public static int getPositiveInt(String prompt) {
		    int value = 0;
		    while (value <= 0) {
		        System.out.print(prompt);
		        String input = TextIO.getln().trim();

		        if (input.length() == 0) {
		            System.out.println("Give me something, man.");
		        } else if (isInteger(input)) {
		            value = Integer.parseInt(input);
		            if (value <= 0) {
		                System.out.println("Please enter a positive number.");
		            }
		        } else {
		            System.out.println("No bueno. Please enter a number.");
		        }
		    }
		    return value;
		}
		public static Color getColorFromChar(char c) {
			switch (Character.toLowerCase(c)) {
			case'r': return Color.RED;
			case'c': return Color.CYAN;
			case'y': return Color.YELLOW;
			case'w': return Color.WHITE;
			case'g': return Color.GREEN;
			case'b': return Color.BLUE;
			case'm': return Color.MAGENTA;
			default: return Color.BLACK;
			
			}
		}
	public static void fillMosaic(Color color, int rows, int cols) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				Mosaic.setColor(r,c,color);
			}
		}
	}
	public static boolean isInteger(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return s.length() > 0;
	}
	public static void cycleColors(int rows, int cols) {
		while (Mosaic.isOpen()) {
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					Color current = Mosaic.getColor(r,c);
					Color next = getNextColor(current);
					Mosaic.setColor(r,c,next);
				}
			}
			Mosaic.delay(1000);
		}
	}
	public static Color getNextColor(Color current) {
		for (int i = 0; i < cycle.length; i++) {
			if (cycle[i].equals(current)) {
				return cycle[(i+1) % cycle.length];
			}
		}
		return cycle[0];
	}
}