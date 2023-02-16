package pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginForEcommerceXmlBind {
    private String userEmail;
    private String userPassword;

    public LoginForEcommerceXmlBind() {
        super();
    }

    public LoginForEcommerceXmlBind(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    @XmlElement
    public String getUserEmail() {
        return userEmail;
    }

    @XmlElement
    public String getUserPassword() {
        return userPassword;
    }
}
