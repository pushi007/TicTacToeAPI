package com.moya.api.security;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("moyaAuthenticationProvider")
public class MoyaAuthenticationService extends AbstractUserDetailsAuthenticationProvider implements UserDetailsService{
	/*@Autowired
	private UserService userService;
*/
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		List<GrantedAuthority> authorityList = new LinkedList<GrantedAuthority>();
		for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
			authorityList.add(grantedAuthority);
		}
		//User user = userService.findByUsername(username);
		
		return new org.springframework.security.core.userdetails.User("", "", true,
				true, true, true, authorityList);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}