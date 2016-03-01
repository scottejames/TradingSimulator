package scott.trading;

import java.util.List;

import org.apache.log4j.Logger;

import scott.trading.infra.IReciever;

public class TradeServices implements IReciever<Trade>
{
	private static Logger _logger = Logger.getLogger(TradeServices.class);

	public void listen(Market market) {
		market.listenToTrades(this);
	}

	public void received(List<Trade> trades) {
		for (int i = 0 ; i < trades.size(); i++)
		{
			_logger.info("TradeServices recieved trade : " + trades.get(i));
		}
	}

}
