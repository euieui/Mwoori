package woori.hotel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import woori.hotel.dao.MainDAO;
import woori.hotel.service.MainService;

@Service(value="MainService")
public class MainServiceimpl extends EgovAbstractServiceImpl implements MainService {

	@Resource(name="MainDAO") MainDAO mdao;
}
