package util;

import com.kim.project.common.dto.PageDto;

//import dto.PageDto;

public class PageHelper {
	
	
	
	
	public static PageDto getBlockGroup(int curPage, int pagePerRecord, int totalRecord)
	{
		/*
		 * pagePerRecord - 한 페이지에 표시되는 레코드(게시물) 수
		 * 
		 * 페이지당 블록그룹(PagePerBlock)이 5이면 한개의 BlockGroup에 블록들이 5개 존재한다.
		 * curBlockGroup 이 1이면  1~5 블록들이 보이고 
		 * curBlockGroup 이 3이면 10~15 블록들이 보인다.
		 */
		PageDto pDto =new PageDto();
		
		if(totalRecord==0)
		{
			pDto.setIsEmpty(0);		
			pDto.setFirstBlock(1);
			pDto.setLastBlock(1);
			pDto.setNextPage(0);
			pDto.setPrevPage(0);
			return pDto;
		}
		else{
			pDto.setIsEmpty(1);		
		}
		
		int pagePerBlock = 5;//블록 그룹 - 블록을 5개로 묶는다.
		int lastBlockGroup=0;
		int curBlockGroup= 1 ; //현재 위치한 블록 그룹

		int totalPage =0; // 총 페이지 수(총 블록 수)
		int firstBlock; // 현재 블록 그룹의 첫번째 블록번호
		int lastBlock=0; // 현재 블록 그롭의 마지막 블록 번호
		int prevPage=0; // 이전 버튼을 눌렀을때 이동되는 페이지 정보
		//(firstPage -1 )
		int nextPage=0; // 다음 버튼을 눌렀을 때 이동되는 페이지 정보가 저장
		//(lastPage+1)
		
		
		
		//한페이지에 몇명의 사원이 보여질지 정한다. 한페이지에 보여지는 사원의 수가 10명이고 총 사원이 100명이 있다면 10개의 페이지가 만들어진다. 페이지 수 == 블록 수 
		if (totalRecord != 0) {
			if (totalRecord % pagePerRecord == 0) 
			{
				totalPage = totalRecord / pagePerRecord ;
			} 
			else 
			{
				totalPage = totalRecord / pagePerRecord + 1;
			}
		}
		else{
			return null;
		}
		
		lastBlockGroup=(int)Math.ceil((double)totalPage/pagePerBlock);

		//현재 페이지가 어느 블록에 위치해 있는지 계산한다.
		if (curPage % pagePerBlock == 0) {
			curBlockGroup = curPage / pagePerBlock;
		} else {
			curBlockGroup = curPage / pagePerBlock + 1;
		}
		// 블록 그룹 에 속한 첫번째 페이지 계산
		firstBlock = (curBlockGroup- 1) * pagePerBlock + 1;
		// 블록그룹 에 속한 마지막 페이지 계산
		lastBlock =  curBlockGroup* pagePerBlock;

		/*블록그룹이 1보다 으면 이전 버튼이 보이고, 이전버튼을 누르면 firstBlock - 1 로 이동한다.
		 * 블록 그룹이 1이라는 것은 1~5 블록들이 보인다는건데 이때는 이전버튼이 필요없다.
		*/
		if(curBlockGroup > 1) {
			prevPage = firstBlock - 1;
		}
		else {
			prevPage=0;
		}
		if(curBlockGroup< lastBlockGroup) {
			nextPage = lastBlock + 1;
		}
		else{
			lastBlock=totalPage;
			nextPage=0;
		}
		pDto.setFirstBlock(firstBlock);
		pDto.setLastBlock(lastBlock);
		pDto.setNextPage(nextPage);
		pDto.setPrevPage(prevPage);
		
		return pDto;
	}
	
}	
	

/*firstBlock
lastBlock

prevPage
nextPage*/
	
	


