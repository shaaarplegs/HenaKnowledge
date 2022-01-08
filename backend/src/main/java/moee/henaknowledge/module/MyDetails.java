package moee.henaknowledge.module;


import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class MyDetails implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public MyDetails(Student user) {
        username = user.getUsername();
        password = user.getPassword();
        authorities = Arrays.stream(("ROLE_"+user.getRole()).split(",")).map(
                SimpleGrantedAuthority::new
        ).collect(Collectors.toList());
    }

    public MyDetails(Teacher user) {
        username = user.getUsername();
        password = user.getPassword();
        authorities = Arrays.stream(("ROLE_"+user.getRole()).split(",")).map(
                SimpleGrantedAuthority::new
        ).collect(Collectors.toList());
    }

    public MyDetails(Admin user) {
        username = user.getUsername();
        password = user.getPassword();
        authorities = Arrays.stream(("ROLE_"+user.getRole()).split(",")).map(
                SimpleGrantedAuthority::new
        ).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
