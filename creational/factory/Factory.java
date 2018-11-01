

public class Factory {


    /**
     * This is another way to create factory.
     * The object creation is delegated to this methid by context
     * @param preference
     * @return
     */
	public static Television buyTelevision(String preference) {
		if ("quality".equalsIgnoreCase(preference)) {
		    return new SonyTelevision();
        }
        else {
            return new GenericTelevision();
        }
	}

	public static void main(String[] argv) {

		Television tv = Factory.buyTelevision("quality");

		tv.playMovie();

	}

}