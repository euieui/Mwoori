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

import woori.hotel.service.QnaService;


@Controller
public class QnaController {
	@Resource(name="QnaService") QnaService qs;
	
	
	@RequestMapping("/contact.do")
	public String qna_contact(Model model, HttpServletRequest request) {

	
	 
	    return "qna/contact";
	
	
}
	
	@RequestMapping("/qnaList.do") 
	public ModelAndView qna_list(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>)session.getAttribute("loginUser");
	    ModelAndView mav = new ModelAndView();
	    
	    if (loginUser == null) mav.setViewName("member/login");
	    else {
	    	HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id",loginUser.get("ID"));
			qs.listQna(paramMap);
			ArrayList<HashMap<String, Object>> list 
			= (ArrayList<HashMap<String, Object>>)paramMap.get("ref_cursor");
	    	mav.addObject("qnaList", list );
	    	mav.setViewName("qna/qnaList");
	    }
		return mav;
	}
	
	
	
	
	
	@RequestMapping("/qnaWriteForm.do")
	public String qna_writre_form(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>)session.getAttribute("loginUser");
	    if (loginUser == null) return "member/login";
	    return "qna/qnaWrite";		
	
		
	}
	
	
	
	@RequestMapping(value="/qnaWrite.do", method=RequestMethod.POST)
	public ModelAndView qna_write( 
			  HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		/*
		 * if(request.getParameter("title") != null ) { mav.addObject("message",
		 * "제목을 입력하세요"); mav.setViewName("qna/qnaWrite"); return mav; }else
		 * if(request.getParameter("content") != null ) { mav.addObject("message",
		 * "내용을 입력하세요"); mav.setViewName("qna/qnaWrite"); return mav; }
		 */
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = 
				(HashMap<String, Object>)session.getAttribute("loginUser");
	    if (loginUser == null) mav.setViewName("member/login");
	    else {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id",loginUser.get("ID"));
			paramMap.put("title",request.getParameter("title"));
			paramMap.put("content",request.getParameter("content"));
		   	qs.insertQna(paramMap);
	    }
		mav.setViewName("redirect:/qnaList.do");
		return mav;
	}
	
	
	
	@RequestMapping("/qnaView.do")
	public ModelAndView qna_view(Model model, HttpServletRequest request,
			@RequestParam("qnaseq") int qnaseq) {
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginUser");
	    ModelAndView mav = new ModelAndView();
		if (loginUser == null) mav.setViewName("member/login");
		else {
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("qnaseq",qnaseq);
			 qs.getQna(paramMap);
			ArrayList<HashMap<String, Object>> list 
			= (ArrayList<HashMap<String, Object>>)paramMap.get("ref_cursor");
			mav.addObject("qnaVO", list.get(0));
			mav.setViewName("qna/qnaView");
		}
		return mav;
	}
	
	@RequestMapping("/qnaUpdateForm.do")
	public ModelAndView qna_update_form( HttpServletRequest request,
			@RequestParam("qnaseq") int qnaseq) {
		ModelAndView mav= new ModelAndView();
		HttpSession session = request.getSession();
		
		
		HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginUser");   
		
	    if (loginUser == null) mav.setViewName( "member/login");
	    HashMap<String, Object> paramMap = new HashMap<String, Object>();
	    
		paramMap.put("qnaseq",qnaseq);
		
		 qs.getQna(paramMap);
			ArrayList<HashMap<String, Object>> list 
			= (ArrayList<HashMap<String, Object>>)paramMap.get("ref_cursor");
		 
	    mav.addObject("qnaVO", list.get(0));
	    mav.setViewName("qna/qnaUpdateForm");
	    return mav;
	
	
}
	
	@RequestMapping(value="/qnaUpdate.do", method=RequestMethod.POST)
	public ModelAndView qna_update( Model model, HttpServletRequest request,
			@RequestParam("qnaseq") String qnaseq){
			ModelAndView mav= new ModelAndView();
		
			
			/*
			 * if( request.getParameter("title")!=null) { mav.addObject("message",
			 * "제목을 입력하셔야합니다"); mav.setViewName("qna/qnaUpdateForm"); return mav; } else
			 * if(request.getParameter("content") != null ) { mav.addObject("message",
			 * "내용을 입력하세요"); mav.setViewName("qna/qnaUpdateForm"); return mav; }
			 */
		
			HttpSession session= request.getSession();
			HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginUser");   
		    if (loginUser == null) mav.setViewName("member/login");
		    else {
		        HashMap<String, Object> paramMap = new HashMap<String, Object>();
		        paramMap.put("qnaseq",qnaseq);
		        paramMap.put("id",loginUser.get("ID"));
				paramMap.put("title",request.getParameter("title"));
				paramMap.put("content",request.getParameter("content"));
				qs.updateQna(paramMap);
		
		
		    	
		    }
			mav.setViewName("redirect:/qnaList.do");
			return mav;	
	
	}
	
	@RequestMapping("/qnaDelete.do")
	public String qna_delete(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		HashMap<String, Object> loginUser = (HashMap<String, Object>)session.getAttribute("loginUser");   
		if (loginUser == null) return "loginForm";
	    int qnaseq = Integer.parseInt(request.getParameter("qnaseq"));
	    HashMap<String, Object> paramMap = new HashMap<String, Object>();
	    paramMap.put("qnaseq",qnaseq); 
	    qs.deleteQna(paramMap);
	    
	    return "redirect:/qnaList.do";
	
	
}
	
	
	
	
	
	
	
	
	
}
