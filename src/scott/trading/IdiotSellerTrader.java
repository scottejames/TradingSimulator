package scott.trading;

public class IdiotSellerTrader extends BaseTrader {

	public IdiotSellerTrader(long i) {
		super(i);
	}
	@Override
	public Order generateOrder() {
		return new Order(10,"ABC",100,Order.DIRECTION.SELL);
	}

}
