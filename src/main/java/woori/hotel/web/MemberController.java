package woori.hotel.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Resource(name="MemberService") MemberService ms;
	
	@RequestMapping(value="/loginForm.do")
	public String loginForm() {
		return "member/login";
	}
}
