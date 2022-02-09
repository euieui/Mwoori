package woori.hotel.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import woori.hotel.service.MainService;


@Controller
public class MainController {
	@Resource(name="MainService") MainService ms;
	
	
	
	
	
	
	
	
	@RequestMapping("/main.do")
	public ModelAndView index(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
	
	
	
	
	
	
}
