package IPL.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import IPL.Dto.Player;
import IPL.Dto.Team;

@Component
public class Team_Dao 
{
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public void teamsignup( Team team) 
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(team);
		entityTransaction.commit();
	}
	
	public Team teamLogin(String username) 
	{
		EntityManager entityManager	=	entityManagerFactory.createEntityManager();
//		Query query=entityManager.createQuery("select x from Management x where username=?1").setParameter(1, username);			
//		List<Management>  list=query.getResultList();
		
		
	
		List<Team> list=entityManager.createQuery("select x from Team x where username=?1").setParameter(1, username).getResultList();
		
		if (list.isEmpty())
		{
			return null;
		}else {
			return list.get(0);
		}
	}
	
	public List<Team> viewallteam() 
	{
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	List< Team> list=(List<Team>) entityManager.createQuery("select x from Team x").getResultList();
	
	return list;
	}
	
	public Team view_respective_Team(int id) 
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		List< Team> list=(List<Team>) entityManager.createQuery("select x from Team x").getResultList();
		
		Team team=entityManager.find(Team.class, id);
		
		return team;
	}
	
	public Team Change_Status(int teamid) 
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		//List< Team> list=(List<Team>) entityManager.createQuery("select x from Team x").getResultList();
		
		Team team=entityManager.find(Team.class, teamid);
		
		return team;
	}
	
	public void Update(Team team) 
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(team);
		entityTransaction.commit();
		
	}
	public Team AddAmmount_for_team(int id) 
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		//List< Team> list=(List<Team>) entityManager.createQuery("select x from Team x").getResultList();
		
		Team team=entityManager.find(Team.class, id);
		
		return team;
	}
	
	public List<Team> get_all_team() 
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		List< Team> list=(List<Team>) entityManager.createQuery("select x from Team x").getResultList();
		
		return list;
	}
	
	public List<Team> getAllTeamByName(String name) 
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		List< Team> list=(List<Team>) entityManager.createQuery("select x from Team x where name=?1").setParameter(1, name).getResultList();
		
		return list;
	}
	
	// Don't allowed duplicate
	
	public List<Team> fetch(String name) 
	{
		EntityManager entityManager	=	entityManagerFactory.createEntityManager();

		List<Team> list=entityManager.createQuery("select x from Team x where name=?1").setParameter(1, name).getResultList();
		
		return list;
	}
	public List<Team> fetch_duplicate(String username) 
	{
		EntityManager entityManager	=	entityManagerFactory.createEntityManager();

		List<Team> list2=entityManager.createQuery("select x from Team x where username=?1").setParameter(1, username).getResultList();
		
		return list2;
	}
	
}
