package org.concurrance.restaurant.kitchen;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.concurrance.restaurant.model.CookedDish;
import org.concurrance.restaurant.model.Dish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class KitchenTest {
	
	@Autowired
	KitchenService kitchen;
	
	@Autowired
	@Qualifier("queue")
	private BlockingQueue<Dish> queue;
	
	@Autowired
	@Qualifier("cookedDishes")
	private List<CookedDish> list;
	
	@Autowired
	@Qualifier("chefs")
	private Integer numChefs;
	
	@Test
	public void setChef() {
		kitchen.setChef();
		assertNotNull(numChefs);
		assertNotNull(queue);
		assertNotNull(list);
	}	
	
}
