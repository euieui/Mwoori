package woori.hotel.dao;

import java.util.HashMap;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper(value="MainDAO")
public interface MainDAO {

	void confirmRoom(HashMap<String, Object> paramMapDBool);

	void imglist(HashMap<String, Object> paramMap);

}
