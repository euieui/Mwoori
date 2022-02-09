package woori.hotel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import woori.hotel.dao.QnaDAO;
import woori.hotel.service.QnaService;


@Service(value="QnaService")
public class QnaServiceimpl  extends EgovAbstractServiceImpl implements QnaService {

	@Resource(name="QnaDAO") QnaDAO qdao;
	
}
