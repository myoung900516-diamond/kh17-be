package com.kh.spring11.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring11.dao.AttachDao;
import com.kh.spring11.dao.SaleDao;
import com.kh.spring11.dto.AttachDto;
import com.kh.spring11.dto.SaleDto;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.sale.SaleAddRequestVO;
import com.kh.spring11.vo.sale.SaleAddRequestVO2;
import com.kh.spring11.vo.sale.SaleAddResponseVO;
import com.kh.spring11.vo.sale.SaleDetailResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service 
//@Profile("local") //Spring Profile에서 local이 활성화 되어 있을 경우 등록될 대상
public class SaleServiceImpl implements SaleService{
	
	@Autowired
	private SaleDao saleDao;
	
	@Autowired
	private AttachService attachService;
	
	@Autowired
	private AttachDao attachDao;
	
	
	

	@Transactional
	@Override
	public SaleAddResponseVO add(SaleAddRequestVO request) throws IllegalStateException, IOException {
//		log.debug("Local용 SaleService 실행");
		
		//[1]상품 번호 생성
		int saleNo= saleDao.sequence();
		
		//[2] 등록을 위한 Dto생성
		SaleDto saleDto = new SaleDto();
		saleDto.setSaleNo(saleNo);
		BeanUtils.copyProperties(request, saleDto, "saleDiscountPrice");//할인가격 빼고 나머지 정보 설정
		
		//(+추가) 할인가격이 없으면 판매가격과 동일하게 할인가격을 실행
		if(request.getSaleDiscountPrice() == null ) {
			saleDto.setSaleDiscountPrice(request.getSaleOriginalPrice());
		}
		else {
			saleDto.setSaleDiscountPrice(request.getSaleDiscountPrice());
		}
		
		//[3]상품 등록
		saleDao.insert(saleDto);
		
		//[4]사용자에게 알려주기 위해 등록된 정보를 재조회
		SaleDto resultDto=saleDao.selectOne(saleNo);
		SaleAddResponseVO response = new SaleAddResponseVO();
		BeanUtils.copyProperties(resultDto, response);
		
		
		//[5]첨부파일이 있으면 첨부파일을 등록 후 상품정보와 연결
		MultipartFile thumbnail = request.getThumbnail();
		if(thumbnail.isEmpty() == false) {
			int attachNo = attachService.save(thumbnail);
			saleDao.connect(saleNo, attachNo);
		}
		
		//[6]상세이미지가 있으면 첨부파일 등록 후 상품정보와 연결 
		List<MultipartFile> detailImages = request.getDetailImages();
		boolean exist = detailImages != null && detailImages.size() > 0;
		if(exist) {//파라미터가 있으면
			for(MultipartFile detail : detailImages) {//반복하며
				if(detail.isEmpty() == false) { //비어있지 않은 이미지를 
					int attachNo = attachService.save(detail);
					saleDao.connectDetailImage(saleNo, attachNo);
				}
			}
			
		}
		
		
		return response;
	}



	@Transactional //이 메소드에서 발생하는 DB변경작업은 다 실행되거나 모두 실행이 안되거나 (DB조회는 해당안함)
	@Override
	public SaleAddResponseVO add(
			SaleAddRequestVO2 request, 
			MultipartFile thumbnail,
			List<MultipartFile> detailImages
			)
			throws IllegalStateException, IOException {
		
		//[1]상품 번호 생성
				int saleNo= saleDao.sequence();
				
				//[2] 등록을 위한 Dto생성
				SaleDto saleDto = new SaleDto();
				saleDto.setSaleNo(saleNo);
				BeanUtils.copyProperties(request, saleDto, "saleDiscountPrice");//할인가격 빼고 나머지 정보 설정
				
				//(+추가) 할인가격이 없으면 판매가격과 동일하게 할인가격을 실행
				if(request.getSaleDiscountPrice() == null ) {
					saleDto.setSaleDiscountPrice(request.getSaleOriginalPrice());
				}
				else {
					saleDto.setSaleDiscountPrice(request.getSaleDiscountPrice());
				}
				
				//[3]상품 등록
				saleDao.insert(saleDto);
				
				//[4]사용자에게 알려주기 위해 등록된 정보를 재조회
				SaleDto resultDto=saleDao.selectOne(saleNo);
				SaleAddResponseVO response = new SaleAddResponseVO();
				BeanUtils.copyProperties(resultDto, response);
				
				
				//[5]첨부파일이 있으면 첨부파일을 등록 후 상품정보와 연결
//				MultipartFile thumbnail = request.getThumbnail();
				if(thumbnail != null && thumbnail.isEmpty() == false) {
					int attachNo = attachService.save(thumbnail);
					saleDao.connect(saleNo, attachNo);
				}
				
				//[6]상세이미지가 있으면 첨부파일 등록 후 상품정보와 연결 
				boolean exist = detailImages != null && detailImages.size() > 0;
				if(exist) {//파라미터가 있으면
					for(MultipartFile detail : detailImages) {//반복하며
						if(detail.isEmpty() == false) { //비어있지 않은 이미지를 
							int attachNo = attachService.save(detail);
							saleDao.connectDetailImage(saleNo, attachNo);
						}
					}
					
				}
		return response;
	}



	@Override
	public SaleDetailResponseVO findSaleDetail(int saleNo) throws Exception {
		SaleDto saleDto = saleDao.selectOne(saleNo);
		if(saleDto == null) throw new TargetNotfoundException();
		
		
		//없을 수 있으니까
		Integer attachNo = saleDao.findAttachNo(saleNo);
		
		AttachDto thumbnail = attachNo != null ? 
				attachDao.selectOne(attachNo) : null;
		
//		System.out.println(thumbnail);
		
		
		List<Integer> attachNumbers = saleDao.findAttachNumbers(saleNo);
		List<AttachDto> details = attachDao.selectList(attachNumbers);
		
//		attachService.load(attachNo);
		
		
		
		return SaleDetailResponseVO.builder()
					.saleDto(saleDto)
					.thumbnail(thumbnail)
					.detailImages(details)
				.build();
	}



	@Override
	public void delete(int saleNo) {
		SaleDto saleDto = saleDao.selectOne(saleNo);
		if(saleDto == null) throw new TargetNotfoundException();
		
		Integer attachNo = saleDao.findAttachNo(saleNo);
		attachDao.delete(attachNo);
		
		saleDao.delete(saleNo);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
