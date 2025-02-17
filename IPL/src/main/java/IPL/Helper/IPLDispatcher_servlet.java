package IPL.Helper;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class IPLDispatcher_servlet extends AbstractAnnotationConfigDispatcherServletInitializer
	{

		@Override
		protected Class<?>[] getRootConfigClasses()
		{
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		
		protected Class<?>[] getServletConfigClasses()
		{

	       Class <?>[] arr ={My_Config.class};
			return arr;
		}

		@Override
		protected String[] getServletMappings() 
		{
			String [] arr= {"/"};
			return arr;//this line indicates we have sucessfully mappped multiple urls.
		}

	}

