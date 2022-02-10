package woori.hotel.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import woori.hotel.service.AdminBookService;
import woori.hotel.util.BookVO;
import woori.hotel.util.Paging;

@Controller
public class AdminBookController {
	
	@Resource(name="AdminBookService") AdminBookService abs;
	
	
	
	
	@RequestMapping(value="/adminbookchecklist.do")
	public ModelAndView adminbookchecklist(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		HashMap<String, Object> loginAdmin = 
				(HashMap<String, Object>) session.getAttribute("loginAdmin");
	    if(loginAdmin==null) mav.setViewName("admin/adminloginForm");
	    else {
			int page = 1;
			String booknums="";
			String indate="";
			String outdate="";
			String id="";
			
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
			
			if(request.getParameter("bookid")!=null) {
				id=request.getParameter("bookid");
				session.setAttribute("bookid", id);
			} else if(session.getAttribute("bookid")!=null) {
				id=(String)session.getAttribute("bookid");
			} else {
				session.removeAttribute("bookid");
				id="";
			}
			
			if(request.getParameter("a")!=null) {
				System.out.println("파라미터 a 값 : "+request.getParameter("a"));
				session.removeAttribute("bookid");
				id="";
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
			paramMap.put("id", id);
			paramMap.put("count", 0);
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			abs.getAllCount(paramMap);
			//getAllCount(paramMap);
			int count = (int) paramMap.get("count");
			paging.setTotalCount(count);
			System.out.println("count : "+count);
			
			paramMap.put("ref_cursor", null);
			paramMap.put("startnum", paging.getStartNum());
			paramMap.put("endnum", paging.getEndNum());
			System.out.println("all book list 전");
			abs.getAllBookList(paramMap);
			System.out.println("all book list 후");
			System.out.println("list size 1 : "+paramMap.get("ref_cursor"));
			
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
			mav.addObject("bookid",id);
			mav.addObject("booknums",booknums);
			mav.addObject("checkins",indate);
			mav.addObject("checkouts",outdate);
			
			mav.setViewName("admin/book/adminbookchecklist");
	    }
		
		return mav;
	}




	

}
