package za.ac.nwu.ac.web.sb.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.Logic.flow.impl.CreateAccountType;
import za.ac.nwu.ac.Logic.flow.impl.FetchAccountTypeFlow;
import za.ac.nwu.ac.Logic.flow.impl.modifyAccountTypeFlow;
import za.ac.nwu.ac.domain.Service.GeneralResponse;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("account-type")
public class AccountTypeController {

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountType createAccountType;

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow, @Qualifier("CreateAccountTypeFlowName")CreateAccountType createAccountType)
    {
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountType = createAccountType;
    }


    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account Types. ", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
 public ResponseEntity<GeneralResponse<List<AccountTypeDto>>>getAll()
    {
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountType.", notes = "Creates a new AccountType in DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountType hs been created successfully",response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request",response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(@ApiParam(value = "Request body to create a new AccountType",required = true) @RequestBody AccountTypeDto accountType)
    {
        AccountTypeDto accounTypeResponse = createAccountType.create(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true,accounTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{Mnemonic}")
     @ApiOperation(value = "Fetches the specified AccountType.", notes = "Fetches the AccountType corresponding to the given mnemonic.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>>getAccountType(
            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType"
            ,example = "Miles",
            name = "Mnemonic",
            required = true)
            @PathVariable("mnemonic") final String mnemonic)
    {
        AccountTypeDto accountType = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("{mnemonic}")
    @ApiOperation(value = "Deletes the specific AccountType.", notes = "Deletes the Account corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountType Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)

    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>>deleteAccountType(
            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType.",
            example = "MILES",
            name = "mnemonic",
            required = true)
            @PathVariable("mnemonic") final  String mnemonic)
    {
        AccountTypeDto accountType = modifyAccountTypeFlow.deleteAccountType(mnemonic);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("{mnemonic}")
    @ApiOperation(value = "updates the specified AccountType.", notes = "Updates the AccountType corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountType Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)

    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> updateAccountType(
            @ApiParam(value = "mnemonic that uniquely identifies the AccountType.",
            example = "MILES",
            name = "mnemonic",
            required = true)
            @PathVariable("mnemonic") final String mnemonic,

            @ApiParam(value = "The new AccountTypeName that the specified AccountType should be updated with.",
            name = "newAccountTypeName",
            required = true)
            @RequestParam("newAccountTypeName") final String newAccountTypeName,
            @ApiParam(value = "The optional new date with to update the CreationDate is ISO date format(yyyy-mm-dd)if empty/null it will not update",
            name = "newCreationDate")
            @RequestParam(value = "newCreation", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate newCreationDate)
    {
        AccountTypeDto accountType = modifyAccountTypeFlow.updateAccountType(mnemonic,newAccountTypeName,newCreationDate );
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true,accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }






}
