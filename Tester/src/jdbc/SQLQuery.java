package jdbc;

import java.sql.*;

public class SQLQuery {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			String sqlQuery = "select * from systemattributes";
			String url = "jdbc:postgresql://vmaxpgsstg01.isus.emc.com:5432/vmaxt";
			conn = DriverManager.getConnection(url, "vmax", "Vmax123$");

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sqlQuery);
			while (rs.next()) {
				int columnCount = rs.getMetaData().getColumnCount();
				for (int i = 1; i <= columnCount; i++)
					System.out.println(rs.getObject(i));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
}
