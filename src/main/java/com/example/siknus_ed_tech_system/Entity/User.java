package com.example.siknus_ed_tech_system.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Collection;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_user_email", columnNames = "email")
})

public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "jps_user_seq_gen", sequenceName = "jps_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "jps_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "birthday")
    private String birthday;

    @Column()
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "password")
    private String password;




//    @OneToMany(targetEntity =Application.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "Applied_jobs_FK", referencedColumnName = "id")
//    private List<Application> applications;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
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