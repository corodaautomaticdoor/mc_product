package com.coroda.dao;

import com.coroda.model.Product;
import com.coroda.model.RequestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
@Repository
@Transactional
public class Querys  {
//    @Autowired
//    protected JdbcTemplate jdbcTemplate;
//
//   public List<Product> search(RequestBean requestBean) throws Exception{
//       StringBuilder sb = new StringBuilder();
//       ArrayList<Object> parametros = new ArrayList<>();
//       String query;
//           sb.append("  SELECT p.id,p.nombre,p.material,p.costo");
//       sb.append("  FROM product p");
//       if (requestBean.getId() != "") {
//           String[] subThemes = requestBean.getId().split(",");
//           sb.append("	AND ad.id in ( ");
//           for (int i = 0; i < subThemes.length; i++) {
//               sb.append("?,");
//               parametros.add(subThemes[i]);
//           }
//
//           query = sb.toString();
//           query = query.substring(0, query.length() - 1);
//           sb = new StringBuilder();
//           sb.append(query);
//           sb.append("	) ");
//       }
//       sb.append("SELECT p.id,p.nombre,p.material,p.costo");
//       sb.append("ORDER BY p.id  ;");
//
//       Object[] parameterList = parametros.toArray();
//       return this.jdbcTemplate.query(sb.toString(), parameterList, getRowMapper());
//    }

}
