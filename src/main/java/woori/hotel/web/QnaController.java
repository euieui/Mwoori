package woori.hotel.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import woori.hotel.service.QnaService;


@Controller
public class QnaController {
	@Resource(name="QnaService") QnaService qs;
}
