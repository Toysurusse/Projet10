package com.library.mapper;

import com.library.entity.Rent;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class RentMapper {

    public Rent convertEtoD(com.library.Rentbook rent) {
        Rent rentEntity = new Rent(rent.getBookId(), rent.getUserId(), convertUtilToSql(rent.getCreateat().toGregorianCalendar().getTime()), convertUtilToSql(rent.getEndat().toGregorianCalendar().getTime()), rent.isReload(), rent.isReturnbook());
        rentEntity.setId(rent.getRentid());
        return rentEntity;
    }

    public com.library.Rentbook convertDtoE(Rent rent) {
        com.library.Rentbook rentEntity = new com.library.Rentbook();

        GregorianCalendar endat = new GregorianCalendar();
        endat.setTime(rent.getEnd_at());

        GregorianCalendar createat = new GregorianCalendar();
        createat.setTime(rent.getCreate_at());

        rentEntity.setUserId(rent.getUser_id());
        rentEntity.setBookId(rent.getBook_id());
        rentEntity.setRentid(rent.getId());
        rentEntity.setCreateat(translate(createat));
        rentEntity.setEndat(translate(endat));
        rentEntity.setReload(rent.isReload());
        rentEntity.setReturnbook(rent.isReturnbook());

        return rentEntity;
    }


    public List<com.library.Rentbook> rentListDtoE(List<Rent> rentData) {

        List<com.library.Rentbook> rentsE = new ArrayList<>();

        for (int i = 0; i < rentData.size(); i++) {
            com.library.Rentbook rent = convertDtoE(rentData.get(i));
            rentsE.add(rent);
        }
        return rentsE;
    }

    public List<Rent> rentListEtoD(List<com.library.Rentbook> rentEntity) {

        List<Rent> rentsD = new ArrayList<>();

        for (int i = 0; i < rentEntity.size(); i++) {
            Rent rent = convertEtoD(rentEntity.get(i));
            rentsD.add(rent);
        }
        return rentsD;

    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public XMLGregorianCalendar translate(GregorianCalendar cal) {
        XMLGregorianCalendar xmlDate = null;
        try {
            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
        return xmlDate;
    }
}
