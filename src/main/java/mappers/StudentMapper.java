package mappers;

import entities.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {

    public void insert(Student student);

    public void update(Student student);

    @Insert("insert into student(name,sex) values(#{name},#{sex})")
    public void insertT(Student user);

    @Delete("delete from student where id=#{id}")
    public void deleteById(int id);

    @Update("update student set name=#{name},sex=#{sex} where id=#{id}")
    public void updateT(Student user);

    @Select("select * from student where id=#{id}")
    public Student getUser(int id);

    @Select("select * from student")
    public List<Student> getAllUsers();

}
