package scott.trading.infra.test.stubs;

import java.util.List;

import scott.trading.infra.IReciever;

public class TestReciever implements IReciever<TestEvent>{

	private List<TestEvent> _recievedList = null;
	public List<TestEvent> get_recievedList() {
		return _recievedList;
	}
	public void set_recievedList(List<TestEvent> list) {
		_recievedList = list;
	}
	public void received(List<TestEvent> events) {
		
		_recievedList = events;
	}

}
