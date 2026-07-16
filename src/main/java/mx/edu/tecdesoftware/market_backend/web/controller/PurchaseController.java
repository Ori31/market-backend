package mx.edu.tecdesoftware.market_backend.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import mx.edu.tecdesoftware.market_backend.domain.Purchase;
import mx.edu.tecdesoftware.market_backend.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("")
    @Operation(summary = "Get all purchases", description = "Return a list of all available purchases")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of purchases")
    @ApiResponse(responseCode = "404", description = "Purchases not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Purchase>> getAll() {
        return ResponseEntity.ok(purchaseService.getAll());
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Get purchases by client", description = "Return a list of purchases made by a specific client")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of client purchases")
    @ApiResponse(responseCode = "404", description = "No purchases found for this client")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Purchase>> getByClient(
            @Parameter(description = "ID of the client", example = "4546221", required = true)
            @PathVariable("clientId") String clientId) {
        return purchaseService.getByClient(clientId)
                .filter(purchases -> !purchases.isEmpty())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    @Operation(
            summary = "Create a new purchase",
            description = "Register a new purchase and return it",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example Purchase",
                                    value =
                                    """
                                            {
                                               "clientId": "4546221",
                                               "date": "2026-07-16T14:30:00",
                                               "paymentMethod": "E",
                                               "comment": "compra de prueba",
                                               "status": "P",
                                               "purchaseItems": [
                                                 {
                                                   "productId": 1,
                                                   "quantity": 5,
                                                   "total": 1500,
                                                   "active": true
                                                 },
                                                 {
                                                   "productId": 23,
                                                   "quantity": 2,
                                                   "total": 5000,
                                                   "active": true
                                                 }
                                               ]
                                             }
                                    """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "201", description = "Purchase created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid purchase data")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
