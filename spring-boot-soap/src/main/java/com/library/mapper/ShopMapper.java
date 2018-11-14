package com.library.mapper;

import com.library.Shop;
import com.library.entity.Shoppinglist;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.*;

@Service
public class ShopMapper {

    public Shoppinglist convertEtoD (com.library.Shop shop) {
        System.out.println(shop.getCreateat());
        Shoppinglist shopEntity = new Shoppinglist(shop.getIdusershop(), shop.getIdbookshop(), new Timestamp(shop.getCreateat().toGregorianCalendar().getTimeInMillis()), new Timestamp(shop.getEndat().toGregorianCalendar().getTimeInMillis()),shop.isDispo(), shop.getIdpannier());
        System.out.println(shopEntity.getCreate_at());
        shopEntity.setId(shop.getId());
        return shopEntity;
    }

    public com.library.Shop convertDtoE (Shoppinglist shop) {
        com.library.Shop shopEntity = new com.library.Shop();

        shopEntity.setId(shop.getId());
        shopEntity.setIdusershop(shop.getIdusershop());
        shopEntity.setIdbookshop(shop.getIdbookshop());
        shopEntity.setIdpannier(shop.getIdpannier());
        shopEntity.setDispo(shop.isDispo());

        GregorianCalendar calCreateAt = new GregorianCalendar();
        calCreateAt.setTimeInMillis(java.sql.Timestamp.valueOf(shop.getCreate_at().toString()).getTime());
        shopEntity.setCreateat(translate(calCreateAt));

        GregorianCalendar calEndAt = new GregorianCalendar();
        calEndAt.setTimeInMillis(java.sql.Timestamp.valueOf(shop.getCreate_at().toString()).getTime());
        shopEntity.setEndat(translate(calEndAt));

        return shopEntity;
    }

    public List<com.library.Shop> shopListDtoE(List<Shoppinglist> shopData) {

        List<com.library.Shop> shopsE = new ArrayList<>();

        for (int i = 0; i < shopData.size(); i++) {
            com.library.Shop shop =convertDtoE(shopData.get(i));
            shopsE.add(shop);
        }
        return shopsE;
    }

    public List<Shoppinglist> shopListEtoD(List<com.library.Shop> shopEntity) {

        List<Shoppinglist> shopsD = new ArrayList<>();

        for (int i = 0; i < shopEntity.size(); i++) {
            Shoppinglist shop = convertEtoD(shopEntity.get(i));
            shopsD.add(shop);
        }
        return shopsD;
    }

    public XMLGregorianCalendar translate(GregorianCalendar cal) {
        XMLGregorianCalendar xmlDate = null;
        try {
            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException("xmlCalendar config");
        }
        return xmlDate;
    }
}
