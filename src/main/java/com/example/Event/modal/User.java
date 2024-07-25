package com.example.Event.modal;

import com.example.Event.enums.role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity  @Getter
@Setter  @NoArgsConstructor @AllArgsConstructor
@Builder

public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId ;
    private String name ;
    @Column(unique = true )
    private String username ;
    private String password ;
    @Enumerated (EnumType.STRING)
    private com.example.Event.enums.role role ;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Ticket> tickets ;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(role == null) {
            System.out.println("le role n'existe pas");
            return List.of();
        }
        System.out.println("//////////wasal"+role.name());
        return List.of(new SimpleGrantedAuthority("ROLE_"+role.name()));
    }



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }


}
