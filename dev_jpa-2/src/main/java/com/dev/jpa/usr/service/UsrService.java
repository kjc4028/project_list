package com.dev.jpa.usr.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.management.relation.Role;
import javax.transaction.Transactional;

import org.hibernate.dialect.unique.MySQLUniqueDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dev.jpa.usr.entity.RoleEntity;
import com.dev.jpa.usr.entity.UsrEntity;
import com.dev.jpa.usr.repository.UsrRepository;


@Service
@Transactional
public class UsrService implements UserDetailsService  {
	
	Logger log = LoggerFactory.getLogger(UsrService.class);
	
	@Autowired
	UsrRepository usrRepository;
	
	
	public UsrEntity findByUsrNm(String name){
		return usrRepository.findByUsrNm(name);
	}
	
	public List<UsrEntity> findAll(){
		return usrRepository.findAll();
	}
	
	public void save(UsrEntity usr){
		//String ecryptPw =bCryptPasswordEncoder.encode(usr.getUsrPw());
		 BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		 usr.setUsrPw(bCryptPasswordEncoder.encode(usr.getUsrPw()));
		log.info(usr.getUsrPw() + " + " + bCryptPasswordEncoder.encode(usr.getUsrPw()));
		usrRepository.save(usr);
	}

	/**
	 * 사용자 인증
	 */
	@Override
	public UserDetails loadUserByUsername(String usrId) throws UsernameNotFoundException {
		
		//TODO 회원가입시 디폴트 권한 부여 
		
		log.info("--------loadUserName---");
        Optional<UsrEntity> userEntityWrapper = usrRepository.findByUsrId(usrId);
        UsrEntity userEntity = userEntityWrapper.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<RoleEntity> roleEntity = userEntity.getRole();
        String authRoleNm = roleEntity.iterator().next().getRoleNm();
        
        if(!userEntity.getRole().isEmpty()) {
        	authorities.add(new SimpleGrantedAuthority(authRoleNm));
        } else {
        	authorities.add(new SimpleGrantedAuthority("USER"));
        }

        return new User(userEntity.getUsrId(), userEntity.getUsrPw(), authorities);
    }
}
