package com.cc.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cc.model.Section;

public class JDBC {
	
        private static String driver = "com.mysql.jdbc.Driver";
        
        private static String url = "jdbc:mysql://localhost:3306/crm?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&useOldAliasMetadataBehavior=true";

        private static String user = "root";
        
        private static String password = "root";
        
        private static Connection  connection = null;
        /*
         * 获取connetion
         */
        private static Connection getConnetion() {
        	//if(connection == null) {
        	   try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
			   } catch (Exception e) {
				e.printStackTrace();
			    }
        	//}
			return connection;
        }
        /*
         * 关闭流
         */
        private static void closeAll(Connection c,Statement s,ResultSet r) {
         try {
        	    if(r != null)  r.close();
			} catch (SQLException e) { e.printStackTrace(); 
			 }finally {
					try {
						 if(s != null) s.close();
					} catch (SQLException e) { e.printStackTrace();
				    	}finally {
							try {
								 if(c != null)	c.close();
								} catch (SQLException e) { e.printStackTrace(); }
				    	}
			     }
           }
        
        /*
         * 万能更新(插入、更新、删除)
         */
        public static int  update(String  sql,Object...param) {
        	 int row = 0;
        	 Connection conn = null;
        	 PreparedStatement ps = null;
        	try {
				Class.forName(driver);
				 //conn = DriverManager.getConnection(url, user, password);
				 conn = getConnetion();
				 ps = conn.prepareStatement(sql);
				for(int i = 0; i < param.length;i++) {
					ps.setObject(i+1, param[i]);
				}
				row = ps.executeUpdate();
			  } catch (Exception e) {
				row = 0;
				e.printStackTrace();
			}finally {
				closeAll(conn,ps,null); 
			}
			return row;
			}
        
        /*
         * 这个不是万能的，只适合多条记录同时更新一个参数
         */
        public static int  update(String  sql,Object condition,Object[] param) {
        	 int row = 0;
        	 Connection conn = null;
        	 PreparedStatement ps = null;
        	try {
				Class.forName(driver);
				 //conn = DriverManager.getConnection(url, user, password); 
			
				 conn = getConnetion();
					 ps = conn.prepareStatement(sql);
					for(int i = 0,len=param.length; i < len;i++) {
						System.out.println(sql);
						System.out.println(condition+"\t"+param[i]);
						ps.setObject(1, condition);
						ps.setObject(2, param[i]);
						row = ps.executeUpdate();
					 }
			  } catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeAll(conn,ps,null); 
			}
			return row;
			}
        
        /*
          * 万能更新(插入、更新、删除)参数为集合
         */
