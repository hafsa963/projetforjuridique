
package ma.maisonSoftware.maisonSoftaware.controller.rest;

import ma.maisonSoftware.maisonSoftaware.mapper.RoleVo;
import ma.maisonSoftware.maisonSoftaware.mapper.TokenVo;
import ma.maisonSoftware.maisonSoftaware.mapper.UserVo;
import ma.maisonSoftware.maisonSoftaware.jwt.JwtUtils;
import ma.maisonSoftware.maisonSoftaware.service.IUserService;
import ma.maisonSoftware.maisonSoftaware.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
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


    @GetMapping("/getUserName")
    public ResponseEntity<Object> getUsername(@RequestParam String username) {
        UserDetails userDetails = userService.loadUserByUsername(username);

        if (userDetails == null) {
            return ResponseEntity.badRequest().body("Error: User not found!");
        }

        String fullUsername = userDetails.getUsername();
        return ResponseEntity.ok("User is found successfully! Full Username: " + fullUsername);
    }

    @GetMapping("/getCurrentUserResponseEntity")
    public ResponseEntity<Object> getCurrentUserResponseEntity(Authentication authentication) {

        if(authentication == null || authentication instanceof AnonymousAuthenticationToken)
        {
            return ResponseEntity.badRequest().body("user not connected");
        }
        Object principal = authentication.getPrincipal();
        return  ResponseEntity.ok(principal);

    }
    @GetMapping("/getname")
    public ResponseEntity<Object> getname(@RequestParam String username) {
        UserDetails userDetails = userService.loadUserByUsername(username);

        if (userDetails == null) {
            return ResponseEntity.badRequest().body("Error: User not found!");
        }

        String fullUsername = userDetails.getUsername();
        return ResponseEntity.ok("User is found successfully! Full Username: " + fullUsername);
    }
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }



}
