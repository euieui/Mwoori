package woori.hotel.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import woori.hotel.service.AdminBookService;

@Controller
public class AdminBookController {
	
	@Resource(name="AdminBookService") AdminBookService abs;

}
