package com.hadialaoui.spring.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
  private static List<Utilisateur> users = new ArrayList<Utilisateur>();
  private static int userCount = 4;
  
  static {
	  users.add(new Utilisateur(1, "Ahmed", new Date()));
	  users.add(new Utilisateur(2, "Meryam", new Date()));
	  users.add(new Utilisateur(3, "Mourad", new Date()));
	  users.add(new Utilisateur(4, "Zakaria", new Date()));
  }
  
  public Utilisateur findOne(Integer id) {
	 for (Utilisateur user : users) {
		if(user.getId() == id) {
			return user;
		}
	}
	  return null;
  }
  
  public Utilisateur delete(Integer id) {
	  for (Iterator<Utilisateur> iterator = users.iterator(); iterator.hasNext();) {
		Utilisateur user = (Utilisateur) iterator.next();
		if(user.getId() == id) {
			iterator.remove();
			return user;
		}
		
	}
		  return null;
	  }
  
  public List<Utilisateur> findAll(){
	  return users;
  }
  
  public void save(Utilisateur user) {
	  if(user.getId()==null)
	  user.setId(++userCount);
	  users.add(user);
  }
}
