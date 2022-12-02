package com.n10.webbook.controller.customer;

import com.n10.webbook.dto.customer.LoginDto;
import com.n10.webbook.dto.customer.RegisterDto;
import com.n10.webbook.entity.Account;
import com.n10.webbook.entity.Customer;
import com.n10.webbook.entity.Fullname;
import com.n10.webbook.jwt.JwtResponse;
import com.n10.webbook.jwt.JwtService;
import com.n10.webbook.service.customer.AccountService;
import com.n10.webbook.service.customer.CustomerService;
import com.n10.webbook.service.customer.FullNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("api")
public class AccountController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    AccountService accountService;
    @Autowired
    JwtService jwtService;
    @PostMapping(value = "login",consumes = {"multipart/form-data"})
    public ResponseEntity<?> login(@ModelAttribute LoginDto loginDto) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String jwt = jwtService.generateToken(userDetails);
            Account currentUser = accountService.getAccountByUsername(loginDto.getUsername());
            return new ResponseEntity<Object>(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername()), HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception("Authen Fail");
        }
    }


    @Autowired
    CustomerService customerService;
    @Autowired
    FullNameService fullNameService;
    @PostMapping(value = "register",consumes = {"multipart/form-data"})
    public ResponseEntity<?> register(@ModelAttribute RegisterDto registerDto){
        try {
            System.out.println(registerDto);
            Account account=new Account();
            Customer customer=new Customer();
            Fullname fullname=new Fullname();
            account.setUsername(registerDto.getUsername());
            account.setPassword(registerDto.getPassword());
            customer.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(registerDto.getDob()));
            customer.setEmail(registerDto.getEmail());
            customer.setPhone(registerDto.getPhonenumber());
            fullname.setFirstName(registerDto.getFirstName());
            fullname.setMidName(registerDto.getMidName());
            fullname.setLastName(registerDto.getLastName());
            Customer newCusomer= customerService.create(customer);
            account.setCustomer(newCusomer);
            fullname.setCustomer(newCusomer);
            accountService.create(account);
            Fullname fullname1= fullNameService.create(fullname);
            Customer customer1=customerService.findOneById(newCusomer.getId());
            customer1.setFullname(fullname1);
            return ResponseEntity.ok(customer1);
        }
        catch (Exception e){
            System.out.println(e);
            return ResponseEntity.ok("Fail");
        }
    }
}
