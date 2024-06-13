package com.adepuu.moonrakerz.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "montrack")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "montrack.users_id_gen")
    @SequenceGenerator(name = "montrack.users_id_gen", sequenceName = "montrack.users_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 150)
    @NotNull
    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Size(max = 255)
    @Column(name = "display_name")
    private String displayName;

    @Size(max = 255)
    @Column(name = "avatar")
    private String avatar;

    @Size(max = 150)
    @Column(name = "quotes", length = 150)
    private String quotes;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @JsonIgnore
    @Size(max = 100)
    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "active_currency", nullable = false)
    private int currencyId;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

    @PreRemove
    protected void onDelete() {
        deletedAt = Instant.now();
    }
}