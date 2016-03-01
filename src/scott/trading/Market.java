package scott.trading;

import java.util.List;

import org.apache.log4j.Logger;

import scott.trading.infra.IReciever;
import scott.trading.infra.Pair;

public class Market implements IReciever<Order> {

	private static Logger _logger = Logger.getLogger(Market.class);
	private OrderBook _orderBook = new OrderBook();
	private TradeDispatcher _tradeDispatcher = new TradeDispatcher();

	public void received(List<Order> orderList) {
		for (int i = 0; i < orderList.size(); i++) {
			Order order = orderList.get(i);
			_logger.debug(this + " recieved an order " + order);

			Pair<Trade,Trade> trades = _orderBook.fill(order);
			if (trades != null)
			{
				_logger.debug("Sending trades to those who care");
				// Tell people we have a trade 
				_tradeDispatcher.push(trades.getLeft());
				_tradeDispatcher.push(trades.getRight());
				

			} else {
				// could not match the trade so add it to the order book
				// Probs should have some kind of id created so we can cancel the order later
				_logger.debug("Unable to fill order adding to orderbook");
				_orderBook.add(order);
			}
		}
	}

	public void listenToTrades(IReciever<Trade> listener) {
		_tradeDispatcher.addReciever(listener);
	}

}
