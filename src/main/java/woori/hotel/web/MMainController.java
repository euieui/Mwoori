package woori.hotel.web;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import woori.hotel.service.MainService;


@Controller
public class MMainController {
	
	@Resource(name="MainService") MainService ms;
	
	
	@RequestMapping(value="/mobilemain.do")
	public String mobilemain( HttpServletRequest request, Model model) {

		
		return "mobile/main";
	}

}
