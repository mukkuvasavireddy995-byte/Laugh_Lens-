package com.laughlens.model;
import java.time.LocalDateTime;
public record Snapshot(Long id,String nickname,String effectCode,String caption,LocalDateTime createdAt) {}