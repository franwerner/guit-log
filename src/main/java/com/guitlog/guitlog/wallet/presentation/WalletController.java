package com.guitlog.guitlog.wallet.presentation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.guitlog.guitlog.wallet.presentation.CreateWalletRequest;
import com.guitlog.guitlog.wallet.persistence.WalletEntity;
import com.guitlog.guitlog.wallet.persistence.WalletMapper;
import com.guitlog.guitlog.wallet.application.CreateWalletUseCase;
import com.guitlog.guitlog.wallet.application.GetWalletByIdUseCase;
import com.guitlog.guitlog.wallet.application.GetWalletsByUserUseCase;
import com.guitlog.guitlog.wallet.domain.Wallet;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final CreateWalletUseCase createWalletUseCase;
    private final GetWalletByIdUseCase getWalletByIdUseCase;
    private final GetWalletsByUserUseCase getWalletsByUserUseCase;
    private final WalletMapper walletMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WalletEntity create(@RequestBody CreateWalletRequest request) {
        Wallet wallet = walletMapper.toDomain(request);
        wallet.setActive(true);
        wallet.setCurrentBalance(request.getInitialBalance());
        wallet.setCreatedAt(LocalDateTime.now());
        return createWalletUseCase.execute(wallet);
    }

    @GetMapping("/{id}")
    public WalletEntity getById(@PathVariable Long id) {
        return getWalletByIdUseCase.execute(id);
    }

    @GetMapping("/user/{userId}")
    public List<WalletEntity> getByUserId(@PathVariable Long userId) {
        return getWalletsByUserUseCase.execute(userId);
    }
}
