package woori.hotel.dao;

import java.util.HashMap;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper(value="AdminDAO")
public interface AdminDAO {

	void getAdmin(HashMap<String, Object> paramMap);

}
