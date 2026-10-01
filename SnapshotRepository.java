package com.laughlens.repository;
import com.laughlens.model.Snapshot;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SnapshotRepository {
    private final JdbcTemplate jdbcTemplate;
    public SnapshotRepository(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}

    public Snapshot save(String nickname,String effectCode,String caption){
        jdbcTemplate.update("INSERT INTO snapshots(nickname,effect_code,caption) VALUES (?,?,?)",
            nickname,effectCode,caption);
        return jdbcTemplate.queryForObject(
            "SELECT id,nickname,effect_code,caption,created_at FROM snapshots ORDER BY id DESC LIMIT 1",
            (rs,n)->new Snapshot(rs.getLong("id"),rs.getString("nickname"),rs.getString("effect_code"),
                rs.getString("caption"),rs.getTimestamp("created_at").toLocalDateTime()));
    }

    public List<Snapshot> findLatest(){
        return jdbcTemplate.query(
            "SELECT id,nickname,effect_code,caption,created_at FROM snapshots ORDER BY id DESC LIMIT 12",
            (rs,n)->new Snapshot(rs.getLong("id"),rs.getString("nickname"),rs.getString("effect_code"),
                rs.getString("caption"),rs.getTimestamp("created_at").toLocalDateTime()));
    }
}