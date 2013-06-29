
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WeaponsDAO extends AbstractDAO {

    public final static String SQL_TO_FIND_ALL = "SELECT id, brand, model, caliber, country, price FROM Weapons";
    public final static String SQL_TO_FIND = "SELECT id, brand, model, caliber, country, price FROM Weapons WHERE (id=?)";
    public final static String SQL_TO_CREATE = "INSERT INTO Weapons (brand, model, caliber, country, price) VALUES (?,?,?,?,?)";
    public final static String SQL_TO_UPDATE = "UPDATE Weapons SET brand=?, model=?, caliber=?, country=?, price=? WHERE (id=?)";
    public final static String SQL_TO_COUNT_ALL = "SELECT COUNT(*) FROM Weapons";
    public final static String SQL_TO_REMOVE_ALL = "DELETE FROM Weapons";
    public final static String SQL_TO_REMOVE = "DELETE FROM Weapons WHERE (id=?)";
    public final static String SQL_TO_FIRST = "SELECT * FROM Weapons LIMIT 1,1";

    public void persist(Weapons o) throws Exception {
        if (o != null) {
            if (o.getId() == 0) {
                addNew(o);
            } else {
                update(o);
            }
        } else {
            throw new NullPointerException();
        }
    }

    public ArrayList<Weapons> findAll() throws Exception {
        ArrayList<Weapons> lst = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = super.__getConnection();
            stmt = con.prepareStatement(SQL_TO_FIND_ALL);
            rs = super.__doDatabaseQuery(stmt);
            while (rs.next()) {
                lst.add(this.fillObject(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            super.__closeConnection(con, stmt, rs);
        }

        return lst;
    }

    public Weapons nextWeapons(int nextrow) throws Exception {
        Weapons o = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = super.__getConnection();
            stmt = con.prepareStatement(SQL_TO_FIND_ALL);
            rs = super.__doDatabaseQuery(stmt);
            rs.absolute(nextrow);
            o = this.fillObject(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            super.__closeConnection(con, stmt, rs);
        }
        return o;
    }

    public Weapons find(String id) throws Exception {
        Weapons o = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = super.__getConnection();
            stmt = con.prepareStatement(SQL_TO_FIND);
            stmt.setString(1, id);
            rs = super.__doDatabaseQuery(stmt);
            while (rs.next()) {
                o = this.fillObject(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            super.__closeConnection(con, stmt, rs);
        }

        return o;
    }

    public int countAll() throws Exception {
        return super.countAll(SQL_TO_COUNT_ALL);
    }

    public void removeAll() throws Exception {
        super.removeAll(SQL_TO_REMOVE_ALL);
    }

    public void remove(Weapons o) throws Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = __getConnection();
            stmt = con.prepareStatement(SQL_TO_REMOVE);
            stmt.setInt(1, o.getId());
            __doDatabaseUpdate(stmt);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            __closeConnection(con, stmt, null);
        }
    }

    private Weapons fillObject(ResultSet rs) throws Exception {
        Weapons o = new Weapons();
        o.setId(rs.getInt("id"));
        o.setBrand(rs.getString("brand"));
        o.setModel(rs.getString("model"));
        o.setCaliber(rs.getString("caliber"));
        o.setCountry(rs.getString("country"));
        o.setPrice(rs.getString("price"));
        return o;
    }

    private synchronized void addNew(Weapons o) throws Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = super.__getConnection();
            stmt = con.prepareStatement(SQL_TO_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, o.getBrand());
            stmt.setString(2, o.getModel());
            stmt.setString(3, o.getCaliber());
            stmt.setString(4, o.getCountry());
            stmt.setString(5, o.getPrice());
            super.__doDatabaseUpdate(stmt);
            rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                o.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("ERRO AQUI...");
            throw e;
        } finally {
            super.__closeConnection(con, stmt, rs);
        }
    }

    private void update(Weapons o) throws Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = super.__getConnection();
            stmt = con.prepareStatement(SQL_TO_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, o.getBrand());
            stmt.setString(2, o.getModel());
            stmt.setString(3, o.getCaliber());
            stmt.setString(4, o.getCountry());
            stmt.setString(5, o.getPrice());
            stmt.setInt(6, o.getId());
            int rowcount = super.__doDatabaseUpdate(stmt);
            if (rowcount == 0) {
                throw new SQLException("Object could not be saved! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            super.__closeConnection(con, stmt, rs);
        }
    }
}
