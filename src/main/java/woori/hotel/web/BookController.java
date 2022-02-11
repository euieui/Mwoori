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
import org.springframework.web.servlet.ModelAndView;

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
	
	
	
	
	@RequestMapping(value="/listbookcheck.do")
	public ModelAndView listbookcheck(HttpServletRequest request, 
			@RequestParam("bdseq") int bdseq) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>) session.getAttribute("loginUser");
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bdseq", bdseq);
		paramMap.put("ref_cursor", null);
	    if(loginUser==null) mav.setViewName("member/login");
	    else {
	    	abs.getBookDetail(paramMap);
	    	ArrayList<HashMap<String, Object>> list = 
	    			(ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
	    	mav.addObject("bookcheck",list.get(0));
	    	mav.setViewName("mypage/listbookcheck");
		}
		
		return mav;
	}
	
	
	
	
	@RequestMapping(value="/changeRoom.do")
	public ModelAndView changeRoom(HttpServletRequest request, 
			@RequestParam("bdseq") int bdseq) {
		
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>) session.getAttribute("loginUser");
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bdseq", bdseq);
		paramMap.put("ref_cursor", null);
	    if(loginUser==null) mav.setViewName("member/login");
	    else {
	    	abs.getBookDetail(paramMap);
	    	ArrayList<HashMap<String, Object>> list = 
	    			(ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
	    	mav.addObject("bookcheck",list.get(0));
	    	paramMap.put("hotelnum", list.get(0).get("HOTELNUM"));
	    	paramMap.put("max", 0);
	    	abs.getMaxBed(paramMap);
	    	mav.addObject("max",paramMap.get("max"));
	    	mav.setViewName("mypage/changeRoom");
		}
		
		return mav;
	}
	
	
	
	
	@RequestMapping(value="/gotochangeroom.do")
	public String gotochangeroom(HttpServletRequest request, 
			@RequestParam("number") int number, @RequestParam("bdseq") int bdseq) {
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>) session.getAttribute("loginUser");
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bdseq", bdseq);
		paramMap.put("number", number);
	    if(loginUser==null) return "member/login";
	    else {
	    	abs.changePeople(paramMap);
	    	}
		return "redirect:/listbookcheck.do?bdseq="+bdseq;
	}
	
	
	
	
	@RequestMapping(value="/bookcancel.do")
	public String bookcancel(@RequestParam("bdseq") int bdseq,
			@RequestParam("checkin") String checkin, 
			@RequestParam("checkout") String checkout,
			@RequestParam("price") int price, HttpServletRequest request) {
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>) session.getAttribute("loginUser");
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bdseq", bdseq);
		paramMap.put("checkin", checkin);
		paramMap.put("checkout", checkout);
		paramMap.put("price", price);
		paramMap.put("ref_cursor", null);
		paramMap.put("refund", 0);
		abs.getBookDetail(paramMap);
		ArrayList<HashMap<String, Object>> list = 
    			(ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
		paramMap.put("result", list.get(0).get("RESULT"));
		
	    if(loginUser==null) return "member/login";
	    else {
			
			abs.requestBookCancel(paramMap);
			
			return "redirect:/listbookcheck.do?bdseq="+bdseq;
		}
	}

}
