package IPL.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import IPL.Dao.Player_Dao;
import IPL.Dao.Team_Dao;
import IPL.Dto.Player;
import IPL.Dto.Team;

@RestController
public class Player_Controller
{
//	@Autowired
//	Player player;
	
	@Autowired
	Player_Dao player_Dao;
	
	@Autowired
	Team_Dao team_Dao;
	
	@RequestMapping("playersignup")
	public ModelAndView playersignup(@ModelAttribute Player player, @RequestParam String password )
	{
		
	List<Player> list2=player_Dao.fetchpassword(password);
	
	if(list2.isEmpty())
	{
		player.setStatus("Pending");
		
		player_Dao.playersignup(player);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("msg", "Player account got created successfully");
		modelAndView.setViewName("index.jsp");
		
		return modelAndView;
	}
	else 
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("msg", "Player account allready exiested");
		modelAndView.setViewName("playersignup.jsp");
		return modelAndView;
	}
		
  }
	
	
	@RequestMapping("playerlogin")
	
	public ModelAndView playerlogin(@RequestParam String username, String password , HttpSession httpSession) 
	{
		Player player=player_Dao.playerlogin(username);
		ModelAndView modelAndView= new ModelAndView();
		if (player==null) 
		{
			modelAndView.addObject("msg", "Invalid username");
			modelAndView.setViewName("Playerlogin.jsp");
		}else 
		
		{
			httpSession.setAttribute("player", player); //here it is used to take the current information to edit purpose or to update purpuse
			if (player.getPassword().equals(password)) 
			{
				modelAndView.addObject("msg", "Login success");
				modelAndView.setViewName("playerHome.jsp");
			}
			else 
			{
				modelAndView.addObject("msg", "invalid password");
				modelAndView.setViewName("Playerlogin.jsp");
			}
		}
		return modelAndView;
	}
	
	@RequestMapping("editplayer")
	public ModelAndView editplayer(HttpSession httpSession) 
	{
		Player player=(Player) httpSession.getAttribute("player");
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("player", player);
		modelAndView.setViewName("EditPlayer.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("playerupdate")
	public ModelAndView Update_Player(@ModelAttribute Player player) 
	{
		player_Dao.playerupdate(player);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("msg", "player data has been edited successfully");
		modelAndView.setViewName("playerHome.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("viewplayers")
	public ModelAndView viewplayers(@RequestParam ("id") int id)
	{
		Team team=team_Dao.view_respective_Team(id);
		List<Player> players=team.getList();
		ModelAndView modelAndView=new ModelAndView();
		if (players.isEmpty()) 
		{
			modelAndView.addObject("msg","No player are available inside team");
			modelAndView.addObject("teamname",team.getName());
			modelAndView.setViewName("Viewteamplayers.jsp");
		}
		else 
		{
			modelAndView.addObject("players", players);
			modelAndView.addObject("teamname",team.getName());
			modelAndView.setViewName("Viewteamplayers.jsp");
		}
		return modelAndView;
	}
	
	@RequestMapping("viewallplayers")
	public ModelAndView View_all_player_coming_for_action()
	{
		List<Player> players=player_Dao.View_all_player_coming_for_action();
		ModelAndView  modelAndView=new ModelAndView();
		
		if (players.isEmpty())
		{
			modelAndView.addObject("msg","No players are available for action");
			modelAndView.setViewName("managementHome.jsp");
		}
		else 
		{
			modelAndView.addObject("players", players);
			modelAndView.setViewName("View_All_Players.jsp");
		}
		return modelAndView;
	}
	
	
	@RequestMapping("changeplayerstatus")
	public ModelAndView change_Player_Status(@RequestParam  int id) 
	{
		Player player=player_Dao.change_Player_Status(id);
		
		ModelAndView modelAndView=new ModelAndView();
		
		if (player.getStatus().equals("Pending"))
		{
			player.setStatus("Available");
		}
		else
		{
			player.setStatus("Pending");
		}	
		
		player_Dao.playerupdate(player);
		//List<Player> players=player_Dao.View_all_player_coming_for_action();
		List<Player> players=player_Dao.View_all_player_coming_for_action();
		modelAndView.addObject("players",players);
		modelAndView.addObject("msg","Player status has been updated");
		modelAndView.setViewName("View_All_Players.jsp");
		
		return modelAndView;
	}	
	
	@RequestMapping("viewavailableplayers")
	public ModelAndView view_players_who_are_All_available_for_action(HttpSession httpSession)
	{
		Team team=(Team) httpSession.getAttribute("team");
		
		List<Player> players=player_Dao.viewavailable_Player();
		ModelAndView modelAndView=new ModelAndView();
		if (players.isEmpty())
		{
			modelAndView.addObject("msg","No players are available to buy");
			modelAndView.setViewName("Teamhome.jsp");
		}
		else 
		{
			modelAndView.addObject("players",players);
			modelAndView.setViewName("Buy_Players.jsp");
		}
		return modelAndView;
		
	}
	
	@RequestMapping("buyplayer")
	public ModelAndView buyPlayer(@RequestParam int id, HttpSession httpSession) 
	{
		Player player=player_Dao.buyplayer(id);
		Team team=(Team) httpSession.getAttribute("team");
		ModelAndView modelAndView=new ModelAndView();
		
		if (player.getPrice()>team.getWallet())
		{
			modelAndView.addObject("msg", "Insufficient balance");
			modelAndView.setViewName("Teamhome.jsp");
		}
		
		else {
			team.setWallet(team.getWallet()-player.getPrice());
			
			player.setStatus("Sold");
			player.setTeam(team);
			
			List<Player> players=team.getList();
			
			players.add(player);
			team.setList(players);
			
			team_Dao.Update(team);
			player_Dao.playerupdate(player);
			
			modelAndView.addObject("msg", "Player has been bought successfully");
			modelAndView.setViewName("Teamhome.jsp");
		}
		return modelAndView;
	}
}
