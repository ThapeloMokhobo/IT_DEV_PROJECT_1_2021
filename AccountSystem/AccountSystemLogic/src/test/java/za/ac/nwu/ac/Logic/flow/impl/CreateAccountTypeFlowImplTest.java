package za.ac.nwu.ac.Logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.Translator.impl.AccountTranslator;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeFlowImplTest {

    @Mock
    private AccountTranslator Translator;

    @InjectMocks
    private CreateAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {

        Mockito.when(Translator.create(Mockito.any(AccountTypeDto.class))).thenReturn(null);
        AccountTypeDto result = flow.create(new AccountTypeDto());
        assertNull(result);
        Mockito.verify(Translator,Mockito.times(1)).create(Mockito.any(AccountTypeDto.class));
    }
}