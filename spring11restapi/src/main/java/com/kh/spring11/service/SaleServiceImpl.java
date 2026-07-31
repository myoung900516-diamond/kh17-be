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
import com.kh.spring11.error.GetOutException;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.sale.ChangeThumbnailResponseVO;
import com.kh.spring11.vo.sale.SaleAddRequestVO;
import com.kh.spring11.vo.sale.SaleAddRequestVO2;
import com.kh.spring11.vo.sale.SaleAddResponseVO;
import com.kh.spring11.vo.sale.SaleDetailResponseVO;
import com.kh.spring11.vo.sale.SaleEditRequestVO;

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


	@Transactional
	@Override
	public void delete(int saleNo) {
		
		
		//상품 정보 및 이미지 정보 + 실물파일까지 삭제
		//[1]썸네일과 상세이미지의 파일번호를 찾아야함
		Integer thumbnail = saleDao.findAttachNo(saleNo);
		List<Integer> detailNumbers = saleDao.findAttachNumbers(saleNo);
		//[2]다 지워진 뒤 상품정보를 삭세
		
		saleDao.delete(saleNo);
		
		
		//[3]DB의 파일 정보를 먼저 삭제하고 실물 파일을 삭제하도록 처리+@Transactional
		//->파일번호만 알면 AttachService에서 가능(파일1개에 대해서)
		attachService.delete(thumbnail);//썸네일 삭제
		for(Integer attachNo : detailNumbers) {
			attachService.delete(attachNo);
		}
		
		
		
		
		
		
	}



	@Override
	public void edit(int saleNo, SaleEditRequestVO request, List<MultipartFile> detailImages) throws IllegalStateException, IOException {
		//요청에 saleDiscountPrice가 없는 경우는 saleOriginalPrice와 동일하게 변경
		if(request.getSaleDiscountPrice() == null)
			request.setSaleDiscountPrice(request.getSaleOriginalPrice());
		//기본정보 변경
		SaleDto saleDto = new SaleDto();
		saleDto.setSaleNo(saleNo);
		BeanUtils.copyProperties(request, saleDto);
		saleDao.update(saleDto);
		
		//상세이미지 추가 등록
		boolean exist = detailImages != null && detailImages.size() > 0;
		if(exist) {//파라미터가 있으면
			for(MultipartFile detail : detailImages) {//반복하며
				if(detail.isEmpty() == false) { //비어있지 않은 이미지를 
					int attachNo = attachService.save(detail);
					saleDao.connectDetailImage(saleNo, attachNo);
				}
			}
			
		}
	}


	@Transactional
	@Override
	public ChangeThumbnailResponseVO changeThumbnail(int saleNo, MultipartFile thumbnail) throws IllegalStateException, IOException {
		
		//썸네일 변경을 위한 구체적인 코드
		//[1]기존 썸네일 번호를 조회
		Integer thumbnailNo = saleDao.findAttachNo(saleNo);
		
		//[2]기존 썸네일이 있다면 제거 
		attachService.delete(thumbnailNo);

		//[3]신규썸네일추가
		int newThumbnailNo = attachService.save(thumbnail);
		
		//[4]연결
		saleDao.connect(saleNo, newThumbnailNo);
		
		//[5]수정된 썸네일 정보 조회
		AttachDto attachDto = attachDao.selectOne(newThumbnailNo);
		
		return ChangeThumbnailResponseVO.builder()
					.attach(attachDto)
				.build();
	}



	@Override
	public void deleteThumbnail(int saleNo) {
		//saleNo를 이용해서 썸네일의 attachNo를 구한 뒤 제거 처리 
		
		//[1]기존 썸네일 번호를 조회
		Integer thumbnailNo = saleDao.findAttachNo(saleNo);
		
		//[2]기존 썸네일이 있다면 제거 
		attachService.delete(thumbnailNo);

	}



	@Override
	public void deleteDetailImage(int saleNo, int attachNo) {
		//[1]상세이미지 번호만 조회
		List<Integer> detailNumbers = saleDao.findAttachNumbers(saleNo);
		//[2]실제 지우려는 이미지가 포함되어있지 않은 경우(즉, 다른상품 이미지라면)차단
		if(!detailNumbers.contains(attachNo)) throw new GetOutException();//403 
		//[3]통과했다면 삭제하자
		attachService.delete(attachNo);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
