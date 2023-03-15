package org.example;

import com.appriss.methcheck.services.*;

import java.util.List;

public class Main {
  public static void main(String[] args) {

    PersonInfoType personInfoType = new PersonInfoType();
    personInfoType.setId("C5759085");
    personInfoType.setIdType("DL_ID");
    personInfoType.setIdIssuingAgency("CA");
    personInfoType.setIdExpiration("08/12/2024");
    personInfoType.setLastName("GUNNING");
    personInfoType.setMiddleName("JOSEPH");
    personInfoType.setFirstName("KEVIN");
    personInfoType.setBirthDate("08/12/1962");
    personInfoType.setAddressLine1("3323 ALEGRE LN");
    personInfoType.setCity("ALTADENA");
    personInfoType.setState("CA");
    personInfoType.setPostalCode("91001");

    PersonIdentifierType personIdentifierType = new PersonIdentifierType();
    personIdentifierType.setIdScan("QAoeDUFOU0kgNjM2MDE0MDkwMTAyREwwMDQxMDI4MlpDMDMyMzAwMjRETERBUUM1NzU5MDg1CkRDU0dVTk5JTkcKRERFTgpEQUNLRVZJTgpEREZOCkRBREpPU0VQSApEREdOCkRDQUNNMQpEQ0JOT05FCkRDRE5PTkUKREJEMTIwMzIwMTkKREJCMDgxMjE5NjIKREJBMDgxMjIwMjQKREJDMQpEQVUwNzIgSU4KREFZQlJPCkRBRzMzMjMgQUxFR1JFIExOCkRBSUFMVEFERU5BCkRBSkNBCkRBSzkxMDAxMDAwMCAgCkRDRjEyLzAzLzIwMTk2MThDNi9BQUZELzI0CkRDR1VTQQpEQVcyMDUKREFaR1JZCkRDSzE5MzM3QzU3NTkwODUwNDAxCkREQUYKRERCMDgyOTIwMTcKRERLMQ1aQ1pDQUJSTgpaQ0JHUlkKWkNDClpDRA0=");
    personIdentifierType.setPersonInfo(personInfoType);

    StoreType storeType = new StoreType();
    storeType.setStoreId("2162");
    storeType.setSiteId("83027");
    storeType.setStoreTech("9778176");

    ProductType productType = new ProductType();
    productType.setUpc("345802432629");
    productType.setName("PSEUDOEPHEDRINE H ");
    productType.setGrams((float) 0.72);
    productType.setPills(24);
    productType.setPediatricInd(true);
    productType.setBoxCount(1);

    InquiryRequestType inquiryRequest = new InquiryRequestType();
    InquiryRequestType.Products products = new InquiryRequestType.Products();
    List<ProductType> product = products.getProduct();
    product.add(productType);

    inquiryRequest.setProducts(products);
    inquiryRequest.setStore(storeType);
    inquiryRequest.setPersonIdentifier(personIdentifierType);

    DoInquiry doInquiry = new DoInquiry();
    doInquiry.setInquiryRequest(inquiryRequest);

    RetailServicesWS_Service retailServicesWSService = new RetailServicesWS_Service();
    InquiryResponseType inquiryResponseType = retailServicesWSService
            .getRetailServicesWSPort()
            .doInquiry(inquiryRequest);

    System.out.println("inquiryResponseType = " + inquiryResponseType);
  }
}
