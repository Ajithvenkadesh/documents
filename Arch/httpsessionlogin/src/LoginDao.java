import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	public boolean validate(String name, String pass) {
		boolean status = false;
		try {
			Class.forName("org.postgresql.Driver");
			
			final String url = "jdbc:postgresql://localhost/sql";
			final String password = "123";
			final String user = "postgres";
			final Connection connection = DriverManager.getConnection(url, user, password);
			
			try (PreparedStatement statement = connection
					.prepareStatement("select name, password from user_table where name=? and password=?")) {
				statement.setString(1, name);
				statement.setString(2, pass);

				final ResultSet result = statement.executeQuery();
				status = result.next();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}
}