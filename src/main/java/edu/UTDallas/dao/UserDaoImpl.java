package edu.UTDallas.dao;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.UTDallas.Util.Constants;
import edu.UTDallas.Util.Roles;
import edu.UTDallas.entity.Role;
import edu.UTDallas.entity.User;
import javassist.bytecode.stackmap.TypeData.ClassName;

/**
 * Created by asdha on 5/26/2017.
 */
public class UserDaoImpl implements UserDao {

	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {

		LOGGER.info("User being added");
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
			user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

			user.setRoles(setRoleForUser(user, session));
			session.persist(user);
			tx.commit();

			LOGGER.info("User added");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error occured while adding user", e);
			tx.rollback();
		} finally {
			session.close();
		}

	}

	private Set<Role> setRoleForUser(User user, Session session) {

		Set<Role> roles = new HashSet<>();
		for (String s : user.getRoleOfUser()) {
			Role role = new Role();
			if (s.equalsIgnoreCase(Constants.admin)) {
				role.setRole(Roles.ROLE_ADMIN.toString());
			} else if (s.equalsIgnoreCase(Constants.teacher)) {
				role.setRole(Roles.ROLE_TEACHER.toString());
			} else {
				role.setRole(Roles.ROLE_STUDENT.toString());
			}
			role.setUser(user);
			roles.add(role);
			session.save(role);
		}

		return roles;
	}

	public BCryptPasswordEncoder getbCryptPasswordEncoder() {
		return bCryptPasswordEncoder;
	}

	public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public SessionFactory getSessionFactory() {

		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
