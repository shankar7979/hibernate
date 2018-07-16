package org.com.interceptor;

import java.io.Serializable;

import org.com.model.Student;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class StudentInterceptor extends EmptyInterceptor {
	boolean status=true;

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		if (entity instanceof Student) {
			if (((Student) entity).getRoll() > 100
					|| ((Student) entity).getRoll() <= 0)
				status = false;
			System.out.println("Roll no is out of range(1  -  100) ");
		}
		// return super.onSave(entity, id, state, propertyNames, types);
		return status;
	}

	public static void main(String[] args) {

	}

}
