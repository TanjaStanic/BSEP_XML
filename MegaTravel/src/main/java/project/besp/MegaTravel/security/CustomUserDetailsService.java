package project.besp.MegaTravel.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import project.besp.MegaTravel.model.Privilege;
import project.besp.MegaTravel.model.Role;
import project.besp.MegaTravel.model.User;
import project.besp.MegaTravel.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userRepository.findOneByEmail(arg0);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with email '%s'.", arg0));
		} else {
			return user;
		}
		
	}
	
	
	private Collection<? extends GrantedAuthority> getAuthorities(Role role){
		return getGrantedAuthorities(getPrivileges(role));
	}
	
	
	private Collection<Privilege> getPrivileges(Role role) {
        return role.getPrivileges();
    }
	
	private List<GrantedAuthority> getGrantedAuthorities(Collection<Privilege> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Privilege p : privileges) {
            authorities.add(new SimpleGrantedAuthority(p.getName()));
        }
        return authorities;
    }

	

}
