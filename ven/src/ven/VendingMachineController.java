package ven;

public interface VendingMachineController {

    CoinBundle calculateChange(VendingMachineRequest request);
}
