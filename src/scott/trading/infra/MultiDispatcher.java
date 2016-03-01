package scott.trading.infra;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class MultiDispatcher<T> implements IDispatcher<T>
{
    private static Logger _logger = Logger.getLogger(DirectDispatcher.class);
    private final List<IReciever<T>> receiver = new ArrayList<IReciever<T>>();
    public MultiDispatcher()
    {
    }
    public void addReciever(IReciever<T> r)
    {
		_logger.debug("Adding reciever " + r);

        receiver.add(r);
    }
    public void removeReciever(IReciever<T> r)
    {
		_logger.debug("Removing reciever " + r);

        receiver.remove(r);
    }
    private void pushToList(List<T> events)
    {
		_logger.debug("PushToList to reciever list " + events);

        for (IReciever<T> r : receiver)
        {
            r.received(events);
        }
    }

    public void push(T object) throws NullPointerException
    {
        if (object == null)
            throw new NullPointerException();
        List<T> events = new ArrayList<T>();
        events.add(object);
        this.pushToList(events);
    }

    public void push(List<T> events) throws NullPointerException
    {
        this.pushToList(events);
    }
}
