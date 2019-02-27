package test;

import java.io.IOException;
import java.io.InputStream;

import entities.Student;
import mappers.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

public class MyTest {

    @Test
    public void testInsert() throws IOException{
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        Student student1 =Student.builder().name("luwei").age(22).score(100).build();
        Student student2 =Student.builder().name("oia").id(1).build();
        Student student3 =Student.builder().id(5).build();
        Student student4 =Student.builder().id(1).build();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        //增加一行数据
        session.insert("insert",student1);
        //更改数据
        session.update("update",student2);
        //删除数据
        session.delete("delete",student3);
        //查询数据
        Student student =mapper.getUser(1);
        //输出查询结果git
        System.out.println(student);
        //Student(id=1, name=oia, age=5, score=88.0)
        session.commit();
    }
}