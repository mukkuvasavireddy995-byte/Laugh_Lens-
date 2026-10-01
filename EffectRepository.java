package com.laughlens.repository;
import com.laughlens.model.Effect;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EffectRepository {
    private final JdbcTemplate jdbcTemplate;
    public EffectRepository(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}
    public List<Effect> findAll(){
        return jdbcTemplate.query(
            "SELECT id,code,name,emoji,css_class,description FROM effects ORDER BY id",
            (rs,n)->new Effect(rs.getLong("id"),rs.getString("code"),rs.getString("name"),
                rs.getString("emoji"),rs.getString("css_class"),rs.getString("description")));
    }
}