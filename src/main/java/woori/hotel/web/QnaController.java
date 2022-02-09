package woori.hotel.web;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import woori.hotel.service.QnaService;


@Controller
public class QnaController {
	@Resource(name="QnaService") QnaService qs;
	
	
	
	
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
	
	
	
	
	
	
	
	
	
	
	
	
}
