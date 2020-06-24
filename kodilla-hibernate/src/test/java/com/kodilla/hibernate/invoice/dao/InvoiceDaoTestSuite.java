package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    ItemDao itemDao;


    @Test
    public void testInvoiceDaoSave() {
        //Given some examples
        Product product1 = new Product("Some product nr 1");
        Product product2 = new Product("Some other product nr 2");
        Product product3 = new Product("Some product nr 3");
        Item item1 = new Item(product1, new BigDecimal(300), 10, new BigDecimal(3000.00));
        Item item2 = new Item(product2, new BigDecimal(20), 50, new BigDecimal(1000));
        Item item3 = new Item(product3, new BigDecimal(15), 10, new BigDecimal(150));

        product1.getItems().add(item1);
        product2.getItems().add(item2);
        product3.getItems().add(item3);

        Invoice invoice1 = new Invoice("2020.06.21/CA");
        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice1.getItems().add(item3);

        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice1);
        //When dao save

        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        int idProduct1 = product1.getId();
        int idProduct2 = product1.getId();
        int idProduct3 = product1.getId();

        invoiceDao.save(invoice1);
        int idInvoice1 = invoice1.getId();

        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);

        int idItem1 = item1.getId();
        int idItem2 = item1.getId();
        int idItem3 = item1.getId();

        //Then asserts

        Assert.assertNotEquals(0,idInvoice1);
        Assert.assertNotEquals(0,idProduct1);
        Assert.assertNotEquals(0,idProduct2);
        Assert.assertNotEquals(0,idProduct3);
        Assert.assertNotEquals(0,idItem1);
        Assert.assertNotEquals(0,idItem2);
        Assert.assertNotEquals(0,idItem3);

        //CleanUp

        itemDao.delete(item1);
        itemDao.delete(item2);
        itemDao.delete(item3);

        productDao.delete(product1);
        productDao.delete(product2);
        productDao.delete(product3);

        invoiceDao.delete(invoice1);
    }

}
