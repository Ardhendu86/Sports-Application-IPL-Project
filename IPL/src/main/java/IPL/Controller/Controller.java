package IPL.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import IPL.Dto.Management;
import IPL.Dto.Player;
import IPL.Dto.Team;

//@org.springframework.stereotype.Controller

@RestController
public class Controller 
{
	@Autowired //it will act like a vehicle and he will bring the object from the respective class.
	Management management;
	
	@Autowired
	Player player;
	
	@Autowired
	Team team;
	
	@RequestMapping("signup")
	public ModelAndView signup(@RequestParam String role) //requestparm acts like getparameter which will fetch the data from the frontend
	{
		ModelAndView modelAndView = new ModelAndView(); //here ModelAndView model means object view means front end(jsp) here the work of ModelAndView is nothing but carrying the object to the front end(to the jsp).
		if(role.equals("Management"))
		{
		 modelAndView.addObject("management",management);//key and value pair
		 modelAndView.setViewName("managementSignup.jsp");
				
		}
		else if(role.equals("player"))
		{
			 modelAndView.addObject("player",player);//key and value pair
			 modelAndView.setViewName("playersignup.jsp");	
		}else 
		{
			 modelAndView.addObject("team",team);//key and value pair
			 modelAndView.setViewName("Teamsignup.jsp");
		}
		 return modelAndView; //if I want to return or carry anything to the frontend and finally 
		}
		
	}
