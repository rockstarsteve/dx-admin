package com.dx.common.auth;

import com.dx.sys.service.ISysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: com.dx.common.auth
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2020/9/10
 */
@Service
public class AuthUserDetailsServiceImpl implements UserDetailsService {

    private ISysUserService sysUserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetails> users = sysUserService.loadUsersByUsername(username);

        if (users.size() == 0) {

            throw new UsernameNotFoundException(
                    this.messages.getMessage("JdbcDaoImpl.notFound",
                            new Object[] { username }, "Username {0} not found"));
        }

        UserDetails user = users.get(0); // contains no GrantedAuthority[]

        Set<GrantedAuthority> dbAuthsSet = new HashSet<>();

        if (this.enableAuthorities) {
            dbAuthsSet.addAll(loadUserAuthorities(user.getUsername()));
        }

        if (this.enableGroups) {
            dbAuthsSet.addAll(loadGroupAuthorities(user.getUsername()));
        }

        List<GrantedAuthority> dbAuths = new ArrayList<>(dbAuthsSet);

        addCustomAuthorities(user.getUsername(), dbAuths);

        if (dbAuths.size() == 0) {
            this.logger.debug("User '" + username
                    + "' has no authorities and will be treated as 'not found'");

            throw new UsernameNotFoundException(this.messages.getMessage(
                    "JdbcDaoImpl.noAuthority", new Object[] { username },
                    "User {0} has no GrantedAuthority"));
        }

        return createUserDetails(username, user, dbAuths);
    }
}
