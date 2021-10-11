package za.ac.nwu.ac.Logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.ac.Translator.impl.AccountTranslator;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {

    private final AccountTranslator accountTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTranslator accountTranslator)
    {
        this.accountTranslator = accountTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountypes() {

        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        accountTypeDtos.add(new AccountTypeDto("MILES","miles", LocalDate.now()));
        return accountTypeDtos;
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic)
    {
        return accountTranslator.getAccountTypeByMnemonicNativeQuery(mnemonic);
    }


}
