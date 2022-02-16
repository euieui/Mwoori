package woori.hotel.web;

import java.sql.Timestamp;
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

import woori.hotel.service.AdminBookService;
import woori.hotel.service.MemberService;
import woori.hotel.util.BookVO;
import woori.hotel.util.Paging;

@Controller
public class MemberController {

	@Resource(name="MemberService") MemberService ms;
	@Resource(name="AdminBookService") AdminBookService abs;
	
	
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
			mav.addObject("msg", "조회한 회원의 아이디는 \" "+ id + " \" 입니다");
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
		paramMap.put("PWD", pwd);
		paramMap.put("ID", id);
		ms.resetPw(paramMap);
		
		mav.setViewName("member/resetPwComplete");
		return mav;
	}
	

	@RequestMapping("contract.do")
	public String contract() {
		return "member/contract";
	}
	
	@RequestMapping(value="/joinForm.do", method=RequestMethod.POST)
	public String joinForm() {
		return "member/join";
	}
	
	@RequestMapping("idCheckForm.do")
	public ModelAndView id_check_form(@RequestParam("id") String id) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put( "ref_cursor", null );
		paramMap.put("id", id);
		ms.getMember(paramMap);	 // 조회 
		ArrayList< HashMap<String,Object> > list 
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		
		int result=0;
		if(list.size()==0) result=-1;
		else result=1;
		mav.addObject("result",result);
		mav.addObject("id",id);
		mav.setViewName("member/idcheck");
		return mav;
	}
	

	@RequestMapping("findZipNum.do")
	public ModelAndView find_zip(@RequestParam(value="dong", required=false) String dong) {
		ModelAndView mav = new ModelAndView();
		
		if(dong!=null&&dong.trim().equals("")==false) {
			
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put( "ref_cursor", null );
			paramMap.put("dong", dong);
			ms.selectAddressByDong(paramMap);	 // 조회 
			ArrayList< HashMap<String,Object> > list 
				= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			
			mav.addObject("addressList", list);
		}
		mav.setViewName("member/findZipNum");
		return mav;
	}
	
	@RequestMapping("joinComplete.do")
	public String joinComplete(Model model, HttpServletRequest request, 
			@RequestParam(value="pwd", required=false) String pwd,
			@RequestParam(value="id", required=false) String id,
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="addr1", required=false) String addr1,
			@RequestParam(value="addr2", required=false) String addr2,
			@RequestParam(value="zip_num", required=false) String zip_num,
			@RequestParam(value="phone", required=false) String phone) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("pwd", pwd);
		paramMap.put("name", name);
		paramMap.put("email", email);
		paramMap.put("zip_num", zip_num);
		paramMap.put("phone", phone);
		paramMap.put("address", addr1+" "+addr2);
		ms.insertMember(paramMap);
		model.addAttribute("message", "회원가입이 완료되었어요. 로그인하세요");

		ms.getMember(paramMap);	
		ArrayList< HashMap<String,Object> > list 
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");	 
		HttpSession session=request.getSession();
		session.setAttribute("joinName", list.get(0));
		return "member/joinComplete";
	}
	

	@RequestMapping("joinCom.do")
	public String joinCom(Model model, HttpServletRequest request) {
		
		 HttpSession session = request.getSession();
	      //session.invalidate();
	      session.removeAttribute("joinName");
	      return "redirect:/loginForm.do";
	}
	
