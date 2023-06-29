package org.udemy.service.payment;

import org.junit.jupiter.api.Test;
import org.udemy.domain.SavingsBankAccount;
import org.udemy.logging.ConsoleLogger;
import org.udemy.repository.BankAccountFileRepository;
import org.udemy.repository.BankAccountRepository;
import org.udemy.service.notification.NotificationService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class PaymentServiceTest {

    private BankAccountRepository bankAccountRepository = mock(BankAccountFileRepository.class);

    private NotificationService notificationService = mock(NotificationService.class);

    private ConsoleLogger consoleLogger = mock(ConsoleLogger.class);

    private PaymentService paymentService = new PaymentService(bankAccountRepository,notificationService,consoleLogger);

    @Test
    void should_send_payments_to_savings_accounts() {
        //given
        SavingsBankAccount savingsBankAccount1 = new SavingsBankAccount(3, 500, "John Doe 3", "john.doe3@mail.com");
        SavingsBankAccount savingsBankAccount2 = new SavingsBankAccount(4, 700, "John Doe 4", "john.doe4@mail.com");
        List<SavingsBankAccount> savingsBankAccounts = Arrays.asList(savingsBankAccount1, savingsBankAccount2);

        doReturn(savingsBankAccounts).when(bankAccountRepository).findAllSavingsAccounts();

        //when
        paymentService.sendPayments(500);

        //then
        assertThat(savingsBankAccount1.getBalance()).isEqualTo(1000);
        verify(notificationService, times(1)).notify(savingsBankAccount1);
        assertThat(savingsBankAccount2.getBalance()).isEqualTo(1200);
        verify(notificationService, times(1)).notify(savingsBankAccount2);
    }
}