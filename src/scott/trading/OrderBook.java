package scott.trading;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import scott.trading.infra.Pair;

public class OrderBook {
	private static Logger _logger = Logger.getLogger(OrderBook.class);

	public List<Order> orders = new ArrayList<Order>();

	public Pair<Trade,Trade> fill(Order fillOrder) {
		
		Pair<Trade,Trade> results = null;
			for(int i = 0; i < orders.size();i++)
			{
				Order order = orders.get(i);
				
				if (order.match(fillOrder) == true)
				{
					_logger.debug("Orderbook found a match " + fillOrder);
					// we have a hit, we can trade
					orders.remove(i);
					
					Trade buyTrade = new Trade(order.get_size(), order.get_assetCode(), order.get_price(), order.get_direction());
					Trade sellTrade = new Trade(fillOrder.get_size(), fillOrder.get_assetCode(), fillOrder.get_price(), fillOrder.get_direction());
				
					results = new Pair<Trade,Trade>(buyTrade, sellTrade);
					
					// DANGER .. this algorithm is weak.  its is generally dangerous
					// to loop over a list and remove elements while you are looping
					// unless you are using an appropriate enumerator.  The break will 
					// make it work but its a hack
					
					break;
				}
			
			}
			
	
		return results;
	}

	public void add(Order order) {
		_logger.debug("Adding order to orderbook");
		
		orders.add(order);
	}

}
