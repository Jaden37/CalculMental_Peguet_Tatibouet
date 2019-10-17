package dal;

public abstract class DataAccessObjJDBC<E> implements IDAO<E>{
    protected String dbUrl = "";
    protected String dbLogin = "";
    protected String dbPwd = "";

    public DataAccessObjJDBC( String dbUrl, String dbLogin, String dbPwd ) {
        this.dbUrl = dbUrl;
        this.dbLogin = dbLogin;
        this.dbPwd = dbPwd;
    }
}
