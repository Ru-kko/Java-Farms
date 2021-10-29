package com.fincas.app.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class user {
    @GetMapping("/user")
    public Map<String, Object> ser(@AuthenticationPrincipal OAuth2User principal) {
        Map<String, Object> response = new HashMap<String, Object>();

        response.put("name", principal.getAttribute("name"));
        response.put("avatar_url", principal.getAttribute("avatar_url"));

        return response;
    }
}
