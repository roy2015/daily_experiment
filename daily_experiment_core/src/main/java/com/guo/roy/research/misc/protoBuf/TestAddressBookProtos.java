package com.guo.roy.research.misc.protoBuf;

import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by apple on 2019/9/18.
 *
 * protoBuf写入文件，读文件
 */
public class TestAddressBookProtos {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestAddressBookProtos.class);

    public AddressBookProtos.AddressBook buildAddressBook (){
        AddressBookProtos.Person.Builder personBuilder1 = AddressBookProtos.Person.newBuilder();
        personBuilder1.setName("guo1").setEmail("guo1@163.com").setId(1);
        AddressBookProtos.Person.PhoneNumber.Builder phoneNumberBuilder1 = AddressBookProtos.Person.PhoneNumber.newBuilder();
        phoneNumberBuilder1.setType(AddressBookProtos.Person.PhoneType.HOME).setNumber("07136231221");
        AddressBookProtos.Person.PhoneNumber.Builder phoneNumberBuilder2 = AddressBookProtos.Person.PhoneNumber.newBuilder();
        phoneNumberBuilder2.setType(AddressBookProtos.Person.PhoneType.MOBILE).setNumber("13989455787");
        personBuilder1.addPhones(phoneNumberBuilder1.build()).addPhones(phoneNumberBuilder2.build());

        AddressBookProtos.Person.Builder personBuilder2 = AddressBookProtos.Person.newBuilder();
        personBuilder2.setName("guo2").setEmail("guo2@163.com").setId(2);
        AddressBookProtos.Person.PhoneNumber.Builder phoneNumberBuilder3 = AddressBookProtos.Person.PhoneNumber.newBuilder();
        phoneNumberBuilder3.setType(AddressBookProtos.Person.PhoneType.HOME).setNumber("07136231222");
        AddressBookProtos.Person.PhoneNumber.Builder phoneNumberBuilder4 = AddressBookProtos.Person.PhoneNumber.newBuilder();
        phoneNumberBuilder4.setType(AddressBookProtos.Person.PhoneType.MOBILE).setNumber("13989455788");
        personBuilder2.addPhones(phoneNumberBuilder3.build()).addPhones(phoneNumberBuilder4.build());

        AddressBookProtos.AddressBook.Builder addressBookBuilder = AddressBookProtos.AddressBook.newBuilder();
        AddressBookProtos.AddressBook addressBook = addressBookBuilder.addPeople(personBuilder1.build()).addPeople(personBuilder2.build()).build();
        return addressBook;
    }

    public void doWrite (AddressBookProtos.AddressBook addressBook) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/apple/guojun/testGbp.txt"));
            addressBook.writeDelimitedTo(fileOutputStream);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public AddressBookProtos.AddressBook doRead() {
        AddressBookProtos.AddressBook addressBook = null;
        try {
            addressBook = AddressBookProtos.AddressBook.parseDelimitedFrom (new FileInputStream("/Users/apple/guojun/testGbp.txt"));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return addressBook;
    }


    public static void main(String[] args) {
        TestAddressBookProtos testAddressBookProtos = new TestAddressBookProtos();
        AddressBookProtos.AddressBook addressBook = testAddressBookProtos.buildAddressBook();
        logger.info("{}", addressBook);
        testAddressBookProtos.doWrite(addressBook);
//        addressBook = testAddressBookProtos.doRead();
        logger.info("{}", addressBook);
    }
}
