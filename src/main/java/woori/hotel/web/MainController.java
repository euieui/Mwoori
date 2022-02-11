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

import woori.hotel.service.MainService;


@Controller
public class MainController {
	
	@Resource(name="MainService") MainService ms;
	
	@RequestMapping(value="/start.do")
	public String start(HttpServletRequest request, Model model) {
		return "start";
	}
	
	@RequestMapping("/main.do")
	public ModelAndView index(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="bookForm.do", method=RequestMethod.POST)
	public ModelAndView bookForm(@RequestParam("roomnum") int roomnum,
			@RequestParam("usernum") int usernum, @RequestParam("checkin") String checkin,
			@RequestParam("checkout") String checkout, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		HashMap<String, Object> paramMapDBool = new HashMap<String, Object>();
		paramMapDBool.put("checkin", checkin);
		paramMapDBool.put("checkout", checkout);
		paramMapDBool.put("kind", "Deluxe");
		paramMapDBool.put("usernum", usernum);
		paramMapDBool.put("roomnum", roomnum);
		paramMapDBool.put("bool", null);
		ms.confirmRoom(paramMapDBool);
		
		HashMap<String, Object> paramMapBDBool = new HashMap<String, Object>();
		paramMapBDBool.put("checkin", checkin);
		paramMapBDBool.put("checkout", checkout);
		paramMapBDBool.put("kind", "Business Deluxe");
		paramMapBDBool.put("usernum", usernum);
		paramMapBDBool.put("roomnum", roomnum);
		paramMapBDBool.put("bool", null);
		ms.confirmRoom(paramMapBDBool);
		
		HashMap<String, Object> paramMapGCDBool = new HashMap<String, Object>();
		paramMapGCDBool.put("checkin", checkin);
		paramMapGCDBool.put("checkout", checkout);
		paramMapGCDBool.put("kind", "Grand Corner Deluxe");
		paramMapGCDBool.put("usernum", usernum);
		paramMapGCDBool.put("roomnum", roomnum);
		paramMapGCDBool.put("bool", null);
		ms.confirmRoom(paramMapGCDBool);
		
		HashMap<String, Object> paramMapEBDBool = new HashMap<String, Object>();
		paramMapEBDBool.put("checkin", checkin);
		paramMapEBDBool.put("checkout", checkout);
		paramMapEBDBool.put("kind", "Executive Business Deluxe");
		paramMapEBDBool.put("usernum", usernum);
		paramMapEBDBool.put("roomnum", roomnum);
		paramMapEBDBool.put("bool", null);
		ms.confirmRoom(paramMapEBDBool);
		
		boolean DBool = false;
		boolean BDBool = false;
		boolean GCDBool = false;
		boolean EBDBool = false;
		
		if(Integer.parseInt(paramMapDBool.get("bool").toString()) == 1) DBool = true;
		if(Integer.parseInt(paramMapBDBool.get("bool").toString()) == 1) BDBool = true;
		if(Integer.parseInt(paramMapGCDBool.get("bool").toString()) == 1) GCDBool = true;
		if(Integer.parseInt(paramMapEBDBool.get("bool").toString()) == 1) EBDBool = true;
		
		mav.addObject("checkin",checkin);
		mav.addObject("checkout",checkout);
		mav.addObject("roomnum",roomnum);
		mav.addObject("usernum",usernum);
		mav.addObject("DBool",DBool);
		mav.addObject("BDBool",BDBool);
		mav.addObject("GCDBool",GCDBool);
		mav.addObject("EBDBool",EBDBool);
		mav.setViewName("bookDetail");
		
		return mav;
	}
	

	@RequestMapping("/gotobook.do")
	public ModelAndView gotobook(HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		
		String kind=request.getParameter("kind");
		
		mav.addObject("kind",kind);
		mav.setViewName("room/gotobook");
		return mav;	
	}
	
