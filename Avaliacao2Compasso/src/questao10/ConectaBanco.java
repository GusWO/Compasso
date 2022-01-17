package questao10;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConectaBanco {

	public DataSource dataSource;
	
	public ConectaBanco() {
		ComboPooledDataSource combo = new ComboPooledDataSource();
		combo.setJdbcUrl("jdbc:mysql://localhost/questao10s?useTimezone=true&serverTimezone=UTC");
		combo.setUser("root");
		combo.setPassword("1234");
		
		this.dataSource = combo;
	}
	
	public Connection conexao() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
