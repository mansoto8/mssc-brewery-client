package com.ms.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import com.ms.msscbreweryclient.web.model.BeerDTO;
import com.ms.msscbreweryclient.web.model.CustomerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient
{
  public final String BEER_PATH_V1 = "/api/v1/beer/";
  public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
  private String apiHost;
  private final RestTemplate restTemplate;

  public BreweryClient(final RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public BeerDTO getBeerById(UUID uuid) {
    return restTemplate.getForObject(apiHost + BEER_PATH_V1 + uuid.toString(), BeerDTO.class);
  }

  public URI saveNewBeer(BeerDTO beerDTO) {
    return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDTO);
  }

  public void updateBeer(UUID beerId, BeerDTO beerDTO) {
    restTemplate.put(apiHost + BEER_PATH_V1 + "/" + beerId, beerDTO);
  }

  public void deleteBeer(UUID beerId) {
    restTemplate.delete(apiHost + BEER_PATH_V1 + "/" + beerId);
  }

  public CustomerDTO getCustomerById(UUID customerId) {
    return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + customerId.toString(), CustomerDTO.class);
  }

  public URI saveNewCustomer(CustomerDTO customerDTO) {
    return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDTO);
  }

  public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
    restTemplate.put(apiHost + CUSTOMER_PATH_V1 + "/" + customerId, customerDTO);
  }

  public void deleteCustomer(UUID customerId) {
    restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + "/" + customerId);
  }

  public void setApiHost(final String apiHost) {
    this.apiHost = apiHost;
  }
}
