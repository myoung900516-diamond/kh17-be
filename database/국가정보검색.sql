--국가를 검색한다면 어떤걸로 어떻게 검색할까?
--[1] 나라이름만 입력해서 검색하는 경우
select * from country where country_name like '브%' order by country_no asc;
select * from country where instr(country_name, '브') >0 order by country_no asc;
--[2] 검색할 항목과 키워드를 입력하여 검색하는 경우 
select * from country where instr(country_name, '브') >0 order by country_no asc;
select * from country where instr(country_region, '브') >0 order by country_no asc;
select * from country where instr(country_capital, '브') >0 order by country_no asc;
