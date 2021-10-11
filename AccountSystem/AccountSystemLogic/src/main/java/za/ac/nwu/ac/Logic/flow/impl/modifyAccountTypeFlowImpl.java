package za.ac.nwu.ac.Logic.flow.impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.Translator.impl.AccountTranslator;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class modifyAccountTypeFlowImpl implements  modifyAccountTypeFlow {

    private final AccountTranslator accountTranslator;

    public modifyAccountTypeFlowImpl(AccountTranslator accountTranslator)
    {
        this.accountTranslator = accountTranslator;
    }


}
