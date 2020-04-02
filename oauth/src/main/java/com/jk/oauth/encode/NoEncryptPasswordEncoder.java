package com.jk.oauth.encode;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author jk
 * @Date: 2019/12/24
 */
public class NoEncryptPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return (String) charSequence;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals((String) charSequence);
    }
}
