package za.ac.nwu.ac.repo.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountType;



@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Long> {


   @Query(value = "SELECT" +
           "     ACCOUNTTYPEID,"+
           "     ACCOUNTTYPENAME," +
           "     CREATION_DATE,"+
           "     MNEMONIC" +
           "  FROM" +
           "      BATMAN.ACCOUNT_TYPE" +
           " WHERE MNEMONIC = : mnemonic", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);
}
