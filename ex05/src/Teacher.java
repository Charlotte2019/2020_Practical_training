import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;

import java.util.Objects;

public class Teacher {
    private String account;
    private String name;
    private String password;
    private String mailbox;
    private int phone;

    public Teacher(String account, String name, String password, String mailbox, int phone) {
        this.account = account;
        this.name = name;
        this.password = password;
        this.mailbox = mailbox;
        this.phone = phone;
    }

    public Teacher(){

    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(account, teacher.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, name, password, mailbox, phone);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
