package monController;

//A class called KeyOrder
public class KeyOrder implements iKeyOrder
{	
	private final Order order;
	
	public KeyOrder(Order order)
	{
		this.order = order;
	}
	
	public Order getOrder()
	{
		return this.order;
	}
}