package com.library.mapper;

import com.library.Rentbook;
import com.library.SpringBootLibraryApplication;
import com.library.entity.Rent;
import org.apache.log4j.LogManager;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class RentMapper {

    private static final org.apache.log4j.Logger logger = LogManager.getLogger(SpringBootLibraryApplication.class);

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

        for (Rent aRentData : rentData) {
            Rentbook rent = convertDtoE(aRentData);
            rentsE.add(rent);
        }
        return rentsE;
    }

    public List<Rent> rentListEtoD(List<com.library.Rentbook> rentEntity) {

        List<Rent> rentsD = new ArrayList<>();

        for (Rentbook aRentEntity : rentEntity) {
            Rent rent = convertEtoD(aRentEntity);
            rentsD.add(rent);
        }
        return rentsD;

    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        return new java.sql.Date(uDate.getTime());
    }

    public XMLGregorianCalendar translate(GregorianCalendar cal) {
        XMLGregorianCalendar xmlDate = null;
        try {
            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (DatatypeConfigurationException e) {
            logger.trace(e);
        }
        return xmlDate;
    }
}
