package IPL.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import IPL.Dao.Team_Dao;
import IPL.Dto.Player;
import IPL.Dto.Team;

@RestController
//@Controller
public class Team_Controller 

{
	@Autowired
	Team_Dao team_Dao;
	
	@RequestMapping("teamsignup")
	public ModelAndView teamsignup(@ModelAttribute Team team, @RequestParam String name,String username) 
	{
		List<Team> list4=team_Dao.fetch(name);
		List<Team> list5=team_Dao.fetch(username);
		if (list4.isEmpty() && list5.isEmpty())
		{
			team_Dao.teamsignup(team);
			
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.addObject("msg", "Team account got created");
			modelAndView.setViewName("index.jsp");
			
			return modelAndView;
		}
		else
		{
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.addObject("msg", "Team account allready exist");
			modelAndView.setViewName("Teamsignup.jsp");
			
			return modelAndView;
		}
		
	}
	
	
	@PostMapping("teamlogin")
	public ModelAndView teamlogin(@RequestParam  String username, String password, HttpSession httpSession) 
	{
		Team team=team_Dao.teamLogin(username);
		ModelAndView modelAndView=new  ModelAndView();
		
		if (team==null)
		{
			modelAndView.addObject("msg", "Enterd invalid username");
			modelAndView.setViewName("Teamlogin.jsp");
		}
		else
		{
			if (team.getPassword().equals(password))
			{
				if (team.isStatus())
				{
					httpSession.setAttribute("team", team);  //here i am setting the data by using session tracking for future use.
					modelAndView.addObject("msg", "Team login success");
					modelAndView.setViewName("Teamhome.jsp");
				}
				else 
				{
					modelAndView.addObject("msg", "Wait for management approval");
					modelAndView.setViewName("managementHome.jsp");
				}
				
			}
			else 
			{
				modelAndView.addObject("msg", "invalid password");
				modelAndView.setViewName("Teamlogin.jsp");
			}
		}
		return modelAndView;
	}
	
	@RequestMapping("viewallteams")
	
	public ModelAndView viewAllTeams() 
	{
		List< Team> teams=team_Dao.viewallteam();
		ModelAndView modelAndView=new ModelAndView();
		
		if (teams.isEmpty()) 
		{
			modelAndView.addObject("msg","No team are available");
			modelAndView.setViewName("managementHome.jsp");
		}
		else
		{
			modelAndView.addObject("teams",teams);
			modelAndView.setViewName("viewAllTeam.jsp");
		}
		return modelAndView;
	}
	
	@RequestMapping("changestatus")
	public ModelAndView changestatus(@RequestParam ("id") int teamid) 
	{
		Team team=team_Dao.Change_Status(teamid);
		ModelAndView modelAndView=new ModelAndView();		
		if (team.isStatus()) 
		{
			team.setStatus(false);
		}
		else
		
			team.setStatus(true);
			//team_Dao.Update();
		
		team_Dao.Update(team);
		modelAndView.addObject("msg","Team Status got changed");
		modelAndView.setViewName("managementHome.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("addmount")
	public ModelAndView addamount_for_the_team(@RequestParam double amount, @RequestParam int id) 
	{
		Team team=team_Dao.AddAmmount_for_team(id);
		
		team.setWallet(team.getWallet()+amount);
		
		team_Dao.Update(team);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("msg","Ammount has been added by management successfully");
		modelAndView.setViewName("managementHome.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("viewteam")
	public ModelAndView view_players_inside_the_team(HttpSession httpSession) 
	{
		Team team=(Team) httpSession.getAttribute("team");
		List<Player> players=team.getList(); //Here we are going to get the information of player who has been sold out for particular team.
		
		ModelAndView modelAndView=new ModelAndView();
		
		if (players.isEmpty())
		{
			modelAndView.addObject( "teamname"  ,team.getName());
			modelAndView.addObject("msg", "No players has been bought by this team");
			modelAndView.setViewName("View_my_team.jsp");
		}
		else
		{
			modelAndView.addObject( "teamname"  ,team.getName());
			modelAndView.addObject("players",players);
			modelAndView.setViewName("View_my_team.jsp");
		}
		return modelAndView;
	
	}
	
	
	@RequestMapping("teamhomedummy")
	public ModelAndView teamhomedummy( HttpSession httpSession) //this is used to redirect for the same page with value
	{
		Team team=(Team) httpSession.getAttribute("team");
		
		ModelAndView modelAndView=new ModelAndView();
		//modelAndView.addObject("teamname", team.getName());
		modelAndView.setViewName("Teamhome.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("viewteambyname")
	public ModelAndView View_teamby_name() 
	{
		List<Team>teams=team_Dao.get_all_team();
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("teams",teams);
		modelAndView.setViewName("View_team_By_Name.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("fetchusingteamname")
	public ModelAndView fetchusingteam(@RequestParam String name) 
	{
		List<Team> list=team_Dao.getAllTeamByName(name);
		Team team=list.get(0);
		List<Player>players=team.getList();
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("players", players);
		modelAndView.setViewName("View_my_team.jsp");
		
		return modelAndView;
	}
}
