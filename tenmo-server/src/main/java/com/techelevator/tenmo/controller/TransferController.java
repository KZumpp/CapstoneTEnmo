package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDto;
import com.techelevator.tenmo.model.TransferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transfer")
@PreAuthorize("isAuthenticated()")
public class TransferController {

    @Autowired
    private TransferDao transferDao;
    private AccountDao accountDao;

    public TransferController(TransferDao transferDao, AccountDao accountDao) {
        this.accountDao = accountDao;
        this.transferDao = transferDao;
    }

    @GetMapping("/user/{id}")
    public List<Transfer> getTransferByAccountId(@PathVariable Long id) {
        return transferDao.findByAccountId(id);
    }

    @GetMapping("/{id}") //get transfer by transferId
    public TransferDTO getTransferById(@PathVariable Long id) {
        return transferDao.findByTransferId(id);
    }

    @PostMapping()
    public boolean createTransfer(@Valid @RequestBody TransferDTO transferDTO) {
        return transferDao.createTransfer(transferDTO);
    }

    @PutMapping("/update")
    public boolean updateTransferStatus(@Valid @RequestBody TransferDTO transferDTO) {
            return transferDao.updateTransferStatus(transferDTO);
    }

    @GetMapping("/getinfo/{transferId}")
    public Transfer getTransferDetails(@PathVariable Long transferId) {
        return transferDao.convertFromDTO(transferId);
    }



}
