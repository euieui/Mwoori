package woori.hotel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import woori.hotel.dao.MemberDAO;
import woori.hotel.web.MemberService;

@Service(value="MemberService")
public class MemberServiceimpl extends EgovAbstractServiceImpl implements MemberService {

	@Resource(name="MemberDAO") MemberDAO mdao;
}
