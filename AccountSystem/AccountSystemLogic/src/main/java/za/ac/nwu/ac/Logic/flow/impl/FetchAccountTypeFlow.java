package za.ac.nwu.ac.Logic.flow.impl;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.util.List;

public interface FetchAccountTypeFlow
{

    List<AccountTypeDto> getAllAccountypes();


    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
}
