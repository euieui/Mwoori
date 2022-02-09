package woori.hotel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import woori.hotel.dao.AdminBookDAO;
import woori.hotel.service.AdminBookService;

@Service(value="AdminBookService")
public class AdminBookServiceimpl extends EgovAbstractServiceImpl implements AdminBookService{
	@Resource(name="AdminBookDAO") AdminBookDAO abdao;

}
