package com.ssooya.book.springboot.web.dto;

import com.ssooya.book.springboot.domain.posts.Posts;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

	@Test
	public void 롬북_기능_테스트(){

		//given
		String name = "test";
		int amount = 1000;

		//when
		HelloResponseDto dto = new HelloResponseDto(name,amount);

		//then
		assertThat(dto.getName())
				.as("test")
				.isEqualTo(name);
		assertThat(dto.getAmount())
				.isEqualTo(amount);
	}


}