// 회원가입, 아이디 비밀번호 찾기 끝
	
	
	
	@RequestMapping(value="/profilePw.do")
	public String profilePw(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginUser");
		if(loginUser==null) {
			return "redirect:/loginForm.do";
		} else {
	    	session.setAttribute("loginUser", loginUser);
	    	return "mypage/profilePw";
 		}

	}
	
	@RequestMapping(value="/profileForm.do", method=RequestMethod.POST)
	public ModelAndView profileForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String url = "mypage/profileForm";
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginUser");
		String pwd = request.getParameter("pwd");
		if( loginUser == null) { 
			mav.addObject("message", "다시 로그인해주세요");
		}else if(pwd==""){
			mav.addObject("message", "비밀번호를 입력해주세요");
		}else if(!loginUser.get("PWD").equals(pwd)){
			mav.addObject("message", "비밀번호가 틀립니다");
		}else {
	    	url = "mypage/profileForm";
	    	String addr = loginUser.get("ADDRESS").toString(); //주소 추출
			int k1 = addr.indexOf(" "); // 첫 번째 공백의 위치 찾음
			int k2 = addr.indexOf(" ",k1+1); // 첫 번째 공백 위치의 다음위치부터 두 번째 공백 위치 찾음
			int k3 = addr.indexOf(" ",k2+1); // 두 번째 공백 위치의 다음위치부터 세 번째 공백 위치 찾음
			// 서울시 마포구 대현동 115-15 세 번째 공백 위치 k3값 ->11 (0부터 시작)
			String addr1 =addr.substring(0,k3); // 맨 앞부터 세 번째 공백 위치 바로 전까지 - 주소 앞부분
			String addr2 =addr.substring(k3+1); // 세 번째 공백 뒷글자부터 맨 끝까지 - 주소 뒷부분
			
			mav.addObject("addr1",addr1);
			mav.addObject("addr2",addr2);
			session.setAttribute("loginUser", loginUser);
		}  mav.setViewName(url);
		return mav;
	}

	@RequestMapping(value="/profileUpdate.do", method=RequestMethod.POST)
	public ModelAndView profileUpdate(HttpServletRequest request) {
		ModelAndView mav= new ModelAndView();
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginUser");
		
		if(loginUser==null) {
			mav.setViewName("redirect:/loginForm.do");
		} else {
			mav.addObject("message", "정상적으로 수정되었습니다");

			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("ID", request.getParameter("id"));
			paramMap.put("PWD", request.getParameter("pwd"));
			paramMap.put("NAME", request.getParameter("name"));
			paramMap.put("EMAIL", request.getParameter("email"));
			paramMap.put("ZIP_NUM", request.getParameter("zip_num"));
			paramMap.put("PHONE", request.getParameter("phone"));
			paramMap.put("ADDRESS", request.getParameter("addr1") + " " + request.getParameter("addr2"));
			
			ms.updateMember(paramMap);
			
			session.setAttribute("loginUser", paramMap);
			String addr = loginUser.get("ADDRESS").toString(); //주소 추출
			int k1 = addr.indexOf(" "); // 첫 번째 공백의 위치 찾음
			int k2 = addr.indexOf(" ",k1+1); // 첫 번째 공백 위치의 다음위치부터 두 번째 공백 위치 찾음
			int k3 = addr.indexOf(" ",k2+1); // 두 번째 공백 위치의 다음위치부터 세 번째 공백 위치 찾음
			// 서울시 마포구 대현동 115-15 세 번째 공백 위치 k3값 ->11 (0부터 시작)
			String addr1 =addr.substring(0,k3); // 맨 앞부터 세 번째 공백 위치 바로 전까지 - 주소 앞부분
			String addr2 =addr.substring(k3+1); // 세 번째 공백 뒷글자부터 맨 끝까지 - 주소 뒷부분
			mav.addObject("addr1",addr1);
			mav.addObject("addr2",addr2);
			
			mav.setViewName("mypage/profileForm");
				
		}
		return mav;
	
	}
	


	@RequestMapping(value="/pwUpdateForm.do")
	public String pwUpdateForm(HttpServletRequest request) {
		
		String url = "mypage/pwUpdateForm";
		
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginUser");
		if(loginUser==null) {
			url = "redirect:/loginForm";
		} else {
	    	session.setAttribute("loginUser", loginUser);
		}
		return url;
	}
	
	@RequestMapping(value="/pwUpdate.do", method=RequestMethod.POST)
	public ModelAndView pwUpdate(HttpServletRequest request,
			 @RequestParam(value="pwd") String pwd,
			 @RequestParam(value="newpwd") String newpwd,
			 @RequestParam(value="newpwd_re") String newpwd_re) {
		ModelAndView mav = new ModelAndView();
		
		String url = "mypage/pwUpdateForm";
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginUser");
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ID", loginUser.get("ID"));
		paramMap.put("NAME", loginUser.get("NAME"));
		paramMap.put("PWD", loginUser.get("PWD"));
		paramMap.put("EMAIL", loginUser.get("EMAIL"));
		paramMap.put("ZIP_NUM", loginUser.get("ZIP_NUM"));
		paramMap.put("PHONE", loginUser.get("PHONE"));
		paramMap.put("ADDRESS", loginUser.get("ADDRESS"));
		
		if( loginUser == null) { 
			mav.addObject("message", "다시 로그인해주세요");
	// 현재 비밀번호 확인
		}else if(pwd.equals(null)){ 
			mav.addObject("message", "현재 비밀번호를 입력해주세요");
		}else if(!loginUser.get("PWD").equals(pwd)){
			mav.addObject("message", "현재 비밀번호가 틀립니다");
		}else {
	// 새 비밀번호 확인
			if(newpwd.equals(null)) {
				mav.addObject("message", "새 비밀번호를 입력해주세요");
			} else if(newpwd_re.equals(null)) {
				mav.addObject("message", "새 비밀번호 확인을 입력해주세요");
			} else if(!newpwd_re.equals(newpwd)) {
				mav.addObject("message", "새 비밀번호 확인이 일치하지 않습니다");
			} else {
				paramMap.put("PWD", request.getParameter("newpwd"));
				ms.resetPw(paramMap);
				mav.addObject("message", "정상적으로 수정되었습니다");
			}
		}  
		session.setAttribute("loginUser", paramMap);
		mav.setViewName(url);
		
		return mav;
	}
	

	@RequestMapping("quitPw.do")
	public String quitPw(Model model, HttpServletRequest request) {
		String url = "mypage/quitPw";
		
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginUser");
		if(loginUser==null) {
			url = "member/login";
		} else {
	    	session.setAttribute("loginUser", loginUser);
 		}
		return url;
	}
	
	@RequestMapping(value="/quitCheck.do", method=RequestMethod.POST)
	public ModelAndView quitCheck(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String url = "quitPw";
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginUser");
		String pwd = request.getParameter("pwd");
		if( loginUser == null) { 
			mav.addObject("message", "다시 로그인해주세요");
		}else if(pwd==""){
			mav.addObject("message", "비밀번호를 입력해주세요");
		}else if(!loginUser.get("PWD").equals(pwd)){
			mav.addObject("message", "비밀번호가 틀립니다");
		}else {
			url = "mypage/quitOk";
			session.setAttribute("loginUser", loginUser);
		}
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping(value="/quit.do", method=RequestMethod.POST)
	public String quit(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginUser");

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", loginUser.get("ID"));
		ms.deleteMember(paramMap);
		
		session.removeAttribute("loginUser");
		
		return "redirect:/";
	}
}
