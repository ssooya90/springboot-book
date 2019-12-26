package com.ssooya.book.springboot.config.auth.dto;

import com.ssooya.book.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser {
	private String name;
	private String email;
	private String picture;

	public SessionUser(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = user.getPicture();
	}

}
