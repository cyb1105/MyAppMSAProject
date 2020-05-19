package com.example.myappapiusers.client;

import com.example.myappapiusers.model.AccountResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "account-ws",fallback = AccountsFallback.class)
public interface AccountServiceClient {
    @GetMapping("/users/{id}/accounts")
    List<AccountResponseModel> getAccounts(@PathVariable String id);
}
@Component
class AccountsFallback implements AccountServiceClient{


    @Override
    public List<AccountResponseModel> getAccounts(String id) {
        return new ArrayList<>();
    }
}