	@RequestMapping(value="/gotobookdetail.do", method=RequestMethod.POST)
	public ModelAndView gotobookdetail(@RequestParam("roomnum") int roomnum,
			@RequestParam("usernum") int usernum, @RequestParam("checkin") String checkin,
			@RequestParam("checkout") String checkout, HttpServletRequest request) {
	
		String kind=request.getParameter("kind");
				boolean DBool=false;
				boolean BDBool=false;
				boolean GCDBool=false;
				boolean EBDBool=false;
		
		
ModelAndView mav = new ModelAndView();
if(kind.equals("Deluxe")) {
			DBool=true;
			HashMap<String, Object> paramMapDBool = new HashMap<String, Object>();
			paramMapDBool.put("checkin", checkin);
			paramMapDBool.put("checkout", checkout);
			paramMapDBool.put("kind", "Deluxe");
			paramMapDBool.put("usernum", usernum);
			paramMapDBool.put("roomnum", roomnum);
			paramMapDBool.put("bool", null);
			ms.confirmRoom(paramMapDBool);



					mav.addObject("DBool",DBool);	
					mav.addObject("BDBool",BDBool);
					mav.addObject("GCDBool",GCDBool);
					mav.addObject("EBDBool",EBDBool);
		}else if(kind.equals("Business Deluxe")) {
							BDBool=true;
							HashMap<String, Object> paramMapDBool = new HashMap<String, Object>();
							paramMapDBool.put("checkin", checkin);
							paramMapDBool.put("checkout", checkout);
							paramMapDBool.put("kind", "Business Deluxe");
							paramMapDBool.put("usernum", usernum);
							paramMapDBool.put("roomnum", roomnum);
							paramMapDBool.put("bool", null);
							ms.confirmRoom(paramMapDBool);
							
							mav.addObject("BDBool",BDBool);
							mav.addObject("DBool",DBool);
							mav.addObject("GCDBool",GCDBool);
							mav.addObject("EBDBool",EBDBool);
			}else if(kind.equals("Grand Corner Deluxe")) {
							GCDBool=true;
							HashMap<String, Object> paramMapDBool = new HashMap<String, Object>();
							paramMapDBool.put("checkin", checkin);
							paramMapDBool.put("checkout", checkout);
							paramMapDBool.put("kind", "Grand Corner Deluxe");
							paramMapDBool.put("usernum", usernum);
							paramMapDBool.put("roomnum", roomnum);
							paramMapDBool.put("bool", null);
							ms.confirmRoom(paramMapDBool);
							 
							 
							 
							mav.addObject("GCDBool",GCDBool);
							mav.addObject("DBool",DBool);
							mav.addObject("BDBool",BDBool);		
							mav.addObject("EBDBool",EBDBool);
	}else {	
							EBDBool=true;
							HashMap<String, Object> paramMapDBool = new HashMap<String, Object>();
							paramMapDBool.put("checkin", checkin);
							paramMapDBool.put("checkout", checkout);
							paramMapDBool.put("kind", "Executive Business Deluxe");
							paramMapDBool.put("usernum", usernum);
							paramMapDBool.put("roomnum", roomnum);
							paramMapDBool.put("bool", null);
							ms.confirmRoom(paramMapDBool);
							
							
							mav.addObject("EBDBool",EBDBool);
							mav.addObject("DBool",DBool);
							mav.addObject("BDBool",BDBool);
							mav.addObject("GCDBool",GCDBool);
							
							}
							
							
							mav.addObject("checkin",checkin);
							mav.addObject("checkout",checkout);
							mav.addObject("roomnum",roomnum);
							mav.addObject("usernum",usernum);
							
							
							
							
							mav.setViewName("bookDetail");
								return mav;
							}
	
	

	
	

	
	@RequestMapping("/gotoimgshow.do")
	public ModelAndView gotoimgshow( HttpServletRequest request
			) {
		ModelAndView mav=new ModelAndView();
		
		String num=request.getParameter("num");
		

		String kind ="";
		
		if(num.equals("1")) {
			 kind="Deluxe";	 
		}else if(num.equals("2")) {
			kind="BusinessDeluxe";
		}else if(num.equals("3")) {
			kind="GrandCornerDeluxe";
		}else{
			kind="ExecuticeBusinessDeluxe";
		}
	  	HashMap<String, Object> paramMap = new HashMap<String, Object>();
	  	paramMap.put("kind",kind);
		
	  	ms.imglist(paramMap);
	  	
		ArrayList<HashMap<String, Object>> list 
		= (ArrayList<HashMap<String, Object>>)paramMap.get("ref_cursor");
	
	
		
		mav.addObject("imglist",list);

		mav.setViewName("room/gotoimgshow");
		return mav;
	}
	
	@RequestMapping("/gotoroom.do")
	public ModelAndView Deluxe(HttpServletRequest request) {
		
		ModelAndView mav= new ModelAndView();
	String num=request.getParameter("num");
		
		System.out.println("num:"+num);
		String kind ="";
		
		if(num.equals("1")) {
			 kind="Deluxe";	 
			 mav.setViewName("room/Deluxe");
		}else if(num.equals("2")) {
			kind="BusinessDeluxe";
			mav.setViewName("room/BusinessDeluxe");
		}else if(num.equals("3")) {
			kind="GrandCornerDeluxe";
			mav.setViewName("room/GrandCornerDeluxe");
		}else{
			kind="ExecuticeBusinessDeluxe";
			mav.setViewName("room/ExecuticeBusinessDeluxe");
		}
	  	HashMap<String, Object> paramMap = new HashMap<String, Object>();
	  	paramMap.put("kind",kind);
	  	ms.imglist(paramMap);
		
		ArrayList<HashMap<String, Object>> list 
		= (ArrayList<HashMap<String, Object>>)paramMap.get("ref_cursor");
		
	
	
		
		mav.addObject("imglist",list);
		
		return mav;		
	}
	
	@RequestMapping("/room.do")
	public String room() {
		return "room/room";
	}
	@RequestMapping("/gallery.do")
	public String gallery() {
		return "gallery/gallery";
	}
	@RequestMapping("/v.do")
	public String video() {
		return "gallery/video";
	}
	@RequestMapping("/sitemap.do")
	public String sitemap() {
		return "Info/sitemap";
	}

	@RequestMapping("/map.do")
	public String map() {
		return"Info/map";
	}
	
	@RequestMapping(value="/book.do")
	public String book(@RequestParam("roomnum") int roomnum,
			@RequestParam("usernum") int usernum, @RequestParam("checkin") String checkin,
			@RequestParam("checkout") String checkout, @RequestParam("kind") String kind,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = (HashMap<String, Object>) session.getAttribute("loginUser");
		if(loginUser == null) {
			return "member/login";
		}else {
			
			ArrayList<Integer> remainList = ms.remainList(checkin, checkout, kind);
			ArrayList<Integer> userNumList = new ArrayList<>();
			
		
			int a = usernum / roomnum ;  
			int b = usernum % roomnum; 
			
			for(int i = 0 ; i<roomnum ; i++) userNumList.add(a);
			for(int i = 0 ; i<b ; i ++) userNumList.set(i, userNumList.get(i)+1);
			
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("checkin", checkin);
			paramMap.put("checkout", checkout);
			
			ms.insertRoom(remainList,(String) loginUser.get("ID"),userNumList,checkin,checkout);
			return "redirect:/bookChecklist.do";

		}
		
	
	}
	
	
}
