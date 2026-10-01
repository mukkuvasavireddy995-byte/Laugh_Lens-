package com.laughlens.controller;
import com.laughlens.model.Effect;
import com.laughlens.model.Snapshot;
import com.laughlens.repository.EffectRepository;
import com.laughlens.repository.SnapshotRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final EffectRepository effectRepository;
    private final SnapshotRepository snapshotRepository;

    public ApiController(EffectRepository effectRepository,SnapshotRepository snapshotRepository){
        this.effectRepository=effectRepository; this.snapshotRepository=snapshotRepository;
    }

    @GetMapping("/effects")
    public List<Effect> effects(){return effectRepository.findAll();}

    @GetMapping("/snapshots")
    public List<Snapshot> snapshots(){return snapshotRepository.findLatest();}

    @PostMapping("/snapshots")
    public ResponseEntity<Snapshot> save(@Valid @RequestBody SnapshotRequest r){
        return ResponseEntity.ok(snapshotRepository.save(r.nickname().trim(),r.effectCode().trim(),
            r.caption()==null?"":r.caption().trim()));
    }

    public record SnapshotRequest(
        @NotBlank @Size(max=50) String nickname,
        @NotBlank @Size(max=40) String effectCode,
        @Size(max=180) String caption) {}
}