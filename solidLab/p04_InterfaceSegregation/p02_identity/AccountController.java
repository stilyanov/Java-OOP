package solidLab.p04_InterfaceSegregation.p02_identity;

import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.Account;
import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.AccountControllerInterface;

public class AccountController implements AccountControllerInterface {
    private final Account manager;

    private boolean requireUniqueEmail;

    private int minRequiredPasswordLength;
    private int maxRequiredPasswordLength;


    public AccountController(Account manager) {
        this.manager = manager;
    }

    public void changePassword(String oldPass, String newPass) {
        this.manager.changePassword(oldPass, newPass);
    }

    @Override
    public boolean getRequireUniqueEmail() {
        return this.requireUniqueEmail;
    }

    @Override
    public int getMinRequiredPasswordLength() {
        return this.getMinRequiredPasswordLength();
    }

    @Override
    public int getMaxRequiredPasswordLength() {
        return this.getMaxRequiredPasswordLength();
    }
}
