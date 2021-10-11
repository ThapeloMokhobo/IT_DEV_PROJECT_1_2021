package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Account_Type", schema = "BATMAN")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 3833725316797154577L;

    private Long accountTypeID;
    private String mnemonic;
    private String AccountTypeName;
    private LocalDate creation_Date;

    private Set<AccountTransaction> AccountTransaction;

public AccountType()
{

}

public AccountType(long accountTypeID, String mnemonic, String AccountTypeName, LocalDate creation_Date)
{
    this.accountTypeID = accountTypeID;
    this.mnemonic = mnemonic;
    this.AccountTypeName = AccountTypeName;
    this.creation_Date = creation_Date;
}

public AccountType(String mnemonic, String accountTypeName, LocalDate creation_Date)
{
    this.mnemonic = mnemonic;
    this.AccountTypeName = accountTypeName;

}
@Id
@SequenceGenerator(name = "AccountSystem_Seq", sequenceName = "AccountSystem.AccountSystem_SEQ",allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountSystem_SEQ")
@Column(name = "Account_Type_ID")
public long getAccountId() {return accountTypeID;}

@Column(name = "AccountTypeName")
public String getAccountTypeName(){return AccountTypeName;}

    @Column(name = "mnemonic")
public String getMnemonic(){return mnemonic;};

@Column(name = "creation_Date")
public LocalDate getCreation_Date(){return  creation_Date;}

@OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY,mappedBy = "accountTypeID", orphanRemoval = true,cascade = CascadeType.PERSIST)
public Set<AccountTransaction>getAccountTransaction()
{
   return AccountTransaction;
}

public void setAccountTypeID(long accountTypeID)
{
    this.accountTypeID =accountTypeID;
}

public void setMnemonic(String mnemonic)
{
    this.mnemonic = mnemonic;
}

public void setAccountTypeName(String accountTypeName)
{
    this.AccountTypeName = accountTypeName;
}

public void setCreation_Date(LocalDate creation_Date)
{
    this.creation_Date = creation_Date;
}


@Override
public boolean equals(Object o)
{
    if (this == o)
    {
        return true;
    }
    if (o == null || getClass() != o.getClass())
    {
        return false;

    }
    AccountType that = (AccountType) o;
    return Objects.equals(mnemonic,that.mnemonic) && Objects.equals(AccountTypeName, that.AccountTypeName) && Objects.equals(creation_Date, that.creation_Date);
}

@Override
public int hashCode()
{
    return Objects.hash(accountTypeID,mnemonic,AccountTypeName,creation_Date);
}

@Override
public String toString()
{
    return "AccountType{" +
            "accountTypeID ='"+ accountTypeID + '\''+
            "mnemonic='" + mnemonic + '\'' +
            ",AccountTypeName='"+ AccountTypeName + '\'' +
            ", creation_Date=" + creation_Date +
            '}';
}




}

