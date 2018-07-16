package org.com.dao;

import org.com.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ItemDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	Item item;
	
 @Transactional
	public String addBook(Item  item) {
		Item  i = (Item) hibernateTemplate.get(Item.class, item.getId());
		if (i != null) {
			return "Item id  already exist";
		} else {
			hibernateTemplate.save(item);
			return "Book added";
		}
	}
}