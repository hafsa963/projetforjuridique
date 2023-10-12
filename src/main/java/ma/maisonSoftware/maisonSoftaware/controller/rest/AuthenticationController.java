
package ma.maisonSoftware.maisonSoftaware.controller.rest;

import ma.maisonSoftware.maisonSoftaware.mapper.RoleVo;
import ma.maisonSoftware.maisonSoftaware.mapper.TokenVo;
import ma.maisonSoftware.maisonSoftaware.mapper.UserVo;
import ma.maisonSoftware.maisonSoftaware.jwt.JwtUtils;
import ma.maisonSoftware.maisonSoftaware.service.IUserService;
import ma.maisonSoftware.maisonSoftaware.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/signin")

    public ResponseEntity<TokenVo> authenticateUser(@Valid @RequestBody UserVo userVo) {

        try {

            UserVo userVo1 =  userService.findByUsername(userVo.getUsername());
            if (!userVo1.isEnabled()) {
                throw new Exception("user not enable");
            }

            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(userVo.getUsername(), userVo.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            TokenVo tokenVo = new TokenVo();
            tokenVo.setJwttoken(jwt);
            tokenVo.setUsername(userVo.getUsername());

            tokenVo.setRole(authentication.getAuthorities().stream().collect(Collectors.toList()).get(0).toString());

            return ResponseEntity.ok(tokenVo);
        } catch (Exception e) {
            throw new BusinessException("Login ou mot de passe incorrect");
        }

   }
      @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserVo userVo) {
        if (userService.existsByUsername(userVo.getUsername())) {
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }
        userVo.getRoles().add(new RoleVo("ADMIN"));
        userService.save(userVo);
        return ResponseEntity.ok("User registered successfully!");
    }
}

