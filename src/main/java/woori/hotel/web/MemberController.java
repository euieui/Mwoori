package woori.hotel.web;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("findPwForm.do")
	public String find_pw_form() {
		return"member/findPwForm";
	}
	
	@RequestMapping(value="/findIdStep1.do", method=RequestMethod.POST)
	public ModelAndView find_id_form1(@RequestParam("name") String name,
			@RequestParam("phone") String phone,
			Model model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put( "ref_cursor", null );
		paramMap.put("phone", phone);
		paramMap.put("name", name);
		ms.confirmPhone1(paramMap);

		ArrayList< HashMap<String,Object> > list 
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		if(list.size()==0) {
			mav.addObject("msg", "이름과 전화번호가 일치하는 회원이 없습니다.");
			mav.setViewName("member/findIdForm");
		}else {
			// 인증번호 전송
			mav.setViewName("member/findIdConfirmNumber"); // 인증번호 입력 화면으로 이동
			mav.addObject("member", list.get(0));
		}
		return mav;	
	}
	

	@RequestMapping(value="/findIdStep2", method=RequestMethod.POST)
	public ModelAndView find_id_form2(@RequestParam("name") String name,
			@RequestParam("id") String id,
			@RequestParam("phone") String phone,
			@RequestParam("confirmNum") String confirmNum,
			Model model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("phone", phone);
		paramMap.put("name", name);
		paramMap.put("id", id);
		paramMap.put( "ref_cursor", null );
		ms.confirmPhone1(paramMap);

		ArrayList< HashMap<String,Object> > list 
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");

			
		if(!confirmNum.equals("0000")) {
			mav.addObject("msg", "인증번호가 맞지 않습니다");
			mav.setViewName("member/findIdConfirmNumber");
		} else {
			mav.setViewName("member/viewId");
			mav.addObject("msg", "조회한 회원의 아이디는 "+ id + " 입니다");
		}
		mav.addObject("member", list.get(0));
		return mav;
	}
	
	@RequestMapping(value="/findPwStep1.do", method=RequestMethod.POST)
	public ModelAndView find_pw_form1(@RequestParam("name") String name,
			@RequestParam("phone") String phone,
			@RequestParam("id") String id,
			Model model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put( "ref_cursor", null );
		paramMap.put("phone", phone);
		paramMap.put("name", name);
		paramMap.put("id", id);
		ms.confirmPhone2(paramMap);

		ArrayList< HashMap<String,Object> > list 
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");

		if(list.size() == 0) {
			mav.addObject("msg", "아이디와 이름, 전화번호가 일치하는 회원이 없습니다.");
			mav.setViewName("member/findPwForm");
		}else {
			// 인증번호 전송
			mav.setViewName("member/findPwConfirmNumber"); // 인증번호 입력 화면으로 이동
			mav.addObject("member", list.get(0));
		}
		return mav;	
		}
	
	@RequestMapping(value="/findPwStep2.do", method=RequestMethod.POST)
	public ModelAndView find_pw_form2(@RequestParam("name") String name,
			@RequestParam("id") String id,
			@RequestParam("phone") String phone,
			@RequestParam("confirmNum") String confirmNum,
			Model model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		System.out.println("phone : " + phone );
		System.out.println("name : " + name);
		System.out.println("id : " + id );
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put( "ref_cursor", null );
		paramMap.put("phone", phone);
		paramMap.put("name", name);
		paramMap.put("id", id);
		ms.confirmPhone2(paramMap);

		ArrayList< HashMap<String,Object> > list 
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");

		if(!confirmNum.equals("0000")) {
			mav.addObject("msg", "인증번호가 맞지 않습니다");
			mav.setViewName("member/findPwConfirmNumber");
		} else {
			mav.setViewName("member/resetPw");
		}
		mav.addObject("member", list.get(0));
		return mav;
	}
	
	@RequestMapping(value="/resetPw.do", method=RequestMethod.POST)
	public ModelAndView reset_pw(@RequestParam("pwd") String pwd,
			@RequestParam("id") String id,
			Model model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pwd", pwd);
		paramMap.put("id", id);
		ms.resetPw(paramMap);
		
		mav.setViewName("member/resetPwComplete");
		return mav;
	}
	
}
