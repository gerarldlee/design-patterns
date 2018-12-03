
/**
 * Concrete factory class for ProductA & B - 1
 */
public ConcreteFactory1 implements AbstractFactory {


	public ProductA createProductA() {
		return new ProductAImpl1();
	}

	public ProductB createProductB() {
		return new ProductBImpl1();
	}

}