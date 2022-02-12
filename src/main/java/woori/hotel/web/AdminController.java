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

import woori.hotel.service.AdminBookService;
import woori.hotel.service.AdminService;
import woori.hotel.service.MemberService;
import woori.hotel.util.Paging;

@Controller
public class AdminController {
	
	@Resource(name="MemberService") MemberService ms;
	@Resource(name="AdminService") AdminService as;
	@Resource(name="AdminBookService") AdminBookService abs;
	
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
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("id", workId);
		paramMap.put("ref_cursor", null);
		as.getAdmin(paramMap);
		ArrayList<HashMap<String, Object>> list = 
				(ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		if(list.size()==0) {
			model.addAttribute("message","없는 회원 정보입니다.");
			return "admin/adminloginForm";
		}
		HashMap<String, Object> loginAdmin = list.get(0);
		if(!loginAdmin.get("PWD").equals(workPwd)) {
			model.addAttribute("message", "아이디 혹은 비밀번호가 틀렸습니다.");
			return "admin/adminloginForm";
		} else if(loginAdmin.get("PWD").equals(workPwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", loginAdmin);
			return "admin/adminmain";
		} else {
			model.addAttribute("message" , "비밀번호가 다릅니다");
			return "admin/adminloginForm";
		}
		
		
	}
	
	
	@RequestMapping(value="/adminlogout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginAdmin");
		return "redirect:/a.do";
	}
	
	

	@RequestMapping("/adminQnaList.do")
	public ModelAndView adminQnaList(HttpServletRequest request){

		
		ModelAndView mav= new ModelAndView();
		HttpSession session=request.getSession();
		
		HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginAdmin");
	
	
		
		if(loginUser == null)
			mav.setViewName("admin/adminloginForm");
		else {

			
			int page = 1;
			if(  request.getParameter("first") != null  ) {
				page=1;
				session.removeAttribute("page");
				session.removeAttribute("key");
			}
			
			if( request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			}else if( session.getAttribute("page") != null ) {
				page = (Integer)session.getAttribute("page");
			}else {
				page = 1;
				session.removeAttribute("page");
			}
			
			String key = "";
			if( request.getParameter("key") != null ) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			} else if( session.getAttribute("key")!= null ) {
				key = (String)session.getAttribute("key");
			} else {
				session.removeAttribute("key");
				key = "";
			}
			
			String order="";
			if(request.getParameter("tag") != null ) {
				order = request.getParameter("tag");
				session.setAttribute("order", order);
			} else if( session.getAttribute("order")!= null ) {
				order = (String)session.getAttribute("order");
			} else {
				session.removeAttribute("order");
				order = "";
			}
		
			Paging paging = new Paging();
			paging.setPage(page);
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put( "cnt", 0 );
		
				if(key.equals("")) {
					
					System.out.println("key가 널이면");
					as.getallcountQnaList( paramMap );
				}else {
					paramMap.put( "key", key );
					System.out.println("key가 널이면아니면"+key);
					as.getallcountQnaList1( paramMap );
				}
					
				System.out.println("1111111111111111111111"+order);
				System.out.println("1111111111111111111111"+key);
				
				int cnt = Integer.parseInt( paramMap.get("cnt").toString() );	
				paging.setTotalCount(cnt);
				paging.paging();
				
				
				
			if(order.equals("1") ||order.equals("")) {	
			
	
	
			paramMap.put("startNum" , paging.getStartNum() );
			paramMap.put("endNum", paging.getEndNum() );
			paramMap.put("key", key);			
			paramMap.put( "ref_cursor", null );
			as.adminlistQna(paramMap);
			}else if(order.equals("2")) {
				
		

				paramMap.put("startNum" , paging.getStartNum() );
				paramMap.put("endNum", paging.getEndNum() );
				paramMap.put("key", key);		
				paramMap.put( "ref_cursor", null );
				as.adminlistQna2(paramMap);
			}else if(order.equals("3")) {
				
			
		
				paramMap.put("startNum" , paging.getStartNum() );
				paramMap.put("endNum", paging.getEndNum() );
				paramMap.put("key", key);
				paramMap.put( "ref_cursor", null );
				as.adminlistQna3(paramMap);
				
			}else if(order.equals("4")) {
				
			
			
				paramMap.put("startNum" , paging.getStartNum() );
				paramMap.put("endNum", paging.getEndNum() );
				paramMap.put("key", key);
				paramMap.put("order", order);
				paramMap.put( "ref_cursor", null );
				as.adminlistQna4(paramMap);
			}
			

	
			
			ArrayList< HashMap<String,Object> > list 
				= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			
			
			mav.addObject("qnaList" ,list );		
			mav.addObject("order",order);
			mav.addObject("paging", paging);
			mav.addObject("key", key);
			mav.setViewName("admin/qna/adminqnaList");

					
	}
		
