package models;

public class VerifiedUser extends User {

    private String verificationBadge;

    public VerifiedUser(String id, String username, String email, String password, String verificationBadge) {
        super(id, username, email, password);
        this.verificationBadge = verificationBadge;
    }

    public String getVerificationBadge() {
        return verificationBadge;
    }

    public void setVerificationBadge(String verificationBadge) {
        this.verificationBadge = verificationBadge;
    }
    
}
