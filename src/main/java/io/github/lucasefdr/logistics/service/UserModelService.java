package io.github.lucasefdr.logistics.service;

import io.github.lucasefdr.logistics.repository.UserModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserModelService implements UserDetailsService {
    private final UserModelRepository userModelRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(userModelRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
