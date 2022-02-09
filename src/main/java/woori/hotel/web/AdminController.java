package woori.hotel.web;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import woori.hotel.service.AdminService;

@Controller
public class AdminController {
	
	@Resource(name="AdminService") AdminService as;
	
	@RequestMapping(value="/a.do")
	public String adminPage() {
		return "admin/adminmain";
	}
	
	
	
	
	@RequestMapping(value="/adminloginForm.do")
	public String adminloginForm() {
		return "admin/adminloginForm";
	}
	
	
	
	
	@RequestMapping(value="/adminlogin.do")
	public String adminlogin(HttpServletRequest request, Model model,
			@RequestParam("workId") String workId, 
			@RequestParam("workPwd") String workPwd) {
		
		HttpSession session = request.getSession();
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("id", workId);
		paramMap.put("ref_cursor", null);
		as.getAdmin(paramMap);
		ArrayList<HashMap<String, Object>> list = 
				(ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		if(list.size()==0) {
			model.addAttribute("message","없는 회원 정보입니다.");
			return "member/login";
		}
		HashMap<String, Object> adminUser = list.get(0);
		if(!adminUser.get("PWD").equals(workPwd)) {
			model.addAttribute("message", "아이디 혹은 비밀번호가 틀렸습니다.");
			return "admin/adminLoginForm";
		} else if(adminUser.get("PWD").equals(workPwd)) {
			session.setAttribute("loginAdmin", adminUser);
		}
		
		return "admin/adminmain";
	}

}
