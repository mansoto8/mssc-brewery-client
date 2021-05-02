package com.ms.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import com.ms.msscbreweryclient.web.model.BeerDTO;
import com.ms.msscbreweryclient.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest
{
  @Autowired
  BreweryClient client;

  // These tests assume https://github.com/mansoto8/spring-ms-beer-brewery is running
  // Test different rest template configurations by commenting the @Component of the one deselected
  @Test
  void getBeerById() {
    BeerDTO beerDTO = client.getBeerById(UUID.randomUUID());

    assertNotNull(beerDTO);
  }

  @Test
  void saveNewBeer() {
    BeerDTO beerDTO = BeerDTO.builder().beer("Costeña").beerStyle("Rubia").build();
    URI uri = client.saveNewBeer(beerDTO);

    assertNotNull(uri);

    System.out.println("URI: " + uri.toString());
  }

  @Test
  void updateBeer() {
    BeerDTO beerDTO = BeerDTO.builder().beer("Costeña").beerStyle("Rubia").build();

    client.updateBeer(UUID.randomUUID(), beerDTO);
  }

  @Test
  void deleteBeer() {
    client.deleteBeer(UUID.randomUUID());
  }

  @Test
  void getCustomerById() {
    CustomerDTO customerDTO = client.getCustomerById(UUID.randomUUID());

    assertNotNull(customerDTO);
  }

  @Test
  void saveNewCustomer() {
    CustomerDTO customerDTO = CustomerDTO.builder().name("Alex").build();
    URI uri = client.saveNewCustomer(customerDTO);

    assertNotNull(uri);

    System.out.println("URI: " + uri.toString());
  }

  @Test
  void updateCustomer() {
    CustomerDTO customerDTO = CustomerDTO.builder().name("Alicia").build();

    client.updateCustomer(UUID.randomUUID(), customerDTO);
  }

  @Test
  void deleteCustomer() {
    client.deleteCustomer(UUID.randomUUID());
  }
}