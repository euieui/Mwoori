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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import woori.hotel.service.AdminBookService;
import woori.hotel.util.BookVO;
import woori.hotel.util.Paging;

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
	

	@RequestMapping(value="/bookChecklist.do")
	public ModelAndView bookChecklist(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>) session.getAttribute("loginUser");
	    if(loginUser==null) mav.setViewName("member/login");
	    else {
			int page = 1;
			String booknums="";
			String indate="";
			String outdate="";
			
			if(request.getParameter("booknums")!=null) {
				booknums=request.getParameter("booknums");
				session.setAttribute("booknums", booknums);
			} else if(session.getAttribute("booknums")!=null) {
				booknums=(String)session.getAttribute("booknums");
			} else {
				session.removeAttribute("booknums");
				booknums="";
			}
			
			if(request.getParameter("page")!=null) {
				page=Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if(session.getAttribute("page")!=null) {
				page = (int)session.getAttribute("page");
			} else {
				page= 1;
				session.removeAttribute("page");
			}
			
			if(request.getParameter("checkins")!=null) {
				indate=request.getParameter("checkins");
				session.setAttribute("checkins", indate);
			} else if(session.getAttribute("checkins")!=null) {
				indate=(String)session.getAttribute("checkins");
			} else {
				session.removeAttribute("checkins");
				indate="";
			}
			
			if(request.getParameter("checkouts")!=null) {
				outdate=request.getParameter("checkouts");
				session.setAttribute("checkouts", outdate);
			} else if(session.getAttribute("checkouts")!=null) {
				outdate=(String)session.getAttribute("checkouts");
			} else {
				session.removeAttribute("checkouts");
				outdate="";
			}
			
			if(request.getParameter("a")!=null) {
				System.out.println("파라미터 a 값 : "+request.getParameter("a"));
				session.removeAttribute("checkins");
				indate="";
				session.removeAttribute("checkouts");
				outdate="";
				session.removeAttribute("booknums");
				booknums="";
			}
			
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			if(!booknums.equals("")) paramMap.put("booknums", Integer.parseInt(booknums));
			else if(booknums.equals("")) paramMap.put("booknums", booknums);
			paramMap.put("indate", indate);
			paramMap.put("outdate", outdate);
			paramMap.put("id", loginUser.get("ID"));
			paramMap.put("count", 0);
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			abs.getAllCount(paramMap);
			//getAllCount(paramMap);
			int count = (int) paramMap.get("count");
			paging.setTotalCount(count);
			
			paramMap.put("ref_cursor", null);
			paramMap.put("startnum", paging.getStartNum());
			paramMap.put("endnum", paging.getEndNum());
			abs.getAllBookList(paramMap);
			
			ArrayList<HashMap<String, Object>> list = 
					(ArrayList<HashMap<String, Object>>) paramMap.get("ref_cursor");
			
			BookVO bvo = new BookVO();
			int price = 0;
			if(list!=null) {
			for(HashMap<String, Object> book : list) {
				price = Integer.parseInt(book.get("PRICE").toString());
				bvo.setPrice(price);
				bvo.setCheckin((Timestamp) book.get("CHECKIN"));
				bvo.setCheckout((Timestamp) book.get("CHECKOUT"));
				bvo.days();
				book.put("PRICE", price);}
				
			}
			
			
			mav.addObject("booklist",list);
			mav.addObject("paging", paging);
			mav.addObject("total",count);
			mav.addObject("booknums",booknums);
			mav.addObject("checkins",indate);
			mav.addObject("checkouts",outdate);
			
			mav.setViewName("mypage/bookchecklist");
	    }
		
		return mav;
	}

}
