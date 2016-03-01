package scott.trading.infra;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;



public class DirectDispatcher<T> implements IDispatcher<T>

{
	private IReciever<T> receiver;
    private static Logger _logger = Logger.getLogger(DirectDispatcher.class);

	
    public DirectDispatcher()
    {
    }


	public void push(T object) throws NullPointerException {
		_logger.debug("Sending object " + object);
		if (object == null)
			throw new NullPointerException();
		List<T> events = new ArrayList<T>();
		events.add(object);
		this.receiver.received(events);
	}

	public void push(List<T> events) throws NullPointerException {
		_logger.debug("Sending object " + events);

		this.receiver.received(events);
	}

	public void addReciever(IReciever<T> r) {
		_logger.debug("Adding reciever " + r);

		if (r == null)
			throw new NullPointerException();
		this.receiver = r;
	}

	public void removeReciever(IReciever<T> r) {
		_logger.debug("Removing reciever " + r);

		this.receiver = null;
	}
}
