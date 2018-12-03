

public class Client {


	public static void main(String[] argv) {

		AbstractFactory factory1 = new ConcreteFactory1();

		ProductA productAFactory1 = factory1.createProductA();
		ProductB productBFactory1 = factory1.createProductB();

	}

}