//        public static int[]  update(String  sql,List<DataModel> datas) {
//        	 int[] row = null;
//        	 Connection conn = null;
//        	 PreparedStatement ps = null;
//        	try {
//				Class.forName(driver);
//				 //conn = DriverManager.getConnection(url, user, password);
//				 conn = getConnetion();
//				  ps = conn.prepareStatement(sql);
//				  for(DataModel d : datas ) {
//					    ps.setObject(1, d.getName());
//						ps.setObject(2, d.getLast_modify_time());
//						ps.setObject(3, d.getPm10());
//						ps.setObject(4, d.getPm25());
//						ps.setObject(5, d.getMonitor_station());
//						ps.setObject(6, d.getLast_modify_time());
//						ps.addBatch();
//				   }
//				  row =	ps.executeBatch();
//				
//			  } catch (Exception e) {
//				e.printStackTrace();
//			}finally {
//				closeAll(conn,ps,null); 
//			}
//			return row;
//			}
        /*
         * 万能查询
         */
       public static <E> List<E> query(String sql,Class c,Object...param) {
    	   List<E> datas = new ArrayList<>();
    	   Connection conn = null;
      	   PreparedStatement ps = null;
      	   ResultSet rs = null;
      	try {
				Class.forName(driver);
				 conn = DriverManager.getConnection(url, user, password);
				  ps = conn.prepareStatement(sql);
				  for(int i = 0; i < param.length; i++ ) {
					  ps.setObject(i+1, param[i]);
				  }
                  rs = ps.executeQuery();
                  ResultSetMetaData rsm = rs.getMetaData();
                  while(rs.next()) {
                	  E obj = (E) c.newInstance();
                	  int count = rsm.getColumnCount();
                	  for(int i = 1; i <= count; i++) {
                		  String columnName = rsm.getColumnName(i);
                		  String methodName = "set"+columnName.substring(0, 1).toUpperCase()+columnName.substring(1);
                		  Field field =  c.getDeclaredField(columnName);
                		  Method method = c.getDeclaredMethod(methodName, field.getType());
                		 // System.out.println(methodName+"----"+columnName+"--"+field.getType());
                		  method.invoke(obj, rs.getObject(columnName));
                	  }
                	  datas.add(obj);
                  }
			  } catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeAll(conn,ps,rs); 
			}
		return datas;
       }
       
       public static List<Section> querySection(String sql,Object...param) {
    	   List<Section> datas = new ArrayList<>();
    	   Connection conn = null;
      	   PreparedStatement ps = null;
      	   ResultSet rs = null;
      	try {
				Class.forName(driver);
				 conn = DriverManager.getConnection(url, user, password);
				  ps = conn.prepareStatement(sql);
				  for(int i = 0; i < param.length; i++ ) {
					  ps.setObject(i+1, param[i]);
				  }
                  rs = ps.executeQuery();
                  ResultSetMetaData rsm = rs.getMetaData();
                  while(rs.next()) {
                	  Section section = new Section();
                	  section.setId(rs.getInt("id"));
                	  section.setName(rs.getString("name"));
                	  section.setTime(rs.getDate("time"));
                	  section.setPeopleCount(rs.getInt("peopleCount"));
                	  section.setManager(rs.getString("manager"));
                	  datas.add(section);
                  }
			  } catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeAll(conn,ps,rs); 
			}
		return datas;
       }

       /*
          * 返回记录的数量
        */
      public static int getCount(String sql,Object...param) {
   	       Connection conn = null;
     	   PreparedStatement ps = null;
     	   ResultSet rs = null;
     	   int count = 0;
     	try {
				Class.forName(driver);
				 conn = DriverManager.getConnection(url, user, password);
				  ps = conn.prepareStatement(sql);
				  for(int i = 0; i < param.length; i++ ) {
					  ps.setObject(i+1, param[i]);
				  }
                 rs = ps.executeQuery();
                 if(rs.next()) {
                    count = rs.getInt(1);
                 }
			  } catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeAll(conn,ps,rs); 
			}
		return count;
      }
      /**
       * 获取单个整数
       * @param sql
       * @param param
       * @return
       */
      public static int getInt(String sql,Object...param) {
    	  Connection conn = null;
    	  PreparedStatement ps = null;
    	  ResultSet rs = null;
    	  int count = 0;
    	  try {
    		  Class.forName(driver);
    		  conn = DriverManager.getConnection(url, user, password);
    		  ps = conn.prepareStatement(sql);
    		  for(int i = 0; i < param.length; i++ ) {
    			  ps.setObject(i+1, param[i]);
    		  }
    		  rs = ps.executeQuery();
    		  if(rs.next()) {
    			  count = rs.getInt(1);
    		  }
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  }finally {
    		  closeAll(conn,ps,rs); 
    	  }
    	  return count;
      }
      /*
       * 自由查询
       */
      public static ArrayList<Map> freeQuery(String sql,Object...param) {
    	  ArrayList<Map> datas = new ArrayList<>();
    	  Connection conn = null;
    	  PreparedStatement ps = null;
    	  ResultSet rs = null;
    	  try {
    		  Class.forName(driver);
    		  conn = DriverManager.getConnection(url, user, password);
    		  ps = conn.prepareStatement(sql);
    		  for(int i = 0; i < param.length; i++ ) {
    			  ps.setObject(i+1, param[i]);
    		  }
    		  rs = ps.executeQuery();
              ResultSetMetaData rsm = rs.getMetaData();
              while(rs.next()) {
            	  Map<Integer, Object> result = new HashMap<>();
            	  int count = rsm.getColumnCount();
            	  for(int i = 1; i <= count; i++) {
            		  //String columnName = rsm.getColumnName(i);
//            		  result.put(i, rs.getObject(columnName));
            		  result.put(i, rs.getObject(i));
//         		  System.out.println( rs.getObject(columnName)+"----"+columnName+"--");
            	  }
            	 datas.add(result);
    	     }
    	  }catch (Exception e) {
    		  e.printStackTrace();
    	  }finally {
    		  closeAll(conn,ps,rs); 
    	  }
    	  return datas;
      }


      /*
       * 返回表中第一个字符串类型的记录
       */
     public static String getString(String sql) {
    	 String str = "";
  	   Connection conn = null;
    	   PreparedStatement ps = null;
    	   ResultSet rs = null;
    	try {
				Class.forName(driver);
				 conn = DriverManager.getConnection(url, user, password);
				  ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                ResultSetMetaData rsm = rs.getMetaData();
                if(rs.next()) {
                    str = rs.getString(1);
                }
			  } catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeAll(conn,ps,rs); 
			}
		return str;
     }
      
}//类结束