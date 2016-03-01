package scott.trading;

import scott.trading.Order.DIRECTION;

public class Trade {



	private int _size;
	private String _assetCode;
	private DIRECTION _direction;
	private int _price;

	

	public Trade(int size, String assetCode, int price, DIRECTION direction) {
		_size = size;
		_assetCode = assetCode;
		_price = price;
		_direction = direction;
	}

	public int get_size() {
		return _size;
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
