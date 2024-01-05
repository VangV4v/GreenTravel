/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.configuation;

import com.cusc.dto.GooglePOJO;
import com.cusc.entities.Customers;
import com.cusc.repositories.CustomersRepository;
import com.cusc.repositories.RolesRepository;
import com.cusc.repositories.hql.CustomersHQL;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author kyqua
 */
@Component
public class GoogleUtils {

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private CustomersHQL customersHQL;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public static String GOOGLE_CLIENT_ID = "735839220312-o98d6tlhgsiktiv61i14pn4rq525k53o.apps.googleusercontent.com";
    public static String GOOGLE_CLIENT_SECRET = "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";
    public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/GreenTravel/login-google";
    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static String GOOGLE_GRANT_TYPE = "authorization_code";

    public String getToken(final String code) throws ClientProtocolException, IOException {
        String response = Request.Post(GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", GOOGLE_CLIENT_ID)
                        .add("client_secret", GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response).get("access_token");
        return node.textValue();
    }

    public GooglePOJO getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        ObjectMapper mapper = new ObjectMapper();
        GooglePOJO googlePojo = mapper.readValue(response, GooglePOJO.class);
        System.out.println("---..>" + googlePojo);

        return googlePojo;
    }

    public UserDetails buildUser(GooglePOJO googlePojo) {
        long checkUsername = customersHQL.getCountByUsername(googlePojo.getId());
        if (checkUsername == 0) {
            Customers customers = new Customers();
            LocalDate localDate = LocalDate.now();
            Date dateOfBirth = Date.valueOf(localDate);
            String name = googlePojo.getEmail().substring(0, googlePojo.getEmail().indexOf("@"));
            customers.setUsername(googlePojo.getId());
            customers.setPassword(passwordEncoder.encode(googlePojo.getId()));
            customers.setFirstname(name);
            customers.setLastname(name);
            customers.setAvatar(googlePojo.getPicture());
            customers.setAddress("None");
            customers.setEmail(googlePojo.getEmail());
            customers.setRoleID(rolesRepository.findById(3).get());
            customers.setPhone("0000000000");
            customers.setDateOfBirth(dateOfBirth);
            customers.setStatus(true);
            customersRepository.save(customers);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
        UserDetails userDetail = new User(googlePojo.getId(),
                "", enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        return userDetail;
    }
}
