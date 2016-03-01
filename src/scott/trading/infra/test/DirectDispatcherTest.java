package scott.trading.infra.test;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import scott.trading.infra.test.stubs.TestDispatcher;
import scott.trading.infra.test.stubs.TestEvent;
import scott.trading.infra.test.stubs.TestReciever;

public class DirectDispatcherTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void sentMessageToSingle(){
		
		TestDispatcher dispatcher = new TestDispatcher();
		TestReciever reciever = new TestReciever();
		
		// assert that we have no events prior to sending
		dispatcher.addReciever(reciever);
		
		assertTrue(reciever.get_recievedList()==null);
		
		TestEvent event = new TestEvent();
		
		dispatcher.push(event);
		
		List<TestEvent> recievedList = reciever.get_recievedList();
		
		assertTrue(recievedList.get(0) == event );
	}
	

}
