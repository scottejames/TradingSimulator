package scott.trading;

public class Order {
	public enum DIRECTION {
		BUY, SELL
	}

	private int _size;
	private String _assetCode;
	private DIRECTION _direction;
	private int _price;

	public Order(int size, String assetCode, int price, DIRECTION direction) {
		_size = size;
		_assetCode = assetCode;
		_price = price;
		_direction = direction;
	}

	public int get_size() {
		return _size;
	}

	public boolean match(Order order) {
		// Trying to match a new order to this, this algorithm is totally naive
		// in so much
		// that it assumes that all order facts must match. Ignoring partial
		// fills
		// and the idea that if I want to sell for 100 and someone wants to buy
		// for 200
		// we could probably do a deal (conversely if I want to sell for 200 and
		// he wants
		// to buy for 100 we probably can't).

		boolean matched = false;

		if (order.get_direction() != _direction) {
			// We know that the orders are opposite directions so CAN match

			if (_assetCode.equals(order.get_assetCode())) {
				// we are trading the same asset
				if (_price == order.get_price()) {
					// prices match
					if (_size == order.get_size()) {
						matched = true;
					}
				}

			}
		}
		return matched;
	}

	public void set_size(int _size) {
		this._size = _size;
	}

	public String get_assetCode() {
		return _assetCode;
	}

	public void set_assetCode(String code) {
		_assetCode = code;
	}

	public int get_price() {
		return _price;
	}

	public void set_price(int _price) {
		this._price = _price;
	}

	public DIRECTION get_direction() {
		return _direction;
	}

	public void set_direction(DIRECTION _direction) {
		this._direction = _direction;
	}

	public String toString() {
		return "[" + _assetCode + ", " + _size + ", " + _price + ", " + get_directionAsString() + "]";
	}

	public String get_directionAsString() {
		if (_direction == DIRECTION.BUY)

			return "Buy";
		else
			return "Sell";
	}

}
