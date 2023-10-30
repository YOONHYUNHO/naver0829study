package myshop.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import mysql.db.DbConnect;

public class MyShopDao {
  DbConnect db = new DbConnect();

  // 전체 출력
  public List<MyShopDto> getAllItems() {
    List<MyShopDto> list = new Vector<MyShopDto>();
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = """
            select * from myshop order by num  
            """;


    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        // 반드시 while문에 안에 선언
        MyShopDto dto = new MyShopDto(); 
        dto.setNum(rs.getInt("num"));
        dto.setItem(rs.getString("item"));
        dto.setPrice(rs.getInt("price"));
        dto.setPhoto(rs.getString("photo"));
        dto.setColor(rs.getString("color"));
        dto.setWriteDay(rs.getTimestamp("writeDay"));

        // list에 추가
        list.add(dto);

      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }

    return list;
  }

  // Insert - db 저장만 return 필요 x
  public void insertShop(MyShopDto dto) {
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;

    String sql = "insert into myshop(item, color, price, photo, writeday) values(?, ?, ?, ?, now()) ";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getItem());
      pstmt.setString(2, dto.getColor());
      pstmt.setInt(3, dto.getPrice());
      pstmt.setString(4, dto.getPhoto());
      // 실행
      pstmt.execute();
    } catch (SQLException e) {
      System.out.println("INSERT SQL문 오류 : " + e.getMessage());
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

  // delete 
  public void deleteShop(String num) {
    String sql = """
            delete FROM myshop WHERE num = ?
            """;
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, num);
      pstmt.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }


  public MyShopDto getItems(String num) {
    MyShopDto dto = new MyShopDto(); 
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = """
            select * from myshop where num = ?  
            """;


    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, num);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        // 반드시 while문에 안에 선언
        dto.setNum(rs.getInt("num"));
        dto.setItem(rs.getString("item"));
        dto.setPrice(rs.getInt("price"));
        dto.setPhoto(rs.getString("photo"));
        dto.setColor(rs.getString("color"));
        dto.setWriteDay(rs.getTimestamp("writeDay"));

        // list에 추가


      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      db.dbClose(rs, pstmt, conn);
    }

    return dto;
  }

  public void updateShop(MyShopDto dto) {

    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;

    String sql = """
              UPDATE myshop SET
              item = ?,
              photo = ?,
              price = ?,
              color = ?
              WHERE num = ?
            """;
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, dto.getItem());
      pstmt.setString(2, dto.getPhoto());
      pstmt.setInt(3, dto.getPrice());
      pstmt.setString(4, dto.getColor());
      pstmt.setInt(5, dto.getNum());      
      pstmt.execute();
    } catch (SQLException e) {
      System.out.println("UPDATE SQL문 오류 : " + e.getMessage());
    } finally {
      db.dbClose(pstmt, conn);
    }



  }
}
