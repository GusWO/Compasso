package questao9;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Conexao {
	
	public DataSource dataSource;
	
	public Conexao() {
		
		ComboPooledDataSource combo = new ComboPooledDataSource();
		combo.setJdbcUrl("jdbc:mysql://localhost/Loja_info?useTimezone=true&serverTimezone=UTC");
		combo.setUser("root");
		combo.setPassword("1234");
		
		this.dataSource = combo;
	}
	
	public Connection iniciaConexao() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
		
	}
}
