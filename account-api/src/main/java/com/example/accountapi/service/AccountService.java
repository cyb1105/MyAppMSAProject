package com.example.accountapi.service;

import com.example.accountapi.data.AccountEntity;

import java.util.List;

public interface AccountService {
    List<AccountEntity> getAccounts(String userId);
}
