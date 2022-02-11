package woori.hotel.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import woori.hotel.service.AdminBookService;

@Controller
public class BookController {
	
	@Resource(name="AdminBookService") AdminBookService abs;
	
	@RequestMapping(value="goInfo.do")
	public String goInfo() {
		return "Info/sum";
	}
	
	
	
	
	@RequestMapping(value="/seoulHotel.do")
	public String seoulHotel() {
		return "Info/Seoul";
	}

}
