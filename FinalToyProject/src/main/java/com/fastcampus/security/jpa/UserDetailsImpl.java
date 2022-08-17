package com.fastcampus.security.jpa;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fastcampus.biz.domain.Blog;
import com.fastcampus.biz.domain.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails{
	private static final long serialVersionUID = 1L;

	
	private User user;
	
	public UserDetailsImpl(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> roleList = new ArrayList<>();
		
		roleList.add(new GrantedAuthority() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {				
				
				return "ROLE_" + user.getRole();
			}
		});
	
		return roleList;
	}

	@Override
	public String getPassword() {
		return "{noop}" + user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	public Long getBlogId() {
		return user.getBlog().getBlogId();
	}
	
	public Blog getBlog() {
		return user.getBlog();
	}
	
	public String getRole() {
		return user.getRole();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}



}
