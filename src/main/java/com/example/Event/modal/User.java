package com.example.Event.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity  @Getter
@Setter @AllArgsConstructor @NoArgsConstructor

public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId ;
    private String username ;
    @Column(unique = true)
    private String email ;
    private String password ;
    @Enumerated (EnumType.STRING)
    private com.example.Event.enums.role role ;

    @OneToMany(mappedBy = "User")
    private List<Ticket> tickets ;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