		return mav;
	
	
	

  }   
	

	@RequestMapping("/adminQnaDetail.do")
	public ModelAndView admin_qna_detail(HttpServletRequest request,
			@RequestParam("qnaseq") String qnaseq) {
		ModelAndView mav= new ModelAndView();
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginAdmin");
	    System.out.println(1);
	    if(loginUser==null) mav.setViewName("admin/adminloginForm");
	    else {
	    	HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put( "qnaseq", qnaseq );

	    	as.getQna(paramMap);
	    	ArrayList< HashMap<String,Object> > list 
			= (ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
	        
	    	mav.addObject("qnaDto", list.get(0));
	  
		    	mav.setViewName("admin/qna/adminqnaDetail");
		    ;
		    
	    }
		return mav;
	}
	

	@RequestMapping("/adminQnaRepsave.do")
	public ModelAndView admin_qna_repsave(HttpServletRequest request
	,@RequestParam("qnaseq") String qnaseq) {
		ModelAndView mav= new ModelAndView();

		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginAdmin");
	    
	    if(loginUser==null) mav.setViewName("admin/adminloginForm");
	    else {
	    	HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put( "qnaseq", qnaseq );
			paramMap.put( "reply", request.getParameter("reply") );
	    		
	    			as.updateQnaReply(paramMap);
	    			
	    			mav.setViewName("redirect:/adminQnaList.do");
	    }
		return mav;
	}	   




	@RequestMapping("/adminMemberList.do")
	public ModelAndView adminMemberList(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		HttpSession session=request.getSession();
		
		HashMap<String, Object> loginAdmin = (HashMap<String, Object>)session.getAttribute("loginAdmin");
	
		
		if(loginAdmin == null)
			mav.setViewName("admin/adminloginForm");
		else {
			int page = 1;
			if( request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if( session.getAttribute("page")!= null ) {
				page = (int) session.getAttribute("page");
			} else {
				page = 1;
				session.removeAttribute("page");
			}
		
		
			String key = "";
			if( request.getParameter("key") != null ) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			} else if( session.getAttribute("key")!= null ) {
				key = (String)session.getAttribute("key");
			} else {
				session.removeAttribute("key");
				key = "";
			}
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("key", key);
			paramMap.put("count", 0);
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			as.getAllCountMember(paramMap); //key,"hotelmember","name"
			int count = (int)paramMap.get("count");
			paging.setTotalCount(count);

			paramMap.put("startNum" , paging.getStartNum() );
			paramMap.put("endNum", paging.getEndNum() );
			paramMap.put( "ref_cursor", null );
			as.listMember(paramMap); //paging, key 
		
			ArrayList<HashMap<String, Object>> list = 
					(ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			
			mav.addObject("memberList" , list);
			mav.addObject("paging", paging);
			mav.addObject("key", key);
			mav.setViewName("admin/member/adminMemberList");		
		}
		return mav;
	}
	
	

	@RequestMapping("adminMemberDetailBook.do")
	public ModelAndView adminMemberDetailBook(HttpServletRequest request,
			@RequestParam("id") String id) {
		ModelAndView mav= new ModelAndView();

		String url = "admin/member/adminMemberDetailBook";
		HttpSession session = request.getSession();
		HashMap<String, Object> loginAdmin = (HashMap<String, Object>)session.getAttribute("loginAdmin");
		
	    int page=1;
	    if( request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			session.setAttribute("page", page);
			session.setAttribute("id",id);
		} else if( session.getAttribute("page")!= null ) {
			page = (int) session.getAttribute("page");
			session.setAttribute("id",id);
		} else {
			page = 1;
			session.removeAttribute("page");
			session.setAttribute("id",id);
		}
	
	    String booknums="";
		String indate="";
		String outdate="";
	    if(loginAdmin==null) mav.setViewName("admin/adminloginForm");
		Paging paging = new Paging();
		paging.setPage(page);

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		if(!booknums.equals("")) paramMap.put("booknums", Integer.parseInt(booknums));
		else if(booknums.equals("")) paramMap.put("booknums", booknums);
		paramMap.put("indate", indate);
		paramMap.put("outdate", outdate);
		paramMap.put("id", id);
		paramMap.put("count", 0);
		
		abs.getAllCount(paramMap);
		int count=(int) paramMap.get("count");
		paging.setTotalCount(count);
		paging.paging();
		
		mav.addObject("paging", paging);
		mav.addObject("action", "adminMemberDetailBook?id="+id);

		paramMap.put("ref_cursor", null);
		ms.getMember(paramMap);
		ArrayList<HashMap<String, Object>> list1 = 
				(ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		mav.addObject("dto", list1.get(0));

		paramMap.put("startNum" , paging.getStartNum() );
		paramMap.put("endNum", paging.getEndNum() );
		paramMap.put("ref_cursor2", null);
		abs.getMemberBook(paramMap); // id, paging, booknums, indate, outdate

		ArrayList<HashMap<String, Object>> list2 = 
				(ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor2");
		mav.addObject("list", list2);
		mav.setViewName("admin/member/adminMemberDetailBook");
		
	    return mav;
	}

	@RequestMapping("adminMemberDetail.do")
	public ModelAndView adminMemberDetail(HttpServletRequest request,
			@RequestParam("id") String id) {
			
		ModelAndView mav= new ModelAndView();

		HttpSession session = request.getSession();
		HashMap<String, Object> loginAdmin = (HashMap<String, Object>)session.getAttribute("loginAdmin");
	    if(loginAdmin==null) mav.setViewName("admin/adminloginForm");
	    
	    HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("ref_cursor", null);

	    ms.getMember(paramMap);
		ArrayList<HashMap<String, Object>> list = 
				(ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
	    String addr = list.get(0).get("ADDRESS").toString(); //주소 추출
		int k1 = addr.indexOf(" "); // 첫 번째 공백의 위치 찾음
		int k2 = addr.indexOf(" ",k1+1); // 첫 번째 공백 위치의 다음위치부터 두 번째 공백 위치 찾음
		int k3 = addr.indexOf(" ",k2+1); // 두 번째 공백 위치의 다음위치부터 세 번째 공백 위치 찾음
		// 서울시 마포구 대현동 115-15 세 번째 공백 위치 k3값 ->11 (0부터 시작)
		String addr1 =addr.substring(0,k3); // 맨 앞부터 세 번째 공백 위치 바로 전까지 - 주소 앞부분
		String addr2 =addr.substring(k3+1); // 세 번째 공백 뒷글자부터 맨 끝까지 - 주소 뒷부분
		
		mav.addObject("addr1",addr1);
		mav.addObject("addr2",addr2);
		mav.addObject("dto", list.get(0));
		
		mav.setViewName("admin/member/adminMemberDetail");
		
	    return mav;
	}
	

	@RequestMapping(value="/adminMemberUpdate.do", method=RequestMethod.POST)
	public ModelAndView adminMemberUpdate(HttpServletRequest request,
			@RequestParam("id") String id) {
			
		ModelAndView mav= new ModelAndView();

		HttpSession session = request.getSession();
		HashMap<String, Object> loginAdmin = (HashMap<String, Object>)session.getAttribute("loginAdmin");
	    if(loginAdmin==null) mav.setViewName("admin/adminloginForm");
	    
	    HashMap<String, Object> paramMap = new HashMap<String, Object>();
	    paramMap.put("ID", request.getParameter("id"));
		paramMap.put("PWD", request.getParameter("pwd"));
		paramMap.put("NAME", request.getParameter("name"));
		paramMap.put("EMAIL", request.getParameter("email"));
		paramMap.put("ZIP_NUM", request.getParameter("zip_num"));
		paramMap.put("PHONE", request.getParameter("phone"));
		paramMap.put("ADDRESS", request.getParameter("addr1") + " " + request.getParameter("addr2"));
		
		ms.updateMember(paramMap);
		request.setAttribute("message", "정상적으로 수정되었습니다");
		
		String addr = paramMap.get("ADDRESS").toString(); //주소 추출
		int k1 = addr.indexOf(" "); // 첫 번째 공백의 위치 찾음
		int k2 = addr.indexOf(" ",k1+1); // 첫 번째 공백 위치의 다음위치부터 두 번째 공백 위치 찾음
		int k3 = addr.indexOf(" ",k2+1); // 두 번째 공백 위치의 다음위치부터 세 번째 공백 위치 찾음
		// 서울시 마포구 대현동 115-15 세 번째 공백 위치 k3값 ->11 (0부터 시작)
		String addr1 =addr.substring(0,k3); // 맨 앞부터 세 번째 공백 위치 바로 전까지 - 주소 앞부분
		String addr2 =addr.substring(k3+1); // 세 번째 공백 뒷글자부터 맨 끝까지 - 주소 뒷부분
		
		mav.addObject("addr1",addr1);
		mav.addObject("addr2",addr2);
		mav.addObject("dto", paramMap);
		mav.setViewName("admin/member/adminMemberDetail");
		
	    return mav;
	} 
}
