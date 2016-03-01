package scott.trading;

import scott.trading.infra.SWTGlobals;

public class Simulator {

	public static void main(String [] args)
	{
		
		BaseTrader traderOne = new IdiotBuyerTrader(1000);
		BaseTrader traderTwo = new IdiotSellerTrader(1000);
		
		TradeServices tradeServices = new TradeServices();
		PositionServices posServices = new PositionServices();
		
		Market market = new Market();

		posServices.listen(tradeServices);
		tradeServices.listen(market);
		
		traderOne.trade(market);
		traderTwo.trade(market);
		
		OrderBookViewer orderBookViewer = new OrderBookViewer();
		SWTGlobals.startSWT();
		
		
	}
}
