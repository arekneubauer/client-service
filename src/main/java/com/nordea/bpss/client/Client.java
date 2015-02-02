package com.nordea.bpss.client;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.datatype.XMLGregorianCalendar;

@Entity
@Table(name = "CRM_CLIENT")
@NamedQueries({
    @NamedQuery(name = "Client.findByClCusNoAndCunitId", query = "SELECT c FROM Client c WHERE c.clCusNo = :clCusNo AND c.clCunitId = :clCunitId"),
    @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.clId = :clId"),})
public class Client implements Serializable {

    private static final long serialVersionUID = -896688419334718092L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "CL_ID")
    private Long clId;

    @Size(max = 20)
    @Column(name = "CL_CUS_NO")
    private String clCusNo;
    
    @Column(name="CL_CUST_ID")
    private Long clCustId;

    @Size(max = 200)
    @Column(name = "CL_SHORT_NAME")
    private String clShortName;

    @Size(max = 2)
    @Column(name = "CL_NATIONALITY")
    private String clNationality;

    @Column(name = "CL_CUNIT_ID")
    private Short clCunitId;

    @Column(name = "CL_MOTIME")
    @Temporal(TIMESTAMP)
    private Date clMotime;

    @Column(name = "CL_PER_MARITAL_STAT")
    private String clPerMaritalStat;

    @Size(max = 20)
    @Column(name = "CL_PLANNED_DEPOSIT")
    private String clPlannedDeposit;

    @Size(max = 20)
    @Column(name = "CL_PLANNED_WITHDRAWAL")
    private String clPlannedWithdrawal;

    @Size(max = 20)
    @Column(name = "CL_PLANNED_TURNOVER")
    private String clPlannedTurnover;

    @Size(max = 60)
    @Column(name = "CL_PER_WORK_PLACE")
    private String clPerWorkPlace;

    @Size(max = 200)
    @Column(name = "CL_PER_PROFESSION")
    private String clPerProfession;

    @Size(max = 20)
    @Column(name = "CL_PER_POLITIC_EXPOSED")
    private String clPerPoliticExposed;

    @Size(max = 70)
    @Column(name = "CL_MODIFIER")
    private String clModifier;

    @Size(max = 6)
    @Column(name = "CL_PER_FUNDS_OWN")
    private String clPerFundsOwn;

    @Column(name = "CL_INCOME_AMT")
    private BigDecimal clIncomeAmt;

    @Size(max = 100)
    @Column(name = "CL_PER_FUNDS_SRC_OTH")
    private String clPerFundsSrcOth;

    @Column(name = "CL_PLANNED_MNTH_INCOME")
    private BigDecimal clPlannedMnthIncome;

    @Column(name = "CL_KYC_UPD_DATE")
    @Temporal(TIMESTAMP)
    private Date clKycUpdDate;

    @Size(max = 20)
    @Column(name = "CL_BEN_OWN_FUNDS")
    private String clBenOwnFunds;

    public Client() {
        super();
    }

    public Long getClId() {
        return clId;
    }

    public void setClId(Long clId) {
        this.clId = clId;
    }

    public String getClCusNo() {
        return clCusNo;
    }

    public void setClCusNo(String clCusNo) {
        this.clCusNo = clCusNo;
    }

    public String getClShortName() {
        return clShortName;
    }

    public void setClShortName(String clShortName) {
        this.clShortName = clShortName;
    }

    public String getClNationality() {
        return clNationality;
    }

    public void setClNationality(String clNationality) {
        this.clNationality = clNationality;
    }

    public Short getClCunitId() {
        return clCunitId;
    }

    public void setClCunitId(Short clCunitId) {
        this.clCunitId = clCunitId;
    }

    public Date getClMotime() {
        return (clMotime != null) ? new Date(clMotime.getTime()) : null;
    }

    public void setClMotime(Date clMotime) {
        this.clMotime = clMotime;
    }
    
    public void setClMotimeGreg(XMLGregorianCalendar motime) {
        this.clMotime = (motime!=null) ? motime.toGregorianCalendar().getTime() : null;
    }

    public String getClPlannedDeposit() {
        return clPlannedDeposit;
    }

    public void setClPlannedDeposit(String clPlannedDeposit) {
        this.clPlannedDeposit = clPlannedDeposit;
    }

    public String getClPlannedWithdrawal() {
        return clPlannedWithdrawal;
    }

    public void setClPlannedWithdrawal(String clPlannedWithdrawal) {
        this.clPlannedWithdrawal = clPlannedWithdrawal;
    }

    public String getClPlannedTurnover() {
        return clPlannedTurnover;
    }

    public void setClPlannedTurnover(String clPlannedTurnover) {
        this.clPlannedTurnover = clPlannedTurnover;
    }

    public String getClPerWorkPlace() {
        return clPerWorkPlace;
    }

    public void setClPerWorkPlace(String clPerWorkPlace) {
        this.clPerWorkPlace = clPerWorkPlace;
    }

    public String getClPerProfession() {
        return clPerProfession;
    }

    public void setClPerProfession(String clPerProfession) {
        this.clPerProfession = clPerProfession;
    }

    public String getClPerPoliticExposed() {
        return clPerPoliticExposed;
    }

    public void setClPerPoliticExposed(String clPerPoliticExposed) {
        this.clPerPoliticExposed = clPerPoliticExposed;
    }

    public String getClModifier() {
        return clModifier;
    }

    public void setClModifier(String clModifier) {
        this.clModifier = clModifier;
    }

    public String getClPerFundsOwn() {
        return clPerFundsOwn;
    }

    public void setClPerFundsOwn(String clPerFundsOwn) {
        this.clPerFundsOwn = clPerFundsOwn;
    }

    public BigDecimal getClIncomeAmt() {
        return clIncomeAmt;
    }

    public void setClIncomeAmt(BigDecimal clIncomeAmt) {
        this.clIncomeAmt = clIncomeAmt;
    }

    public String getClPerFundsSrcOth() {
        return clPerFundsSrcOth;
    }

    public void setClPerFundsSrcOth(String clPerFundsSrcOth) {
        this.clPerFundsSrcOth = clPerFundsSrcOth;
    }

    public BigDecimal getClPlannedMnthIncome() {
        return clPlannedMnthIncome;
    }

    public void setClPlannedMnthIncome(BigDecimal clPlannedMnthIncome) {
        this.clPlannedMnthIncome = clPlannedMnthIncome;
    }

    public Date getClKycUpdDate() {
        return (clKycUpdDate == null) ? 
                null : new Date(clKycUpdDate.getTime());
    }

    public void setClKycUpdDate(Date clKycUpdDate) {
        if (clKycUpdDate != null) {
            this.clKycUpdDate = new Date(clKycUpdDate.getTime());
        }
    }

    public String getClBenOwnFunds() {
        return clBenOwnFunds;
    }

    public void setClBenOwnFunds(String clBenOwnFunds) {
        this.clBenOwnFunds = clBenOwnFunds;
    }

    public String getClPerMaritalStat() {
        return clPerMaritalStat;
    }

    public void setClPerMaritalStat(String clPerMaritalStat) {
        this.clPerMaritalStat = clPerMaritalStat;
    }

    public Long getClCustId() {
        return clCustId;
    }

    public void setClCustId(Long clCustId) {
        this.clCustId = clCustId;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.clId);
        hash = 97 * hash + Objects.hashCode(this.clCusNo);
        hash = 97 * hash + Objects.hashCode(this.clCunitId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return obj==this;
    }

    @Override
    public String toString() {
        return "com.nordea.bpss.client.Client[ clId=" + clId + " ]";
    }
    
}
