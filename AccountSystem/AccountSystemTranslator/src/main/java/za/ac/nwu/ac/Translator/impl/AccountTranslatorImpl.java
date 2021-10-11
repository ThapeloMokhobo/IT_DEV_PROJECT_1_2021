package za.ac.nwu.ac.Translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTranslatorImpl implements AccountTranslator {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTranslatorImpl(AccountTypeRepository accountTypeRepository)
    {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccounts()
    {
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try
        {
            for (AccountType accountType : accountTypeRepository.findAll())
            {
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        } catch (Exception e)
        {
            throw new RuntimeException("unable to read from db", e);
        }

        return accountTypeDtos;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto) {
        try
        {
            AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read from database", e);
        }
    }

    @Override
    public AccountTypeDto  getAccountTypeByMnemonicNativeQuery(String mnemonic)
    {
        try {
              AccountType accountType = accountTypeRepository.getAccountTypeByMnemonicNativeQuery(mnemonic);
              return new AccountTypeDto(accountType);

           }catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the DB", e);
        }

    }


}
