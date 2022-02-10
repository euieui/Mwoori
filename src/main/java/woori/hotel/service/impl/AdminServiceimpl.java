package woori.hotel.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import woori.hotel.dao.AdminDAO;
import woori.hotel.service.AdminService;

@Service(value="AdminService")
public class AdminServiceimpl extends EgovAbstractServiceImpl implements AdminService{
	@Resource(name="AdminDAO") AdminDAO adao;

	@Override
	public void getAdmin(HashMap<String, Object> paramMap) {
		adao.getAdmin(paramMap);
	}

	@Override
	public void getallcountQnaList(HashMap<String, Object> paramMap) {
		adao.getallcountQnaList(paramMap);
		
	}

	@Override
	public void adminlistQna(HashMap<String, Object> paramMap) {
		adao.adminlistQna(paramMap);
		
	}

	@Override
	public void getQna(HashMap<String, Object> paramMap) {
		adao.getQna(paramMap);
		
	}

	

}
