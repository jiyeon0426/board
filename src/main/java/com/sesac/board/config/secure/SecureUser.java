package com.sesac.board.config.secure;

import com.sesac.board.entity.Study_member;
import com.sesac.board.service.StudyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecureUser implements UserDetailsService {

    @Autowired
    StudyMemberService studyMemberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("=== SecureUser >> loadUserByUsername ====== ");

        Study_member vo_member = studyMemberService.doSelectLoginId(username);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+vo_member.getRole()));

        return new User(vo_member.getLoginId(), "{SHA-256}"+vo_member.getPassword(), authorities);
    }
}
