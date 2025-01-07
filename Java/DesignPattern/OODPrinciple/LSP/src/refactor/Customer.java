package refactor;

/* 客户抽象类 */
public abstract class Customer {
    protected String name;
    protected String email;

    public abstract String getEmail();

    public abstract void setEmail(String email);

    public abstract String getName();

    public abstract void setName(String name);
}
