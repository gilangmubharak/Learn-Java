@Getter
@Getter
@Builder
@EqualsAndHashcode
@NoArgsConstructor
@AllArgsConstructor
@Entity(name ="Gilang")
public class User implements userDetails {
    @Id
    @generateValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String username;

    private String email:

    private String password;

    @Builder.Default
    private UserRole = UserRole.USER;

    @Builder.Default
    private Boolean enabled = false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        final SimpleGrantedAuthority simpleGrantedAuthority = new simpleGrantedAuthority(userrole.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername(){
        return email;
    }

    @Override
    public boolean isAccountNonLocked(){
        return !Locked;
    }

    @Override
    public boolean isCredentialsNonexpired(){
        return true;
    }

    @Override
    public boolean isEnable(){
        return enabled;
    }

}