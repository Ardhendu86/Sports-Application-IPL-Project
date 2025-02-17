package IPL.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import IPL.Dto.Management;
import IPL.Dto.Player;

@Component
public class Player_Dao
{
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public void playersignup(Player player) 
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(player);
		entityTransaction.commit();
	}
	
	public Player playerlogin(String username) 
	{
		EntityManager entityManager	=	entityManagerFactory.createEntityManager();
//		Query query=entityManager.createQuery("select x from Management x where username=?1").setParameter(1, username);			
//		List<Management>  list=query.getResultList();
		
		
	
		List<Player> list=entityManager.createQuery("select x from Player x where username=?1").setParameter(1, username).getResultList();
		
		if (list.isEmpty())
		{
			return null;
		}else {
			return list.get(0);
		}
	
	}
	public void playerupdate(Player player) 
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(player);
		entityTransaction.commit();
	}
	
	public List<Player> View_all_player_coming_for_action() 
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		//EntityTransaction entityTransaction=entityManager.getTransaction();
		List<Player> list=entityManager.createQuery("select x from Player x ").getResultList();
		
		return list;
	}
	
	public Player change_Player_Status(int id) 
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		//EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Player player=entityManager.find(Player.class, id);
		
		return player;
	}
	
	public List<Player> viewavailable_Player()
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		List<Player>  list=entityManager.createQuery("select x from Player x where status='Available'").getResultList();
		return list;
	}
	
	public Player buyplayer(int id) 
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Player  player=entityManager.find(Player.class, id);
		
		return player;
	}
	
	//for duplicate
	
	public List<Player> fetch(String username) 
	{
		EntityManager entityManager	=	entityManagerFactory.createEntityManager();
		
	
		List<Player> list=entityManager.createQuery("select x from Player x where username=?1").setParameter(1, username).getResultList();
		
	return list;
	
	}
	public List<Player> fetchpassword(String password) 
	{
		EntityManager entityManager	=	entityManagerFactory.createEntityManager();
		
	
		List<Player> password1=entityManager.createQuery("select x from Player x where password=?1").setParameter(1, password).getResultList();
		
	return password1;
	
	}



}
