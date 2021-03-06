package com.cmymesh.service.demo.cars.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmymesh.service.demo.cars.model.pojo.Car;
import com.cmymesh.service.demo.cars.model.pojo.CarSummary;
import com.cmymesh.service.demo.cars.model.pojo.Error;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "cars")
public interface CarsApi {

  @ApiOperation(value = "Add a new Car", nickname = "addCar", notes = "", response = Car.class, tags = { "cars", })
  @ApiResponses(value = { @ApiResponse(code = 201, message = "Successful operation ", response = Car.class),
      @ApiResponse(code = 400, message = "A bad request was made.", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized.", response = Error.class),
      @ApiResponse(code = 404, message = "Not found.", response = Error.class),
      @ApiResponse(code = 409, message = "Conflict with resource.", response = Error.class),
      @ApiResponse(code = 500, message = "Internal server error.", response = Error.class),
      @ApiResponse(code = 200, message = "Unknown Error", response = Error.class) })
  @PostMapping(value = "/20200201/cars/", produces = { "application/json" })
  ResponseEntity<Car> addCar(@ApiParam(value = "New car to add", required = true) @Valid @RequestBody Car body);

  @ApiOperation(value = "Get car details per plate id", nickname = "getCar", notes = "Get car details per car id  ", response = Car.class, tags = {
      "cars", })
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation ", response = Car.class),
      @ApiResponse(code = 400, message = "A bad request was made.", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized.", response = Error.class),
      @ApiResponse(code = 404, message = "Not found.", response = Error.class),
      @ApiResponse(code = 500, message = "Internal server error.", response = Error.class),
      @ApiResponse(code = 200, message = "Unknown Error", response = Error.class) })
  @GetMapping(value = "/20200201/cars/{carId}", produces = { "application/json" })
  ResponseEntity<Car> getCar(@ApiParam(value = "", required = true) @PathVariable("carId") String carId,
      @ApiParam(value = "Partial response refers to an optimization technique offered by the RESTful web APIs to return only the information  (fields) required by the client. In this mechanism, the client sends the required field names as the query parameters for an API to the server, and the server trims down the default response content by removing the fields that are not required by the client. The parameter used to control what fields to return should be a query string parameter called \"fields\" of type array, provide the values as enums, and usecollectionFormat ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);

  @ApiOperation(value = "Get user details per user Id", nickname = "listCars", notes = "Get user details per user id  ", response = Object.class, tags = {
      "cars", })
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation ", response = Object.class),
      @ApiResponse(code = 400, message = "A bad request was made.", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized.", response = Error.class),
      @ApiResponse(code = 404, message = "Not found.", response = Error.class),
      @ApiResponse(code = 500, message = "Internal server error.", response = Error.class),
      @ApiResponse(code = 200, message = "Unknown Error", response = Error.class) })
  @GetMapping(value = "/20200201/cars/", produces = { "application/json" })
  ResponseEntity<List<CarSummary>> listCars(
      @ApiParam(value = "Partial response refers to an optimization technique offered by the RESTful web APIs to return only the information  (fields) required by the client. In this mechanism, the client sends the required field names as the query parameters for an API to the server, and the server trims down the default response content by removing the fields that are not required by the client. The parameter used to control what fields to return should be a query string parameter called \"fields\" of type array, provide the values as enums, and usecollectionFormat ") @Valid @RequestParam(value = "fields", required = false) List<String> fields,
      @Min(1) @Max(1000) @ApiParam(value = "The maximum number of items to return in a paginated \"List\" call. Example: `500` ") @Valid @RequestParam(value = "limit", required = false) Integer limit,
      @Size(min = 1, max = 512) @ApiParam(value = "The value of page to display. ") @Valid @RequestParam(value = "page", required = false) String page,
      @ApiParam(value = "The sort order to use, either ascending (`ASC`) or descending (`DESC`). The DISPLAYNAME sort order is case sensitive. ", allowableValues = "ASC, DESC") @Valid @RequestParam(value = "sortOrder", required = false) String sortOrder,
      @ApiParam(value = "The field to sort by. You can provide one sort order (`sortOrder`). Default order for TIMECREATED is descending. Default order for DISPLAYNAME is ascending. The DISPLAYNAME sort order is case sensitive.  **Note:** In general, some \"List\" operations (for example, `ListInstances`) let you optionally filter by Availability Domain if the scope of the resource type is within a single Availability Domain. If you call one of these \"List\" operations without specifying an Availability Domain, the resources are grouped by Availability Domain, then sorted. ") @Valid @RequestParam(value = "sortBy", required = false) String sortBy);

  @ApiOperation(value = "Update car", nickname = "updateCar", notes = "", response = Car.class, tags = { "cars", })
  @ApiResponses(value = { @ApiResponse(code = 201, message = "Successful operation ", response = Car.class),
      @ApiResponse(code = 400, message = "A bad request was made.", response = Error.class),
      @ApiResponse(code = 401, message = "Unauthorized.", response = Error.class),
      @ApiResponse(code = 404, message = "Not found.", response = Error.class),
      @ApiResponse(code = 500, message = "Internal server error.", response = Error.class),
      @ApiResponse(code = 200, message = "Unknown Error", response = Error.class) })
  @PutMapping(value = "/20200201/cars/", produces = { "application/json" })
  ResponseEntity<Car> updateCar(@ApiParam(value = "Car to update", required = true) @Valid @RequestBody Car body);

}
