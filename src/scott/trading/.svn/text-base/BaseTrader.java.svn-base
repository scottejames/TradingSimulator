package scott.trading;

import org.apache.log4j.Logger;


public abstract class BaseTrader implements Runnable {

    private static Logger _logger = Logger.getLogger(BaseTrader.class);

	private long _sleepTime = 10;
	private OrderDispatcher _orderDispatcher = new OrderDispatcher();
	
	public BaseTrader() {

	}

	public BaseTrader(long sleepTime) {
		_sleepTime = sleepTime;

	}

	public Boolean _isTrading = true;

	public void run() {
		try {
			while (_isTrading == true) {

				Thread.sleep(_sleepTime);
				
				Order order = generateOrder();
				
				_logger.debug(this + " Sending in an order " + order);
				_orderDispatcher.push(order);
			}
		}  catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void stopTrading() {
		_isTrading = false;
	}


	public void trade(Market market) {
		_logger.debug(this + " Starting to trade" );
		_orderDispatcher.addReciever(market);
		// Start thread
		_isTrading = true;

		Thread thread = new Thread(this);
		thread.start();
	}

	public abstract Order generateOrder();
		
	

}
