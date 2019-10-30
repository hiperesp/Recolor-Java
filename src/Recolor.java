
public class Recolor {
	public static void main(String[] args) {
		
		//add color
		System.out.println("add color");
		new Color(0xff0000).add(new Color(0x00ff00)).println();
		System.out.println();
		
		//remove color
		System.out.println("remove color");
		new Color(0xff0000).remove(new Color(0x00ff00)).println();
		System.out.println();
		
		//blend colors
		System.out.println("blend colors");
		new Color(0xff0000).blend(new Color(0x00ff00)).println();
		System.out.println();
		
		//invert color
		System.out.println("invert color");
		new Color(0xff0000).invert().println();
		System.out.println();
		
		//increase contrast level
		System.out.println("increase contrast level");
		new Color(0xff8000).addContrast(0x80).println();
		System.out.println();
		
		//decrease contrast level
		System.out.println("decrease contrast level");
		new Color(0xff8000).reduceContrast(0x80).println();
		System.out.println();
		
		//increase brigthness level
		System.out.println("increase brightness level");
		new Color(0xff8000).increaseBrightness(0x80).println();
		System.out.println();
				
		//decrease brigthness level
		System.out.println("decrease brightness level");
		new Color(0xff8000).decreaseBrightness(0x80).println();
		System.out.println();
		
		//generate gradient
		System.out.println("generate gradient");
		Color[] gradient = Color.gradient(new Color(0xff0000), new Color(0x00ff00), 10);
		for(int i=0; i<gradient.length; i++) {
			gradient[i].print();
			if(i!=gradient.length-1) System.out.print(", ");
		}
		System.out.println();
	}
}
