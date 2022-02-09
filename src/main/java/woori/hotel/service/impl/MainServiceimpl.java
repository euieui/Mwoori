package woori.hotel.service.impl;

import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import woori.hotel.dao.MainDAO;
import woori.hotel.service.MainService;

public class MainServiceimpl extends EgovAbstractServiceImpl implements MainService {

	@Resource(name="MainDAO") MainDAO mdao;
}
