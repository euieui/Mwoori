package woori.hotel.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import woori.hotel.dao.MemberDAO;
import woori.hotel.service.MemberService;

@Service(value="MemberService")
public class MemberServiceimpl extends EgovAbstractServiceImpl implements MemberService {

	@Resource(name="MemberDAO") MemberDAO mdao;

	@Override
	public void getMember(HashMap<String, Object> paramMap) {
		mdao.getMember(paramMap);
	}

	@Override
	public void confirmPhone1(HashMap<String, Object> paramMap) {
		mdao.confirmPhone1(paramMap);
	}

	@Override
	public void confirmPhone2(HashMap<String, Object> paramMap) {
		mdao.confirmPhone2(paramMap);
	}

	@Override
	public void resetPw(HashMap<String, Object> paramMap) {
		mdao.resetPw(paramMap);
	}
}
