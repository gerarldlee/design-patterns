
public class SonyTelevision implements Television {

	private void reproduceWithGoodColors() {
		System.out.println("- Printing better color.");
	}


	public void playMovie() {
		System.out.println("You are watching a sony tv.");
		reproduceWithGoodColors();
	}

}