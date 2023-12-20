package technical.bankMega.service;

import technical.bankMega.controller.dto.AuthenticationRequest;
import technical.bankMega.controller.dto.AuthenticationResponse;
import technical.bankMega.controller.dto.RegisterRequest;
import technical.bankMega.repo.UserRepository;
import technical.bankMega.user.User;
import technical.bankMega.utils.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public record AuthenticationService(UserRepository userRepository,
                                    PasswordEncoder passwordEncoder,
                                    AuthenticationManager authenticationManager) {
    public AuthenticationResponse register(RegisterRequest request) {
        final var user = new User(null,
                request.username(),
                passwordEncoder.encode(request.password()));
        userRepository.save(user);
        final var token = JwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        final var user = userRepository.findByUsername(request.username()).orElseThrow();
        final var token = JwtService.generateToken(user);
        return new AuthenticationResponse(token);

    }
}
