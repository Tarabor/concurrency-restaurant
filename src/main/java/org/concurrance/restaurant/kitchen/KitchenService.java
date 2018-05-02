package org.concurrance.restaurant.kitchen;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.concurrance.restaurant.model.CookedDish;
import org.concurrance.restaurant.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class KitchenService {
	
	@Autowired
	@Qualifier("queue")
	private BlockingQueue<Dish> queue;
	
	@Autowired
	@Qualifier("cookedDishes")
	private List<CookedDish> list;
	
	@Autowired
	@Qualifier("chefs")
	private Integer numChefs;
	
	@Autowired
	public void setChef() {
		for (int i = 1; i <= numChefs; i++) {
			new java.lang.Thread(new Chef(queue, "chef_" + i, list)).start();
		}
	}
}
