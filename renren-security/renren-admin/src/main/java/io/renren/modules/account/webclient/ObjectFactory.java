
package io.renren.modules.account.webclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.renren.modules.account.webclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetValueResponse_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "getValueResponse");
    private final static QName _UploadPersonBankAccount_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "UploadPersonBankAccount");
    private final static QName _UploadBankAccount_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "UploadBankAccount");
    private final static QName _UploadSettlementResponse_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "UploadSettlementResponse");
    private final static QName _FindPersonBankAccountResponse_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "FindPersonBankAccountResponse");
    private final static QName _FindBankAccountResponse_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "FindBankAccountResponse");
    private final static QName _IsPersonInProject_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "IsPersonInProject");
    private final static QName _UploadSettlement_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "UploadSettlement");
    private final static QName _FindPersonBankAccount_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "FindPersonBankAccount");
    private final static QName _UploadPersonBankAccountResponse_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "UploadPersonBankAccountResponse");
    private final static QName _UploadBankAccountResponse_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "UploadBankAccountResponse");
    private final static QName _UploadSpecialAccount_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "UploadSpecialAccount");
    private final static QName _UploadSpecialAccountResponse_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "UploadSpecialAccountResponse");
    private final static QName _FindBankAccount_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "FindBankAccount");
    private final static QName _IsPersonInProjectResponse_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "IsPersonInProjectResponse");
    private final static QName _GetValue_QNAME = new QName("http://testWebservice.pxCreditrating.com/", "getValue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.renren.modules.account.webclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindBankAccountResponse }
     * 
     */
    public FindBankAccountResponse createFindBankAccountResponse() {
        return new FindBankAccountResponse();
    }

    /**
     * Create an instance of {@link IsPersonInProject }
     * 
     */
    public IsPersonInProject createIsPersonInProject() {
        return new IsPersonInProject();
    }

    /**
     * Create an instance of {@link UploadSettlement }
     * 
     */
    public UploadSettlement createUploadSettlement() {
        return new UploadSettlement();
    }

    /**
     * Create an instance of {@link FindPersonBankAccountResponse }
     * 
     */
    public FindPersonBankAccountResponse createFindPersonBankAccountResponse() {
        return new FindPersonBankAccountResponse();
    }

    /**
     * Create an instance of {@link UploadSettlementResponse }
     * 
     */
    public UploadSettlementResponse createUploadSettlementResponse() {
        return new UploadSettlementResponse();
    }

    /**
     * Create an instance of {@link UploadBankAccount }
     * 
     */
    public UploadBankAccount createUploadBankAccount() {
        return new UploadBankAccount();
    }

    /**
     * Create an instance of {@link UploadPersonBankAccount }
     * 
     */
    public UploadPersonBankAccount createUploadPersonBankAccount() {
        return new UploadPersonBankAccount();
    }

    /**
     * Create an instance of {@link GetValueResponse }
     * 
     */
    public GetValueResponse createGetValueResponse() {
        return new GetValueResponse();
    }

    /**
     * Create an instance of {@link GetValue }
     * 
     */
    public GetValue createGetValue() {
        return new GetValue();
    }

    /**
     * Create an instance of {@link IsPersonInProjectResponse }
     * 
     */
    public IsPersonInProjectResponse createIsPersonInProjectResponse() {
        return new IsPersonInProjectResponse();
    }

    /**
     * Create an instance of {@link UploadBankAccountResponse }
     * 
     */
    public UploadBankAccountResponse createUploadBankAccountResponse() {
        return new UploadBankAccountResponse();
    }

    /**
     * Create an instance of {@link UploadSpecialAccount }
     * 
     */
    public UploadSpecialAccount createUploadSpecialAccount() {
        return new UploadSpecialAccount();
    }

    /**
     * Create an instance of {@link UploadSpecialAccountResponse }
     * 
     */
    public UploadSpecialAccountResponse createUploadSpecialAccountResponse() {
        return new UploadSpecialAccountResponse();
    }

    /**
     * Create an instance of {@link FindBankAccount }
     * 
     */
    public FindBankAccount createFindBankAccount() {
        return new FindBankAccount();
    }

    /**
     * Create an instance of {@link FindPersonBankAccount }
     * 
     */
    public FindPersonBankAccount createFindPersonBankAccount() {
        return new FindPersonBankAccount();
    }

    /**
     * Create an instance of {@link UploadPersonBankAccountResponse }
     * 
     */
    public UploadPersonBankAccountResponse createUploadPersonBankAccountResponse() {
        return new UploadPersonBankAccountResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetValueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "getValueResponse")
    public JAXBElement<GetValueResponse> createGetValueResponse(GetValueResponse value) {
        return new JAXBElement<GetValueResponse>(_GetValueResponse_QNAME, GetValueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadPersonBankAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "UploadPersonBankAccount")
    public JAXBElement<UploadPersonBankAccount> createUploadPersonBankAccount(UploadPersonBankAccount value) {
        return new JAXBElement<UploadPersonBankAccount>(_UploadPersonBankAccount_QNAME, UploadPersonBankAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadBankAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "UploadBankAccount")
    public JAXBElement<UploadBankAccount> createUploadBankAccount(UploadBankAccount value) {
        return new JAXBElement<UploadBankAccount>(_UploadBankAccount_QNAME, UploadBankAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadSettlementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "UploadSettlementResponse")
    public JAXBElement<UploadSettlementResponse> createUploadSettlementResponse(UploadSettlementResponse value) {
        return new JAXBElement<UploadSettlementResponse>(_UploadSettlementResponse_QNAME, UploadSettlementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPersonBankAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "FindPersonBankAccountResponse")
    public JAXBElement<FindPersonBankAccountResponse> createFindPersonBankAccountResponse(FindPersonBankAccountResponse value) {
        return new JAXBElement<FindPersonBankAccountResponse>(_FindPersonBankAccountResponse_QNAME, FindPersonBankAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBankAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "FindBankAccountResponse")
    public JAXBElement<FindBankAccountResponse> createFindBankAccountResponse(FindBankAccountResponse value) {
        return new JAXBElement<FindBankAccountResponse>(_FindBankAccountResponse_QNAME, FindBankAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsPersonInProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "IsPersonInProject")
    public JAXBElement<IsPersonInProject> createIsPersonInProject(IsPersonInProject value) {
        return new JAXBElement<IsPersonInProject>(_IsPersonInProject_QNAME, IsPersonInProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadSettlement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "UploadSettlement")
    public JAXBElement<UploadSettlement> createUploadSettlement(UploadSettlement value) {
        return new JAXBElement<UploadSettlement>(_UploadSettlement_QNAME, UploadSettlement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPersonBankAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "FindPersonBankAccount")
    public JAXBElement<FindPersonBankAccount> createFindPersonBankAccount(FindPersonBankAccount value) {
        return new JAXBElement<FindPersonBankAccount>(_FindPersonBankAccount_QNAME, FindPersonBankAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadPersonBankAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "UploadPersonBankAccountResponse")
    public JAXBElement<UploadPersonBankAccountResponse> createUploadPersonBankAccountResponse(UploadPersonBankAccountResponse value) {
        return new JAXBElement<UploadPersonBankAccountResponse>(_UploadPersonBankAccountResponse_QNAME, UploadPersonBankAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadBankAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "UploadBankAccountResponse")
    public JAXBElement<UploadBankAccountResponse> createUploadBankAccountResponse(UploadBankAccountResponse value) {
        return new JAXBElement<UploadBankAccountResponse>(_UploadBankAccountResponse_QNAME, UploadBankAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadSpecialAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "UploadSpecialAccount")
    public JAXBElement<UploadSpecialAccount> createUploadSpecialAccount(UploadSpecialAccount value) {
        return new JAXBElement<UploadSpecialAccount>(_UploadSpecialAccount_QNAME, UploadSpecialAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadSpecialAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "UploadSpecialAccountResponse")
    public JAXBElement<UploadSpecialAccountResponse> createUploadSpecialAccountResponse(UploadSpecialAccountResponse value) {
        return new JAXBElement<UploadSpecialAccountResponse>(_UploadSpecialAccountResponse_QNAME, UploadSpecialAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBankAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "FindBankAccount")
    public JAXBElement<FindBankAccount> createFindBankAccount(FindBankAccount value) {
        return new JAXBElement<FindBankAccount>(_FindBankAccount_QNAME, FindBankAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsPersonInProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "IsPersonInProjectResponse")
    public JAXBElement<IsPersonInProjectResponse> createIsPersonInProjectResponse(IsPersonInProjectResponse value) {
        return new JAXBElement<IsPersonInProjectResponse>(_IsPersonInProjectResponse_QNAME, IsPersonInProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testWebservice.pxCreditrating.com/", name = "getValue")
    public JAXBElement<GetValue> createGetValue(GetValue value) {
        return new JAXBElement<GetValue>(_GetValue_QNAME, GetValue.class, null, value);
    }

}
