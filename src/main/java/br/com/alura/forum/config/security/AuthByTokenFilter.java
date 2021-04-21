package br.com.alura.forum.config.security;

import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;
import br.com.alura.forum.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthByTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UsuarioRepository usuarioRepository;

    public AuthByTokenFilter(TokenService tokenService,UsuarioRepository usuarioRepository) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarToken(httpServletRequest);

        boolean isValid = tokenService.isTokenValido(token);

       if(isValid){
           autenticarToken(token);
       }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private void autenticarToken(String token) {
        Long idUsuario = tokenService.getIdUsuario(token);
        Usuario usuarioAutenticado = usuarioRepository.findById(idUsuario).get();
        Authentication authentication = new UsernamePasswordAuthenticationToken(usuarioAutenticado,null,usuarioAutenticado.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recuperarToken(HttpServletRequest httpServletRequest) {

       String token = httpServletRequest.getHeader("Authorization");
       if(token==null || token.isEmpty() || token.substring(0,5).equalsIgnoreCase("bearer")){
           return null;
       }
        return token.substring(7,token.length());
    }
}
