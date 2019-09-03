package com.hadialaoui.spring.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
  private static List<User> users = new ArrayList<User>();
  private static int userCount = 4;
  
  static {
	  users.add(new User(1, "Ahmed", new Date()));
	  users.add(new User(2, "Meryam", new Date()));
	  users.add(new User(3, "Mourad", new Date()));
	  users.add(new User(4, "Zakaria", new Date()));
  }
  
  public User findOne(Integer id) {
	 for (User user : users) {
		if(user.getId() == id) {
			return user;
		}
	}
	  return null;
  }
  
  public User delete(Integer id) {
	  for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
		User user = (User) iterator.next();
		if(user.getId() == id) {
			iterator.remove();
			return user;
		}
		
	}
		  return null;
	  }
  
  public List<User> findAll(){
	  return users;
  }
  
  public void save(User user) {
	  if(user.getId()==null)
	  user.setId(++userCount);
	  users.add(user);
  }
}
