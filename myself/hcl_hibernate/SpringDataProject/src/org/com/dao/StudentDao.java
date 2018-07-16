package org.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.com.bean.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class StudentDao {

	private DataSource ds;
	private JdbcTemplate jdbcTemplate;

	public void studentInit() {
		jdbcTemplate = new JdbcTemplate(ds);
	}

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public int updateStudent(Student s) {
		return jdbcTemplate.update("update  student  set  name='" + s.getName() + "' ,  subject='" + s.getSubject()
				+ "' where id=" + s.getId() + " ");
	}

	public int addStudent(Student s) {
		return jdbcTemplate
				.update("insert into student values(" + s.getId() + ",'" + s.getName() + "','" + s.getSubject() + "')");
	}

	public int removeStudent(Student s) {
		return jdbcTemplate.update("delete from  student where id=" + s.getId() + "");
	}

	public boolean addStudent1(Student s) {

		PreparedStatementCallback<Boolean> pst = new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, s.getId());
				ps.setString(2, s.getName());
				ps.setString(3, s.getSubject());
				return ps.execute();
			}

		};

		return jdbcTemplate.execute("insert into student values(?,?,?)", pst);

	}

	public Student searchStudent(int id){

		RowMapper<Student> row = new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int arg1) throws SQLException {
				Student s = new Student();

				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setSubject(rs.getString(3));
				return s;
			}
		};
		
	return jdbcTemplate.queryForObject
			("select * from student where id =?",row,id );
	
	}
	
	List<Student> s_list;

	public List<Student> getAllStudent_rowmapper() {

		RowMapper<Student> row = new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int arg1) throws SQLException {
				Student s = new Student();

				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setSubject(rs.getString(3));
				return s;
			}
		};

		return jdbcTemplate.query("select * from student", row);

	}

	public List<Student> getAllStudent() {

		ResultSetExtractor<List<Student>> rse = new ResultSetExtractor<List<Student>>() {

			@Override
			public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
				s_list = new ArrayList<>();
				Student s1 = null;
				while (rs.next()) {
					s1 = new Student();

					s1.setId(rs.getInt(1));
					s1.setName(rs.getString(2));
					s1.setSubject(rs.getString(3));
					s_list.add(s1);
				}
				return s_list;
			}
		};
		return jdbcTemplate.query("select * from student", rse);
	}
}
