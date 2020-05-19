package com.example.accountapi.controller;

import com.example.accountapi.data.AccountEntity;
import com.example.accountapi.model.AccountResponseModel;
import com.example.accountapi.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users/{id}/accounts")
@Slf4j
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
            })
    public List<AccountResponseModel> userAccounts(@PathVariable String id) {
        List<AccountResponseModel> returnValue = new ArrayList<>();
        List<AccountEntity> accountEntities = accountService.getAccounts(id);

        if (accountEntities == null || accountEntities.isEmpty()) {
            return returnValue;
        }
        Type listType = new TypeToken<List<AccountResponseModel>>() {
        }.getType();

        returnValue = new ModelMapper().map(accountEntities, listType);
        log.info("Returning" + returnValue.size() + "account");
        return returnValue;
    }
}
