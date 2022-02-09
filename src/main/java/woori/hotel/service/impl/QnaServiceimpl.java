package woori.hotel.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import woori.hotel.dao.QnaDAO;
import woori.hotel.service.QnaService;


@Service(value="QnaService")
public class QnaServiceimpl  extends EgovAbstractServiceImpl implements QnaService {

	@Resource(name="QnaDAO") QnaDAO qdao;

	@Override
	public void listQna(HashMap<String, Object> paramMap) {
		qdao.listQna(paramMap);
		
	}
	
}
