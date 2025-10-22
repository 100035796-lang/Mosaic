import java.awt.Color;

public class MosaicExperimenter {
	
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
	public static final Color[] COLOR_CYCLE = {
			Color.RED,
			Color.CYAN,
			Color.YELLOW,
			Color.WHITE,
			Color.GREEN,
			Color.BLUE,
			Color.MAGENTA,
			Color.BLACK
	};
	public static void main(String[] args) {
		System.out.println("How many rows do you want the box to be?");
		int rows = TextIO.getlnInt();
		
		System.out.println("And how about columns?");
		int cols = TextIO.getlnInt();
		
		int height = 40;
		int width = 40;
		
		Mosaic.open(rows,cols,width,height);
		fillMosaic(Color.BLACK, rows, cols);
		
		for (int row = 0; row < rows; rows++) {
			System.out.println("Enter colors for row" + (row + 1) + "Use rcywgm for colors, anything else will be turned to black");
			String input = TextIO.getln();
			
			for (int col = 0; col < cols; col++) {
				Color color;
				if (col < input.length()) {
					color = getColorFromChar(input.charAt(col)) {
					} else {
						color = Color.BLACK;
					}
					Mosaic.setColor(row, col, color);
				}
			}
		}
		public static void fillMosaic(Color color, int rows, int cols) {
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					Mosaic.setColor(r,c,color);
				}
			}
		}
}