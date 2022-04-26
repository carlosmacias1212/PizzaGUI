package customer_info;

public class customerCreditCard {
    // customerCreditCard variables/attributes:
    private String nameOnCard;
    private String cardNumber;
    private String securityCode;
    private String expirationDate;

    // customerCreditCard overloaded constructor:
    public customerCreditCard(String nameOnCard, String cardNumber, String securityCode, String expirationDate) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
    }

    // getters and setters for customerCreditCard:
    public String getNameOnCard() { return nameOnCard; }

    public void setNameOnCard(String nameOnCard) { this.nameOnCard = nameOnCard; }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}