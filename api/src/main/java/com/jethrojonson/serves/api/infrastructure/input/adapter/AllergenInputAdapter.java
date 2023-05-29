package com.jethrojonson.serves.api.infrastructure.input.adapter;


import com.jethrojonson.serves.api.application.dto.AllergenDTO.*;
import com.jethrojonson.serves.api.infrastructure.input.port.AllergenInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/allergens")
@RequiredArgsConstructor
@Tag(name = "Allergen Controller", description = "Controller of the allergens operations")
public class AllergenInputAdapter {

    private final AllergenInputPort allergenInputPort;

    @Operation(summary = "Add new allergen")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "New allergen added successfully",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AllergenResponse.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": 1,
                                                "allergenName": "Gluten",
                                                "description": "Cereals with gluten"
                                            }
                                            """
                            )}
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Incorrect input body format",
                    content = @Content
            )
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Input body format",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = NewAllergenRequest.class),
                    examples = @ExampleObject(
                            value = """
                                    {
                                        "allergenName": "Gluten",
                                        "description": "Cereals with gluten"
                                    }
                                    """
                    )
            )
    )
    @PostMapping("/")
    public ResponseEntity<AllergenResponse> addAllergen (@Valid @RequestBody NewAllergenRequest toAdd){
        AllergenResponse added = allergenInputPort.addAllergen(toAdd);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{allergenId}")
                .buildAndExpand(added.id())
                .toUri();
        return ResponseEntity.created(uri).body(added);
    }

    @Operation(summary = "Obtains the list of allergens")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Allergens were found",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AllergenResponse.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                 {
                                                     "id": 1,
                                                     "allergenName": "Gluten",
                                                     "description": "Cereales  con gluten"
                                                 },
                                                 {
                                                     "id": 2,
                                                     "allergenName": "Crustáceos",
                                                     "description": "Crustáceos y productos a base de custáceos"
                                                 },
                                                 {
                                                     "id": 3,
                                                     "allergenName": "Huevo",
                                                     "description": "Puede contener trazas de huevo"
                                                 },
                                                 {
                                                     "id": 4,
                                                     "allergenName": "Pescado",
                                                     "description": "Pescado y productos a base de pescados"
                                                 }
                                            ]
                                            """
                            )}
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No allergens were found",
                    content = @Content
            )
    })
    @GetMapping("/")
    public List<AllergenResponse> getAllAllergens(){
        return allergenInputPort.getAllAllergens();
    }

    @Operation(summary = "Obtains an allergen by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "The allergen was found",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AllergenResponse.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": 1,
                                                "allergenName": "Gluten",
                                                "description": "Cereales  con gluten"
                                            }
                                            """
                            )}
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The allergen was not found",
                    content = @Content
            )
    })
    @GetMapping("/{allergenId}")
    public AllergenResponse getAllergenById(@PathVariable Long allergenId){
        return allergenInputPort.getAllergenById(allergenId);
    }

    @Operation(summary = "Updates an allergen")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Allergen updated successfully",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AllergenResponse.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": 1,
                                                "allergenName": "Gluten",
                                                "description": "Cereals with gluten"
                                            }
                                            """
                            )}
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Incorrect input body format",
                    content = @Content
            )
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Input body format",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = NewAllergenRequest.class),
                    examples = @ExampleObject(
                            value = """
                                    {
                                        "allergenName": "Gluten",
                                        "description": "Cereals with gluten"
                                    }
                                    """
                    )
            )
    )
    @PutMapping("/{allergenId}")
    public AllergenResponse updateAllergen(@PathVariable Long allergenId,@Valid @RequestBody NewAllergenRequest toUpdate){
        return allergenInputPort.updateAllergen(allergenId, toUpdate);
    }

    @Operation(summary = "Deletes an allergen")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Allergen was deleted successfully",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The allergen was not found",
                    content = @Content
            )
    })
    @DeleteMapping("/{allergenId}")
    public ResponseEntity<?> deleteAllergen(@PathVariable Long allergenId){
        allergenInputPort.deleteAllergen(allergenId);
        return ResponseEntity.noContent().build();
    }
}
