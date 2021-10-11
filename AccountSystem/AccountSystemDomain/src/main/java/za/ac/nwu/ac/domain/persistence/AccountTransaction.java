package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Account_Trans", schema = "BATMAN")
public class AccountTransaction implements Serializable
{
    private static final long serialVersionUID =  -1420294317019175746L;

    private Long transactionID;
    private Long accountTypeID;
    private Long membershipID;
    private Long amount;
    private LocalDate transDate;

    public AccountTransaction()
    {

    }

    public AccountTransaction(long transactionID,long accountTypeID,long membershipID, long amount,LocalDate transDate) {
        this.transactionID = transactionID;
        this.accountTypeID = accountTypeID;
        this.membershipID = membershipID;
        this.amount = amount;
        this.transDate = transDate;

    }

    @Id
    @SequenceGenerator(name = "AccountSystem_Seq", sequenceName = "AccountSystem.AccountSystem_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountSystem_SEQ")
    @Column(name = "transactionID")
    public Long getTransactionID()
    {
        return transactionID;
    }

    @Column(name ="accountTypeID")
    public Long getAccountTypeID()
    {
        return accountTypeID;
    }

    @Column(name = "membershipID")
    public Long getMembershipID()
    {
        return membershipID;
    }
    @Column(name ="amount")
    public Long getAmount()
    {
        return amount;
    }
    @Column(name = "transDate")
    public LocalDate getTransDate()
    {
        return transDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountTypeID")
    public long getAccountId() {return accountTypeID;}

    public void setTransactionID(long transactionID)
    {
        this.transactionID = transactionID ;
    }
    public void setMembershipID(long membershipID)
    {
        this.membershipID = membershipID;
    }
    public void setAccountTypeID(long accountTypeID)
    {
        this.accountTypeID = accountTypeID;
    }
    public void setAmount(long amount)
    {
        this.amount =amount;
    }

    public void setTransDate(LocalDate transDate)
    {
        this.transDate = transDate;
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
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionID,that.transactionID) && Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(membershipID, that.membershipID )&& Objects.equals(amount, that.amount)&& Objects.equals(transDate, that.transDate);
    }

    @Override
    public String toString()
    {
        return "AccountTransaction{" +
                "accountTypeID ='"+ accountTypeID + '\''+
                "transactionID='" + transactionID + '\'' +
                ",membershipID='"+ membershipID + '\'' +
                ", amount=" + amount +'\''+
                ",transDate=+" + transDate +
                '}';
    }





    }
