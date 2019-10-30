
public class Color implements ColorConstants {
	private int color;
	
	public Color() {
		setColor(MAX_COLOR);
	}
	public Color(Color color) {
		setColor(color);
	}
	public Color(int rgb) {
		setColor(rgb);
	}
	public Color(float rgb) {
		setColor(rgb);
	}
	public Color(int red, int green, int blue) {
		setColor(red, green, blue);
	}
	public Color(float red, float green, float blue) {
		setColor(red, green, blue);
	}
	public Color setColor(Color color) {
		return setColor(color.getColor());
	}
	public Color setColor(int rgb) {
		color = rgb;
		return this;
	}
	public Color setColor(float rgb) {
		return setColor((int)(rgb*MAX_COLOR));
	}
	public Color setColor(int red, int green, int blue) {
		return setColor((int)(red*MULT_RED+green*MULT_GREEN+blue*MULT_BLUE));
	}
	public Color setColor(float red, float green, float blue) {
		return setColor((int)(red*MAX_COLOR_LEVEL), (int)(green*MAX_COLOR_LEVEL), (int)(blue*MAX_COLOR_LEVEL));
	}
	public int getColor() {
		return color;
	}
	public int getRed() {
		return getColor()/MULT_RED;
	}
	public int getGreen() {
		return (getColor()-getRed()*MULT_RED)/MULT_GREEN;
	}
	public int getBlue() {
		return (getColor()-getRed()*MULT_RED-getGreen()*MULT_GREEN)/MULT_BLUE;
	}
	public Color setRed(int red) {
		return setColor(red, getGreen(), getBlue());
	}
	public Color setGreen(int green) {
		return setColor(getRed(), green, getBlue());
	}
	public Color setBlue(int blue) {
		return setColor(getRed(), getGreen(), blue);
	}
	public String getRawHexadecimalValue() {
		String value;
		for(value = Integer.toHexString(color); value.length()<3*MAX_COLOR_LEVEL_LENGTH; value = "0"+value);
		return value;
	}
	public String getHTMLHexadecimalValue() {
		return "#"+getRawHexadecimalValue();
	}
	public String getHexadecimalValue() {
		return "0x"+getRawHexadecimalValue();
	}
	public String getRGBValue() {
		return "rgb("+getRed()+", "+getGreen()+", "+getBlue()+")";
	}
	public Color invert() {
		setColor(MAX_COLOR-getColor());
		return this;
	}
	public Color blend(Color color2) {
		return blend(color2, MAX_COLOR_LEVEL);
	}
	public Color blend(Color color2, int level) {
		int newRed = (int)(getRed()*(1-(float)level/MAX_COLOR_LEVEL)+color2.getRed()*((float)level/MAX_COLOR_LEVEL));
		int newGreen = (int)(getGreen()*(1-(float)level/MAX_COLOR_LEVEL)+color2.getGreen()*((float)level/MAX_COLOR_LEVEL));
		int newBlue = (int)(getBlue()*(1-(float)level/MAX_COLOR_LEVEL)+color2.getBlue()*((float)level/MAX_COLOR_LEVEL));
		return setColor(newRed, newGreen, newBlue);
	}
	public Color add(Color color2) {
		int newRed = Math.min(getRed()+color2.getRed(), MAX_COLOR_LEVEL);
		int newGreen = Math.min(getGreen()+color2.getGreen(), MAX_COLOR_LEVEL);
		int newBlue = Math.min(getBlue()+color2.getBlue(), MAX_COLOR_LEVEL);
		return setColor(newRed, newGreen, newBlue);
	}
	public Color remove(Color color2) {
		int newRed = Math.max(getRed()-color2.getRed(), 0);
		int newGreen = Math.max(getGreen()-color2.getGreen(), 0);
		int newBlue = Math.max(getBlue()-color2.getBlue(), 0);
		return setColor(newRed, newGreen, newBlue);
	}
	public Color addContrast(int level) {
		float multiplier = 1+(float)level/MAX_COLOR_LEVEL;
		int newRed = Math.min((int)(getRed()*multiplier), MAX_COLOR_LEVEL);
		int newGreen = Math.min((int)(getGreen()*multiplier), MAX_COLOR_LEVEL);
		int newBlue = Math.min((int)(getBlue()*multiplier), MAX_COLOR_LEVEL);
		return setColor(newRed, newGreen, newBlue);
	}
	public Color reduceContrast(int level) {
		return addContrast(MAX_COLOR_LEVEL-level);
	}
	public Color increaseBrightness(int level) {
		int newRed = Math.min((int)(getRed()+level), MAX_COLOR_LEVEL);
		int newGreen = Math.min((int)(getGreen()+level), MAX_COLOR_LEVEL);
		int newBlue = Math.min((int)(getBlue()+level), MAX_COLOR_LEVEL);
		return setColor(newRed, newGreen, newBlue);
	}
	public Color decreaseBrightness(int level) {
		int newRed = Math.max((int)(getRed()-level), 0);
		int newGreen = Math.max((int)(getGreen()-level), 0);
		int newBlue = Math.max((int)(getBlue()-level), 0);
		return setColor(newRed, newGreen, newBlue);
	}
	public Color hue() {
		//to do;
		return this;
	}
	public Color print() {
		System.out.print(getRawHexadecimalValue());
		return this;
	}
	public Color println() {
		print();
		System.out.println();
		return this;
	}
	public static Color[] gradient(Color from, Color to, int steps) {
		Color[] colors = new Color[steps];
		int widthScale = MAX_COLOR_LEVEL/(steps-1);
		for(int i=0; i<steps; i++) {
			colors[i] = new Color(from).blend(to, i*widthScale);
		}
		return colors;
	}
}
