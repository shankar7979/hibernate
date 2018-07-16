package org.com.dao;

import java.util.List;

import org.com.model.Item;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ItemDao  extends HibernateDaoSupport{

	HibernateTemplate hibernateTemplate;

	Item item;

	public String addBook(Item  item) {
		hibernateTemplate = getHibernateTemplate();
		Item  i = (Item) hibernateTemplate.get(Item.class, item.getId());
		if (i != null) {
			return "Item id  already exist";
		} else {
			hibernateTemplate.save(item);
			return "Book added";
		}
	}
	

	public List<Object> getItem(){
	 	return hibernateTemplate.find("from Item");
	}
	
}
