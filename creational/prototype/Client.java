


public class Client {


	public static void main(String[] argv) {

		Product existingObject = new Product();

		Product newObj = existingObject.clone();


		Product anotherObject = Registry.getPrototype("context");

	}

}