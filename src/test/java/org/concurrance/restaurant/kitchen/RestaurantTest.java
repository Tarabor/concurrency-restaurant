package org.concurrance.restaurant.kitchen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.concurrance.restaurant.model.Info;
import org.concurrance.restaurant.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestaurantTest {
	
	@Autowired
	RestaurantService service;
	
	@Test
	public void receiveOrder() {
		Order order = new Order();
		order.setTable(1);
		String s = "salad";
		List<String> food = new ArrayList<String>();
		food.add(s);
		order.setFood(food);
		Info info = service.receiveOrder(order);
		assertNotNull(info);
		assertEquals("order received", info.getInfo());
	}
	
	@Test
	public void receiveEmptyOrder() {
		Order order = new Order();
		Info info = service.receiveOrder(order);
		assertNotNull(info);
		assertEquals("empty order", info.getInfo());
	}
	
	@Test
	public void receiveMissingOrder() {
		Order order = new Order();
		order.setTable(1);
		String s = "spaghetti";
		List<String> food = new ArrayList<String>();
		food.add("spaghetti");
		order.setFood(food);
		Info info = service.receiveOrder(order);
		assertNotNull(info);
		assertEquals("Dish " + s + " not in menu, please make another choise", info.getInfo());
	}

}
