package woori.hotel.web;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import woori.hotel.service.MemberService;

@Controller
public class MemberController {

	@Resource(name="MemberService") MemberService ms;
	
	@RequestMapping(value="/loginForm.do")
	public String loginForm() {
		return "member/login";
	}
	
	@RequestMapping(value="/login.do")
	public String login( Model model, HttpServletRequest request ) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd"); 
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put( "ref_cursor", null );
		paramMap.put("id", id);
		ms.getMember(paramMap);	 // 조회 
		ArrayList< HashMap<String,Object> > list 
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		if(list.size() == 0) {  // 입력한 아이디 없다면
			model.addAttribute("message" , "아이디가 존재하지 않습니다");
			return "member/login";
		}
		HashMap<String, Object> resultMap = list.get(0);  // 있다면  리스트에서 첫번째 인원정보 추출해서  해시맵에 저장
		if(resultMap.get("PWD")==null) {
			model.addAttribute("message" , "비밀번호가 존재하지 않습니다");
			return "member/login";
		}else if( pw.equals( (String)resultMap.get("PWD") ) ) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", resultMap);
			return "redirect:/main.do";
		}else {
			model.addAttribute("message" , "비밀번호가 다릅니다");
			return "member/login";
		}
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		return "redirect:/main.do";
	}
	
	@RequestMapping("findIdPw.do")
	public String find_id_pwd() {
		return"member/findIdPw";
	}
	

	@RequestMapping("findIdForm.do")
	public String find_id_form() {
		return"member/findIdForm";
	}
	
}
