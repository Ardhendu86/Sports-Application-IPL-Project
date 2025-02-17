package IPL.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import IPL.Dao.ManagementDao;
import IPL.Dto.Management;

//@Controller
@RestController   // it will do the work of controller also response body also
public class Management_Controller 
{
	@Autowired
	ManagementDao mangementDao;
	@RequestMapping("managementsignup")//it will collect only one type of data
	//@ResponseBody
	public ModelAndView save(@ModelAttribute Management management, @RequestParam String username,@RequestParam String password) //it will collect bunch type of data
	{
		List<Management> list1=mangementDao.fetch_duplicatename(username);
		List<Management> list2=mangementDao.fetch_duplicate(password);
		
		if (list1.isEmpty() && list2.isEmpty())
		{
			mangementDao.saveManagement(management);
			ModelAndView modelAndView	 =new ModelAndView();
			modelAndView.addObject("msg","Management accouunt got created");
			
			modelAndView.setViewName("index.jsp");
			return modelAndView;
		}
		else
		{
			ModelAndView modelAndView	 =new ModelAndView();
			modelAndView.addObject("msg","Management accouunt allready exist");
			
			modelAndView.setViewName("managementSignup.jsp");
			return modelAndView;
		}
		
	}
	
	@RequestMapping("managementlogin")
	//@ResponseBody
	public ModelAndView managementlogin(@RequestParam String username, @RequestParam String password) 
	{
		Management management=mangementDao.managementlogin(username);
		
	ModelAndView modelAndView	=new ModelAndView();
		if (management==null)
		{
			modelAndView.addObject("msg","Enterd invalid username");
			modelAndView.setViewName("managementlogin.jsp");
		}
		else 
		{
			if (management.getPassword().equals(password)) 
			{
				modelAndView.addObject("msg","Management login success");
				modelAndView.setViewName("managementHome.jsp");
			}
			else 
			{
				modelAndView.addObject("msg","Enterd invalid password");
				modelAndView.setViewName("managementlogin.jsp");
			}
		}
		return modelAndView;
	}
}

