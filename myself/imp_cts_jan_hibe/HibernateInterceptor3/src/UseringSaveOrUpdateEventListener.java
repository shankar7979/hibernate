import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.HibernateException;
import org.hibernate.event.SaveOrUpdateEvent;
import org.hibernate.event.def.DefaultSaveOrUpdateEventListener;

class UseringSaveOrUpdateEventListener extends DefaultSaveOrUpdateEventListener 
//class UseringSaveOrUpdateEventListener extends EmptyInterceptor
{

	// Perform selective updating - save only important users
	public Serializable performSaveOrUpdate(SaveOrUpdateEvent event)
			throws HibernateException {
		if (event.getObject() instanceof User) {
			User user = (User) event.getObject();
			System.out.println("Preparing to save or update user "
					+ user.getUsername());

			if (user.getUsername().startsWith("NotImportantUser")) {
				System.out.println(user.getUsername() + " is not recorded.");

				// Here we prevent the invocation
				// of saveOrUpdate on the Session from having
				// any effect on the database!
				return null;
			} else {
				System.out.println(user.getUsername() + " is recorded.");
			}
		}
		return super.performSaveOrUpdate(event);
	}

}
