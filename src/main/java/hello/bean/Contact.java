package hello.bean;

public class Contact {
    private String name;
    private String email;
    private String mobile;
    private String info;

    public Contact(String name, String email, String mobile, String info) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.info = info;
    }
    public Contact(Contact contact) {
        this.name = contact.name;
        this.email = contact.email;
        this.mobile = contact.mobile;
        this.info = contact.info;
    }

    public Contact(String name) {
        super();
        this.name = name;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Contact setInfo(String info) {
        this.info = info;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getInfo() {
        return info;
    }
}
