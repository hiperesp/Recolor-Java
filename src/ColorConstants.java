
public interface ColorConstants {
	public static final int MAX_COLOR_LEVEL = 0xff;
	public static final int MAX_COLOR_LEVEL_LENGTH = (int)Math.round((double)(Math.log(MAX_COLOR_LEVEL)/Math.log(16)));
	public static final int NEW_DIGIT = MAX_COLOR_LEVEL+1;
	public static final int MULT_BLUE = 1;//(int)Math.pow(NEW_DIGIT, 0)
	public static final int MULT_GREEN = NEW_DIGIT;//(int)Math.pow(NEW_DIGIT, 1)
	public static final int MULT_RED = (int)Math.pow(NEW_DIGIT, 2);//(int)Math.pow(NEW_DIGIT, 2)
	public static final int MAX_COLOR = MULT_RED*MAX_COLOR_LEVEL+MULT_GREEN*MAX_COLOR_LEVEL+MULT_BLUE*MAX_COLOR_LEVEL;
}
