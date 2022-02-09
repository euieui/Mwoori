package woori.hotel.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import woori.hotel.service.AdminService;

@Controller
public class AdminController {
	
	@Resource(name="AdminService") AdminService as;
	
	@RequestMapping(value="/a.do")
	public String adminPage() {
		return "admin/adminmain";
	}

}
