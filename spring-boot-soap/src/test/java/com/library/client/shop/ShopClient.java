package com.library.client.shop;


import com.library.*;
import com.library.client.Authentication;
import com.library.client.SecurityHeader;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ShopClient extends WebServiceGatewaySupport {

    public OutputSOAShop getShop(Authentication authentication) {
        InputSOAShop request = new InputSOAShop();
        request.setTest("Test");
        return (OutputSOAShop) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSOAShopById getShopById(Authentication authentication, int id) {
        InputSOAShopById request = new InputSOAShopById();
        request.setId(id);
        return (OutputSOAShopById) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSOAddConfirm getShopAdd(Authentication authentication, Shop shop) {
        InputSOAShopAdd request = new InputSOAShopAdd();
        request.setShop(shop);
        return (OutputSOAddConfirm) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSODelConfirm getShopDellllll(Authentication authentication, Shop shop) {
        InputSOAShopDel request = new InputSOAShopDel();
        request.setShop(shop);
        return (OutputSODelConfirm) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSOAShopSearch getSearch(Authentication authentication, int search) {
        InputSOAShopSearch requests = new InputSOAShopSearch();
        requests.setTest(search);
        return (OutputSOAShopSearch) getWebServiceTemplate()
                .marshalSendAndReceive(requests,
                        new SecurityHeader(
                                authentication));
    }
}
