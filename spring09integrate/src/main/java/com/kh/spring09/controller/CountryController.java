package com.kh.spring09.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09.dao.CountryDao;
import com.kh.spring09.dto.CountryDto;
import com.kh.spring09.exception.TargetNotfoundException;
import com.kh.spring09.service.AttachService;
import com.kh.spring09.vo.PageVO;

@Controller
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private CountryDao countryDao;
	@Autowired
	private AttachService attachService;
	
	//등록(화면과 처리 코드 결합)
	//-예상되는 흐름: [입력] -> [처리+출력}
//	@RequestMapping("/country/insert1")
//	@RequestMapping("/country/insert2")
	
//	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	@GetMapping("/insert")
	public String insert() {
		return "country/insert";
	}
//	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@PostMapping("/insert")
	public String insert(@ModelAttribute CountryDto countryDto, 
								@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		int countryNo = countryDao.sequence();
		countryDto.setCountryNo(countryNo);
		countryDao.insert(countryDto);
//		return "country/insert2";
//		return "redirect:/country/insert3";//절대경로
		if(!attach.isEmpty()) {
			int attachNo = attachService.save(attach);
			
			countryDao.connect(countryNo, attachNo);
		}
		return "redirect:./insertComplete";//상대경로
	}
	@RequestMapping("/insertComplete")
	public String insert3() {
		return "country/insertComplete";
	}
	
	//목록 및 검색에 대한 매핑
	@RequestMapping("/list")
	public String list(@ModelAttribute PageVO pageVO ,
//						@RequestParam(required = false) String column, 
//						@RequestParam(required = false) String keyword, 
						Model model) {
		//목록 조회
//		List<CountryDto> list = countryDao.selectList(column, keyword);
		List<CountryDto> list = countryDao.selectList(pageVO);
		model.addAttribute("list", list);
		int count = countryDao.count(pageVO);
		pageVO.setCount(count);
		model.addAttribute("pageVO", pageVO);
		return "country/list";
	}
	//상세조회 매핑
	@RequestMapping("/detail")
	public String detail(@RequestParam int countryNo, Model model) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		//잘못된 번호인 경우(countryDto == null) 이를 오류(500)로 처리
		if(countryDto == null) {
			throw new TargetNotfoundException("존재하지 않는 국가");
//			return "redirect:./notfound";
		}
		model.addAttribute("countryDto", countryDto);
//		//파일번호를 찾아서...복잡해...
//		try {
//			int attachNo = countryDao.searchFlag(countryNo);
//			model.addAttribute("attachNo", attachNo);
//		}
//		catch(Exception e) {}
		return "country/detail";
	}
	//오류매핑
	@RequestMapping("/notfound")
	public String notfound() {
		return "country/notfound";
	}
	
	//삭제매핑
	@RequestMapping("/delete")
	public String delete(@RequestParam int countryNo){
		CountryDto countryDto = countryDao.selectOne(countryNo);
		if(countryDto == null) throw new TargetNotfoundException("존재하지 않는 국가");
		//국가 정보가 지워지면 국기 데이터도 지워지는데 DB만 지워지고 파일은 그대로 남아있다는 문제 발생
		//파일(attach)정보와 실물 파일을 지울 수 있도록 국가 정보 삭제 전에 파일 번호를 알아내야 한다
		//->만약 파일이 없어서 예외가 발생한다면? 그냥 국가 정보만 삭제~
		try {
			int attachNo = countryDao.searchFlag(countryNo);//국기 찾으세요~
			attachService.delete(attachNo);//Attach테이블 데이터 살제 + 파일 삭제 
		}
		catch(Exception e) {}
		
		countryDao.delete(countryNo);
		return "redirect:./list";
	}
	//수정매핑
	@GetMapping("/edit")
	public String edit(@RequestParam int countryNo, Model model) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		if(countryDto == null) throw new TargetNotfoundException("존재하지 않는 국가");
		model.addAttribute("countryDto", countryDto);
		return "country/edit";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute CountryDto countryDto) {
		countryDao.update(countryDto);
		return "redirect:./detail?countryNo=" + countryDto.getCountryNo();
	}
	//국기를 반환하는 매핑
	@RequestMapping("/flag")
	public String flag(@RequestParam int countryNo) {
		try {
			//plan a - 이미지가 존재하는 경우
			int attachNo = countryDao.searchFlag(countryNo);
			return "redirect:/download/modern?attachNo=" + attachNo;
		}
		catch(Exception e ){
			//plan b - 이미지가 존재하지 않는 경우
			return "redirect:/images/noimgpng.png";
		}
	}
	
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
