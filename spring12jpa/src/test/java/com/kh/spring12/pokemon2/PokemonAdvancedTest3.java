package com.kh.spring12.pokemon2;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.Pokemon;
import com.kh.spring12.repo.PokemonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PokemonAdvancedTest3 {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Test
	public void test() {
//		목표 : 몬스터명 자동완성 검색
//		List<Pokemon> list = pokemonRepository.findByPokemonNameStartingWith("리");
		List<Pokemon> list = pokemonRepository.findByPokemonNameStartingWithOrderByPokemonNameAscPokemonNoAsc("리");
		System.out.println("검색결과 : " + list.size());
		for(Pokemon p : list){
			System.out.println("->" + p);
		}
		
	}
	

}
