package com.example.accountapi.service;

import com.example.accountapi.data.AccountEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImp implements AccountService {

    @Override
    public List<AccountEntity> getAccounts(String userId) {
        List<AccountEntity> returnValue = new ArrayList<>();

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUserId(userId);
        accountEntity.setName("account1");
        accountEntity.setId(1L);

        AccountEntity accountEntity2 = new AccountEntity();
        accountEntity2.setUserId(userId);
        accountEntity2.setName("account1");
        accountEntity2.setId(1L);


        returnValue.add(accountEntity);
        returnValue.add(accountEntity2);

        return returnValue;
    }
}

